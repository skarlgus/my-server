package com.kh.server.async;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface TestService {

    @Async
    CompletableFuture<AsyncUserA> asyncMethodTestA() throws InterruptedException;
    @Async
    CompletableFuture<AsyncUserB> asyncMethodTestB() throws InterruptedException;

    CompletableFuture<TestJson> asyncNonBlocking();
    TestJson syncTest();
}
