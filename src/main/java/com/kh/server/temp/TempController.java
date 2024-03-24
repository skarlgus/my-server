package com.kh.server.temp;

import com.kh.server.formatter.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TempController {
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest) {
        //test-main
        return "현재 서버 포트 ::: "+httpServletRequest.getLocalPort();
    }

    @PostMapping(value = "/logging")
    public void logging(@RequestBody User user){
        //return "logging post response data";
    }
}
