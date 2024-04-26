package com.kh.server.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService{

    @Override
    public void async(){
        log.info("@@@");
    }

}
