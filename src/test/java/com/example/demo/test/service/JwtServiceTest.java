package com.example.demo.test.service;

import com.example.demo.common.aop.RunningLog;
import com.example.demo.common.jwt.JwtManager;
import com.example.demo.test.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTest extends BaseTest {
    @Autowired
    JwtManager _jwtService;
    @Test
    public void 토큰생성() {
        var result = _jwtService.generateJwtToken("mkim", "USER");
        WriteLog(result);
    }

    @Test
    public void 토큰정상확인() {
        var result = _jwtService.generateJwtToken("mkim", "USER");
        _jwtService.checkJwtToken(result);
    }

    @Test
    public void 토큰에서_사용자정보_가져오기() {
        var result = _jwtService.generateJwtToken("mkim", "USER");
        String userId = _jwtService.getUserIdFromToken(result);
        WriteLog(userId);
    }


    // aspect juint에서 안됨
//    @RunningLog
    @Test
    public void 토큰에서_룰정보_가져오기() {
        var result = _jwtService.generateJwtToken("mkim", "USER");
        String rule = _jwtService.getMemberRoleSetFromToken(result);
        WriteLog(rule);
    }

}
