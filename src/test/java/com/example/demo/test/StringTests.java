package com.example.demo.test;

import org.apache.tomcat.websocket.AsyncChannelGroupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketTimeoutException;
import java.net.StandardProtocolFamily;
import java.nio.file.ClosedWatchServiceException;
import java.util.Objects;

@SpringBootTest
public class StringTests extends BaseTest {

    @Test
    void outputToString() {
        Object output = null;
        if(Objects.isNull(output)) WriteDebug("[data null]");
        else WriteDebug(output.toString());
    }

    @Test
    void outputStringValueOf() {
        Object output = null;
        if(Objects.isNull(output)) WriteDebug("[data null]");
        else WriteDebug(String.valueOf(output));
    }

    @Test
    void outputStringValueOf2() {
        Object output = "null";
        WriteDebug(String.valueOf(output));
    }
}
