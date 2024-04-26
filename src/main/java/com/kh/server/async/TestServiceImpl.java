package com.kh.server.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestService{

    @Override
    @Async
    public AsyncUserA asyncTestA() throws InterruptedException {
        AsyncUserA r = new AsyncUserA();

        for(int i=0; i<5; i++){
            log.info("asyncTestA 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return r;
    }

    @Override
    @Async
    public AsyncUserB asyncTestB() throws InterruptedException {
        AsyncUserB r = new AsyncUserB();

        for(int i=0; i<5; i++){
            log.info("asyncTestB 메서드 실행중...["+i+"]");
            Thread.sleep(1000);
        }

        return r;
    }

}
