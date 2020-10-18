package com.meli.lv3.controller;

import com.meli.lv3.model.StatisticsDNA;
import com.meli.lv3.service.DNADBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class StatisticsController {

    @Autowired
    private DNADBService dnadbService;

    @GetMapping("/stats")
    @ResponseStatus(OK)
    public StatisticsDNA getStats() {
        return dnadbService.findStatistic();
    }
}
