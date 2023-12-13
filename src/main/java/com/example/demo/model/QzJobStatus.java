package com.example.demo.model;

import lombok.Data;
import org.quartz.Trigger;

import java.util.Date;

@Data
public class QzJobStatus {
    private String name;
    private String tiggerName;
    private Date nextRunningTime;
    private Trigger.TriggerState status;
}
