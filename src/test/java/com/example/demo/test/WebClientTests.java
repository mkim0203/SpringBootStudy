package com.example.demo.test;

import com.example.demo.test.models.SampleData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@SpringBootTest
public class WebClientTests  extends  BaseTest{
    @Test
    public void getRequest() {
        try {
            String url = "http://localhost:5121/users";
            WebClient webClient = WebClient.create(url);
            //String res = webClient.get().retrieve().bodyToMono(String.class).block();
            //writeDebug(res);
            WebClient.ResponseSpec response = webClient.get().retrieve();

            ResponseEntity<String> responseEntire =
                    //.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx Client Error")))
                    //.onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("5xx Server Error")))
                    response.toEntity(String.class)
                            .block();

            // 응답 코드와 응답 본문 출력
            writeDebug("Response Code: " + responseEntire.getStatusCode());
            writeDebug("Response Body: " + responseEntire.getBody());
        } catch (WebClientRequestException webRequestEx) {
            writeWebClientRequestException(webRequestEx);
        }
    }

    @Test void postRequest() {
        String url = "http://localhost:5121/users";

        String jsonData = "{  \"userId\": \"string\"," +
                "  \"userName\": \"string\"," +
                "  \"number\": 0," +
                "  \"isUsed\": true }";

        try {
            WebClient webClient = WebClient.create(url);
            WebClient.ResponseSpec response = webClient.post()
                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON) // 컨텐츠 타입 설정
                    .body(BodyInserters.fromValue(jsonData)).retrieve();

            ResponseEntity<String> responseEntire =
                    response.toEntity(String.class)
                            .block();

            // 응답 코드와 응답 본문 출력
            writeDebug("Response Code: " + responseEntire.getStatusCode());
            writeDebug("Response Body: " + responseEntire.getBody());
        } catch (WebClientResponseException webEx) {
            writeWebClientResponseException(webEx);
        } catch (WebClientRequestException webRequestEx) {
            writeWebClientRequestException(webRequestEx);
        }
    }

    @Test void postRequest_Model객체사용() {
        String url = "http://localhost:5121/users";
        SampleData sendData = new SampleData("terter", "테스터");

        try {
            WebClient webClient = WebClient.create(url);
            WebClient.ResponseSpec response = webClient.post()
                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON) // 컨텐츠 타입 설정
                    .body(BodyInserters.fromValue(sendData)).retrieve();

            ResponseEntity<String> responseEntire =
                    response.toEntity(String.class)
                            .block();

            // 응답 코드와 응답 본문 출력
            writeDebug("Response Code: " + responseEntire.getStatusCode());
            writeDebug("Response Body: " + responseEntire.getBody());
        } catch (WebClientResponseException webEx) {
            writeWebClientResponseException(webEx);
        } catch (WebClientRequestException webRequestEx) {
            writeWebClientRequestException(webRequestEx);
        }
    }

    @Test void deleteRequest() {
        String url = "http://localhost:5121/users";
        // status code 가 > 400 일때  catch 해서 체크하는게 제일 무난한듯.
        try {
            WebClient webClient = WebClient.create(url);
            WebClient.ResponseSpec response = webClient
                    .delete()
                    .uri(uriBuilder -> uriBuilder.path("/{id}")
                            .build("123"))
                    .retrieve();

            ResponseEntity<String> responseEntire = response
                    .toEntity(String.class).block();


            // 응답 코드와 응답 본문 출력
            writeDebug("Response Code: " + responseEntire.getStatusCode());
            writeDebug("Response Body: " + responseEntire.getBody());
        } catch (WebClientResponseException webEx) {
            writeWebClientResponseException(webEx);
        } catch (WebClientRequestException webRequestEx) {
            writeWebClientRequestException(webRequestEx);
        }
    }

    @Test void putRequest() {
        String url = "http://localhost:5121/users";

        String jsonData = "{  \"userId\": \"123\"," +
                "  \"userName\": \"string\"," +
                "  \"number\": 0," +
                "  \"isUsed\": true }";


        try {
            WebClient webClient = WebClient.create(url);
            WebClient.ResponseSpec response = webClient
                    .put()

                    .uri(uriBuilder -> uriBuilder.path("/{id}")
                            .build("123"))
                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON) // 컨텐츠 타입 설정
                    .body(BodyInserters.fromValue(jsonData))
                    .retrieve();

            ResponseEntity<String> responseEntire = response
                    .toEntity(String.class).block();


            // 응답 코드와 응답 본문 출력
            writeDebug("Response Code: " + responseEntire.getStatusCode());
            writeDebug("Response Body: " + responseEntire.getBody());
        } catch (WebClientResponseException webEx) {
            writeWebClientResponseException(webEx);
        } catch (WebClientRequestException webRequestEx) {
            writeWebClientRequestException(webRequestEx);
        }
    }
}
