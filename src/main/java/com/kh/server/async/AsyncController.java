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

    @PostMapping("/async")
    public void async() throws InterruptedException, ExecutionException {
        asyncService.async();
    }
}
