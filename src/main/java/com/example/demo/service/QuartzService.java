package com.example.demo.service;

import com.example.demo.model.QzJobStatus;
import com.example.demo.scheduler.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

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
            _scheduler.start();
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

    public List<QzJobStatus> getAllJobs() {
        try {
            List<String> allGroupNames = _scheduler.getJobGroupNames();

            List<QzJobStatus> allJobs = new ArrayList<>();
            for (String groupName : allGroupNames) {
                for (JobKey jobKey : _scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) _scheduler.getTriggersOfJob(jobKey);
                    Trigger firstTrigger = triggers.get(0);
                    //firstTrigger
                    Date nextFireTime = firstTrigger.getNextFireTime();

                    Trigger.TriggerState status = _scheduler.getTriggerState(firstTrigger.getKey());

//                System.out.println("[jobName] : " + jobName + " [groupName] : "
//                        + jobGroup + " - " + nextFireTime);
                    QzJobStatus addItem = new QzJobStatus();
                    addItem.setName(jobName);
                    addItem.setTiggerName(firstTrigger.getKey().getName());
                    addItem.setNextRunningTime(nextFireTime);
                    addItem.setStatus(status);
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

    public Boolean IsRunning() throws SchedulerException {
        return _scheduler.isStarted();
    }

    public Boolean ExecuteServiceRun() throws SchedulerException {
        _scheduler.start();
        return true;
    }
}
