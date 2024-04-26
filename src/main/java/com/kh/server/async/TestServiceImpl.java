package com.kh.server.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TestServiceImpl implements TestService{

    private WebClient webClient;

    public TestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://naver.com").build();
    }

    @Override
    public CompletableFuture<AsyncUserA> asyncMethodTestA() throws InterruptedException {

        for(int i=0; i<5; i++){
            log.info("asyncTestA 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return CompletableFuture.completedFuture(new AsyncUserA("아무개","30"));
    }

    @Override
    public CompletableFuture<AsyncUserB> asyncMethodTestB() throws InterruptedException {

        for(int i=0; i<5; i++){
            log.info("asyncTestB 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return CompletableFuture.completedFuture(new AsyncUserB("골목대장","19900101"));
    }

    @Override
    public CompletableFuture<TestJson> asyncNonBlocking(){
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(TestJson.class)
                .toFuture();
    }

    @Override
    public TestJson syncTest(){
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(TestJson.class)
                .block();
    }

}
