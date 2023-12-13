package com.example.demo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class JobScheduler {
    String _outputFmt = "[%s] [%s] 스케줄러 실행";
    SimpleDateFormat _dtFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/10 * * * * *")
    public void sec10Job() throws Exception {
        log.info(String.format(_outputFmt, _dtFmt.format(new Date()), "sec10Job"));
    }

    @Scheduled(cron = "0/20 * * * * *")
    public void sec20Job() throws Exception {
        log.info(String.format(_outputFmt, _dtFmt.format(new Date()), "sec20Job"));
    }

    @Scheduled(cron = "7 * * * * *")
    public void allMinSec7Job() throws Exception {
        log.info(String.format(_outputFmt, _dtFmt.format(new Date()), "allMinSec7Job"));
    }


    // error
//    @Scheduled(fixedDelay = 0)
//    public void myTask() {
//        log.info("1회용???");
//    }
}
