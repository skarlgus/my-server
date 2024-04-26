package com.kh.server.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService{

    private final TestService testService;

    public AsyncServiceImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void async() throws InterruptedException {

        log.info("======비동기 호출 시작");

        //비동기 호출
        CompletableFuture<AsyncUserA> futureA = testService.asyncTestA();
        CompletableFuture<AsyncUserB> futureB = testService.asyncTestB();

        //비동기 대기

        //비동기 결과 후처리

        log.info("======비동기 호출 종료");
    }

}
