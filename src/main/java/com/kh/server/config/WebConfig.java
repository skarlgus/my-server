package com.kh.server.config;

import com.kh.server.formatter.DecryptFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"com.kh.server"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("@@@@@@@@");
        registry.addFormatterForFieldAnnotation(new DecryptFormatter(""));
    }
}
