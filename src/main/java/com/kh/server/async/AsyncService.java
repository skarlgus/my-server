package com.kh.server.async;

import java.util.concurrent.ExecutionException;

public interface AsyncService {

    void asyncTypeA() throws InterruptedException, ExecutionException;
    void asyncTypeB() throws InterruptedException, ExecutionException;
    void syncTypeC();
}
