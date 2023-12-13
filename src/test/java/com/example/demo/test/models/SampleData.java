package com.example.demo.test.models;

import lombok.Data;

@Data
public class SampleData {
    private String userId;
    private String userName;
    private int number;
    private Boolean isUsed;

    public SampleData() {}

    public SampleData(String userId) {
        this(userId, "", 0, false);
    }

    public SampleData(String userId, String userName) {
        this(userId, userName, 0, false);
    }

    public SampleData(String userId, String userName, int number) {
        this(userId, userName, number, false);
    }


    public SampleData(String userId, String userName, int number, Boolean isUsed) {
        this.userId = userId;
        this.userName = userName;
        this.number = number;
        this.isUsed = isUsed;
    }
}
