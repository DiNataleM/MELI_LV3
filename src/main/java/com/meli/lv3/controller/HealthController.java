package com.meli.lv3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic controller to know if the api is working correctly.
 */
@RestController
public class HealthController {

    /**
     * Is working
     *
     * @return
     */
    @GetMapping("/")
    public String healthCheck() {
        return "OK";
    }

}
