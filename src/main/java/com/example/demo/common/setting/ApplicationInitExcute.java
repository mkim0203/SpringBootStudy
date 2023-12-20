package com.example.demo.common.setting;

import com.example.demo.model.qz.QzSche1;
import com.example.demo.scheduler.QuartzJob;
import com.example.demo.scheduler.QzSche1Job;
import com.example.demo.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class ApplicationInitExcute {

    @Autowired
    QuartzService _qzService;

    /**
     *
     */
    @PostConstruct
    public void init() {
        // @PostConstruct 어노테이션은 특정 클래스의 메소드에 붙여서 해당 클래스의 객체 내 모든 의존성(Bean) 들이
        // 초기화 된 직후에 딱 한 번만 실행되도록 해준다.
        log.debug("1회 수행 테스트 : " + new Date().toString());


        try {
            // quartz 설정
            _qzService.addJob("job1", QuartzJob.class, "8 * * * * ?");
            _qzService.addJob("job2", QuartzJob.class, "22 * * * * ?");

            QzSche1 sche1Data = new QzSche1();
            sche1Data.setData1("AA");
            sche1Data.setData2(22);
            _qzService.addJob("sche1", QzSche1Job.class, "33 * * * * ?", sche1Data);
            //runQuartz();
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
        }
    }
}
