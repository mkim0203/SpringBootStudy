package com.example.demo.service;

import com.example.demo.model.QzJobStatus;
import com.example.demo.model.qz.BaseQzData;
import com.example.demo.scheduler.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Slf4j
@Service
public class QuartzService {
    SchedulerFactory _factory = new StdSchedulerFactory();
    Scheduler _scheduler = null;

    public QuartzService() {
        init();
    }

    private void init() {
        try {
            _scheduler = _factory.getScheduler();
            Boolean isRunning = ExecuteServiceRun();
            if(isRunning) log.debug("스케줄러 실행 실패");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public Boolean addJob() throws SchedulerException {

        if (_scheduler == null) return false;

        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("qz-job", "group1")
                //.setJobData(jobDataMap)
                .build();

        CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trggerName", "cron_trigger_group")
                .withSchedule(CronScheduleBuilder.cronSchedule("8 * * * * ?"))
                //                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?")) // 매일 오전 8시에서 오후 5시 사이에 격분마다 실행
                .forJob(jobDetail)
                .build();

        Set<Trigger> triggerSet = new HashSet<Trigger>();
        //triggerSet.add(simpleTrigger);
        triggerSet.add(cronTrigger);

        _scheduler.scheduleJob(jobDetail, triggerSet, false);

        return true;
    }

    public Boolean addJob(String name, Class<? extends Job> jobClass, String cronTime) throws SchedulerException {

        log.debug("run addJob =>" + name );
        if (_scheduler == null) return false;

        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity("qz-job-" + name, "group1")
                //.setJobData(jobDataMap)
                .build();

        CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trgger-" + name, "cron_trigger_group")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTime))
                //                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?")) // 매일 오전 8시에서 오후 5시 사이에 격분마다 실행
                .forJob(jobDetail)
                .build();

        Set<Trigger> triggerSet = new HashSet<Trigger>();
        //triggerSet.add(simpleTrigger);
        triggerSet.add(cronTrigger);

        _scheduler.scheduleJob(jobDetail, triggerSet, false);

        return true;
    }

    public <T extends BaseQzData> Boolean addJob(String name, Class<? extends Job> jobClass, String cronTime, T data) throws SchedulerException {

        log.debug("run addJob =>" + name );
        if (_scheduler == null) return false;

        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity("qz-job-" + name, "group1")
                //.setJobData(jobDataMap)
                .build();

        if(data != null) {
            JobDataMap dataMap = jobDetail.getJobDataMap();
            dataMap.put("param", data);
        }

        CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trgger-" + name, "cron_trigger_group")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTime))
                //                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?")) // 매일 오전 8시에서 오후 5시 사이에 격분마다 실행
                .forJob(jobDetail)
                .build();

        Set<Trigger> triggerSet = new HashSet<Trigger>();
        //triggerSet.add(simpleTrigger);
        triggerSet.add(cronTrigger);

        _scheduler.scheduleJob(jobDetail, triggerSet, false);

        return true;
    }

    public List<QzJobStatus> getAllJobs() {
        try {
            List<String> allGroupNames = _scheduler.getJobGroupNames();

            List<QzJobStatus> allJobs = new ArrayList<>();
            for (String groupName : allGroupNames) {
                for (JobKey jobKey : _scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    JobDetail detail = _scheduler.getJobDetail(jobKey);


                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) _scheduler.getTriggersOfJob(jobKey);
                    Trigger firstTrigger = triggers.get(0);
                    //firstTrigger
                    Date nextFireTime = firstTrigger.getNextFireTime();

                    Trigger.TriggerState status = _scheduler.getTriggerState(firstTrigger.getKey());

//                System.out.println("[jobName] : " + jobName + " [groupName] : "
//                        + jobGroup + " - " + nextFireTime);

                    QzJobStatus addItem = new QzJobStatus();
                    if (firstTrigger instanceof CronTrigger) {
                        String cronExpression = ((CronTrigger) firstTrigger).getCronExpression();
                        //log.debug(cronExpression);
                        addItem.setCrontab(cronExpression);
                    }

                    addItem.setName(jobName);
                    addItem.setTiggerName(firstTrigger.getKey().getName());
                    addItem.setNextRunningTime(nextFireTime);
                    addItem.setStatus(status);
                    addItem.setJobData(detail.getJobDataMap());
                    allJobs.add(addItem);

                }
            }

            //log.debug( StringUtils.join(allGroupNames, ','));
            return allJobs;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 작업 crontab 변경
     * @param name
     * @param crontab
     * @return
     */
    public Boolean updateJobCrontab(String name, String crontab) {
        // name 기준으로 job 정보 조회, jobkey 필요
        //
        if(!isCrontab(crontab)) return false;

        try {
            List<String> allGroupNames = _scheduler.getJobGroupNames();

            List<QzJobStatus> allJobs = new ArrayList<>();
            for (String groupName : allGroupNames) {
                for (JobKey jobKey : _scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    if(jobName.equals(name)) {
                        //JobDetail jobDetail = _scheduler.getJobDetail(jobKey);
                        Trigger oldTrigger = _scheduler.getTriggersOfJob(jobKey).get(0); // 예제에서는 간단하게 첫 번째 트리거를 가져옴

                        // 새로운 트리거 생성
                        Trigger newTrigger = TriggerBuilder.newTrigger()
                                .withIdentity(oldTrigger.getKey())
                                .withSchedule(CronScheduleBuilder.cronSchedule(crontab))
                                .build();

                        // 스케줄러에서 기존 트리거를 제거하고 새로운 트리거로 대체
                        _scheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);

                        return true;
                    }

                }
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    /**
     * 작업 삭제
     * @param name 작업 이름
     * @return 삭제 성공 여부
     */
    public Boolean removeJob(String name) {
        try {
            log.debug("qz 작업 중지 :" + name);
            List<String> allGroupNames = _scheduler.getJobGroupNames();

            for (String groupName : allGroupNames) {
                for (JobKey jobKey : _scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    if (jobName.equals(name)) {
                        log.debug("삭제 대상 작업 찾음.");
                        // pause 를 하면 작업에 남아 있음. 삭제 하여 job 목록에서 제거할예정
                        //_scheduler.pauseJob(JobKey.jobKey(jobName, jobGroup));
                        _scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
                        return true;
                    }

                }
            }

            //_scheduler.shutdown();
            //Thread.sleep(2000);
            //_scheduler.start();
            return false;

        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public Boolean IsRunning() {
        try {
            if (_scheduler != null) {
                return _scheduler.isStarted();
            }
        } catch (SchedulerException schEx) {
            log.error(schEx.getMessage());
        }
        return false;
    }

    public Boolean ExecuteServiceRun() {
        try {
            if (_scheduler != null) {
                _scheduler.start();
                return true;
            }
        } catch (SchedulerException schEx) {
            log.error(schEx.getMessage());
        }
        return false;
    }

    public Boolean isCrontab(String crontab) {
        try {
            // cron 표현식을 파싱하여 유효성을 체크

            boolean isValid = CronExpression.isValidExpression(crontab);

            if (isValid) {
                return true;
            }
        } catch (Exception e) {
            log.error("Error parsing cron expression: " + e.getMessage());
        }
        return false;
    }
}
