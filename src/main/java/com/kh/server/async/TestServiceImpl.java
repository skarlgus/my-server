package com.kh.server.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TestServiceImpl implements TestService{

    @Override
    public CompletableFuture<AsyncUserA> asyncTestA() throws InterruptedException {

        for(int i=0; i<5; i++){
            log.info("asyncTestA 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return CompletableFuture.completedFuture(new AsyncUserA("아무개","30"));
    }

    @Override
    public CompletableFuture<AsyncUserB> asyncTestB() throws InterruptedException {

        for(int i=0; i<5; i++){
            log.info("asyncTestB 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return CompletableFuture.completedFuture(new AsyncUserB("골목대장","19900101"));
    }

}
