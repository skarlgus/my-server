package com.kh.server.config;

import com.kh.server.formatter.DecryptFormatter;
import com.kh.server.interceptor.ServiceApiInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"com.kh.server"})
public class WebConfig implements WebMvcConfigurer {

    private final ServiceApiInterceptor serviceApiInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new DecryptFormatter(""));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serviceApiInterceptor)
                .addPathPatterns("/**");
    }
}
