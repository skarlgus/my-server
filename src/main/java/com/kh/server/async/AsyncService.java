package com.kh.server.async;

import java.util.concurrent.ExecutionException;

public interface AsyncService {

    void async() throws InterruptedException, ExecutionException;
}
