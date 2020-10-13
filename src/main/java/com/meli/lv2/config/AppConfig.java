package com.meli.lv2.config;

import com.meli.lv2.service.MutantCheckerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class AppConfig {

    @Bean
    @RequestScope
    public MutantCheckerService mutantChecker() {
        return new MutantCheckerService();
    }
}
