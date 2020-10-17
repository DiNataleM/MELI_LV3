package com.meli.lv3.db.dao;

import com.meli.lv3.db.entity.DNA;
import com.meli.lv3.db.repository.DNARepository;
import com.meli.lv3.model.DNAModel;
import com.meli.lv3.model.StatisticsDNA;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DNADao {

    @Autowired
    private DNARepository repository;

    public void save(DNAModel dna, boolean isMutant) {
        DNA dnaChecked = new DNA();
        dnaChecked.setDna(StringUtils.join(dna.getDna()));
        dnaChecked.setIsMutant(isMutant);

        repository.save(dnaChecked);
    }

    public boolean exist(DNAModel dna) {
        return repository.existsByDna(StringUtils.join(dna.getDna()));
    }

    public StatisticsDNA findStatistic() {
        StatisticsDNA statisticsDNA = new StatisticsDNA();
        statisticsDNA.setTotalHuman(repository.getHumanCount());
        statisticsDNA.setTotalMutant(repository.getMutantCount());

        return statisticsDNA;
    }
}
