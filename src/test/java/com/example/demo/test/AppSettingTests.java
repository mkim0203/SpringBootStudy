package com.example.demo.test;

import com.example.demo.common.model.Settings;
import com.example.demo.common.model.settings.AppSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppSettingTests extends BaseTest {
    @Autowired
    AppSetting _appSetting;
    
    @Autowired
    Settings _settings;
    @Test
    public void Yaml_설정조회() {
        writeLog(_appSetting);
    }
    
    @Test
    public void Properties_설정조회() {
        writeLog(_settings);
    }
}
