package com.kh.server.async;

import java.util.concurrent.CompletableFuture;

public interface TestService {

    CompletableFuture<AsyncUserA> asyncTestA() throws InterruptedException;
    CompletableFuture<AsyncUserB> asyncTestB() throws InterruptedException;
}
