package com.kh.server.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    @PostMapping("/async-type-a")
    public void asyncTypeA() throws InterruptedException, ExecutionException {
        asyncService.asyncTypeA();
    }

    @PostMapping("/async-type-b")
    public void asyncTypeB() throws InterruptedException, ExecutionException {
        asyncService.asyncTypeB();
    }

    @PostMapping("/sync-type-c")
    public void syncTypeC() {
        asyncService.syncTypeC();
    }
}
