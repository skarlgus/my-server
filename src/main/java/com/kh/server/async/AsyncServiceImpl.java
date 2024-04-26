package com.kh.server.async;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService{

    private final TestService testService;



    public AsyncServiceImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void asyncTypeA() throws InterruptedException, ExecutionException {

        log.info("======비동기 호출 시작");

        CompletableFuture<AsyncUserA> futureA = testService.asyncMethodTestA();
        CompletableFuture<AsyncUserB> futureB = testService.asyncMethodTestB();

        //비동기 대기
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureA, futureB);
        combinedFuture.get();

        //비동기 결과 후처리
        AsyncUserA asyncUserA = futureA.get();
        AsyncUserB asyncUserB = futureB.get();

        log.info("이름 : {}",asyncUserA.getName());
        log.info("닉네임 : {}",asyncUserB.getNickName());

        log.info("======비동기 호출 종료");
    }

    @Override
    public void asyncTypeB() throws InterruptedException, ExecutionException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        CompletableFuture<TestJson> testJsonA = testService.asyncNonBlocking();
        CompletableFuture<TestJson> testJsonB = testService.asyncNonBlocking();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(testJsonA, testJsonB);
        combinedFuture.get();

        combinedFuture.thenRun(() -> {
            try {
                TestJson response1 = testJsonA.get();
                TestJson response2 = testJsonB.get();

                //log.info("testJsonA 호출 : {}",response1);
                //log.info("testJsonB 호출 : {}",response2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        stopwatch.stop();
        log.info("time ::: {}",stopwatch.toString());

    }

    @Override
    public void syncTypeC(){

        Stopwatch stopwatch = Stopwatch.createStarted();

        TestJson testJsonA = testService.syncTest();
        TestJson testJsonB = testService.syncTest();

        stopwatch.stop();
        log.info("time ::: {}",stopwatch.toString());

    }

}
