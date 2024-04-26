package com.kh.server.async;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface TestService {

    @Async
    CompletableFuture<AsyncUserA> asyncTestA() throws InterruptedException;
    @Async
    CompletableFuture<AsyncUserB> asyncTestB() throws InterruptedException;
}
