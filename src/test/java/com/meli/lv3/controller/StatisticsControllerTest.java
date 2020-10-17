package com.meli.lv3.controller;

import com.meli.lv3.model.StatisticsDNA;
import com.meli.lv3.service.DNADBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsControllerTest {

    @Mock
    private DNADBService service;

    @InjectMocks
    private StatisticsController controller;

    @Test
    public void testGetStats() {
        StatisticsDNA statisticsDNA = new StatisticsDNA();
        statisticsDNA.setTotalHuman(100);
        statisticsDNA.setTotalMutant(40);
        when(service.findStatistic()).thenReturn(statisticsDNA);

        StatisticsDNA result = controller.getStats();

        assertEquals(100, result.getTotalHuman());
        assertEquals(40, result.getTotalMutant());
        assertEquals(0, Double.compare(0.4, result.getRatio()));
    }
}