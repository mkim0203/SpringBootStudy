package com.example.demo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class QzSche1Job implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("run QzSche1Job");
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Object paraData = dataMap.get("param");
        log.debug(paraData.toString());
    }
}
