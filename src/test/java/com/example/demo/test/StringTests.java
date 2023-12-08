package com.example.demo.test;


import org.apache.tomcat.websocket.AsyncChannelGroupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.SocketTimeoutException;
import java.net.StandardProtocolFamily;
import java.nio.file.ClosedWatchServiceException;
import java.util.Objects;
//import org.springframework.web.reactive.function.client.WebClient;


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

    @Test
    void httpClientTest() {
//        Webclient webClient = WebClient
//                .builder()
//                .uriBuilderFactory(factory)
//                .baseUrl("http://localhost:8080")
//                .defaultCookie("쿠키","쿠키값")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();


        // Connection refused: no further information: localhost/127.0.0.1:8080
        // rest 동작중일때만 가능한듯 테스트 코드로 할수 있는 방법 찾아봐야할듯.
//        String url = "http://localhost:8080/hello";
//        //String url = "https://www.daum.net";
//        WebClient webClient = WebClient.create(url);
//        String res = webClient.get().retrieve().bodyToMono(String.class).block();
//        WriteDebug(res);
    }
}
