package com.example.demo.test;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
//import org.springframework.web.reactive.function.client.WebClient;


@SpringBootTest
public class StringTests extends BaseTest {

    @Test
    void outputToString() {
        Object output = null;
        if(Objects.isNull(output)) writeDebug("[data null]");
        else writeDebug(output.toString());
    }

    @Test
    void outputStringValueOf() {
        Object output = null;
        if(Objects.isNull(output)) writeDebug("[data null]");
        else writeDebug(String.valueOf(output));
    }

    @Test
    void outputStringValueOf2() {
        Object output = "null";
        writeDebug(String.valueOf(output));
    }
}
