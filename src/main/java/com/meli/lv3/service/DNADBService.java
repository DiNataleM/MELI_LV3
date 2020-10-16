package com.meli.lv3.service;

import com.meli.lv3.db.dao.DNADao;
import com.meli.lv3.model.DNAModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class DNADBService {

    @Autowired
    private DNADao checkedDao;

    @Async
    public void persistIsMutant(DNAModel dna, boolean isMutant) {
        if (!checkedDao.exist(dna)) {
            checkedDao.save(dna, isMutant);
        }
    }

}
