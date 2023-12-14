package com.example.demo.model;

import com.example.demo.common.model.FormatTemplate;
import lombok.Data;
import org.quartz.Trigger;

import java.util.Date;
import java.util.Map;

@Data
public class QzJobStatus {
    private String name;
    private String tiggerName;
    private Date nextRunningTime;
    private Trigger.TriggerState status;
    private String nextFireTime;
    private Map jobData;
    private String crontab;
    public String getNextFireTime() {

        return FormatTemplate.fmtFullDate.format(nextRunningTime);
    }
}
