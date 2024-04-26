package com.kh.server.async;

public interface TestService {

    AsyncUserA asyncTestA() throws InterruptedException;
    AsyncUserB asyncTestB() throws InterruptedException;
}
