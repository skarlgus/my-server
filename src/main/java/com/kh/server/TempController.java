package com.kh.server;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TempController {
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest) {
        return "현재 서버 포트 ::: "+httpServletRequest.getServerPort();
    }
}
