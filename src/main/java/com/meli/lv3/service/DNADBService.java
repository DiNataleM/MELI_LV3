package com.meli.lv3.service;

import com.meli.lv3.db.dao.DNADao;
import com.meli.lv3.model.DNAModel;
import com.meli.lv3.model.StatisticsDNA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class DNADBService {

    private static final Logger logger = LogManager.getLogger(DNADBService.class);

    @Autowired
    private DNADao checkedDao;

    @Async
    public void persistDNA(DNAModel dna, boolean isMutant) {
        try {

            if (!checkedDao.exist(dna)) {
                checkedDao.save(dna, isMutant);
            }

        } catch (Exception e) {
            logger.error("Persis DNA error.", e);
        }
    }

    public StatisticsDNA findStatistic() {
        return checkedDao.findStatistic();
    }
}
