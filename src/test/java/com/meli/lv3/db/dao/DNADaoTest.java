package com.meli.lv3.db.dao;

import com.meli.lv3.db.entity.DNA;
import com.meli.lv3.db.repository.DNARepository;
import com.meli.lv3.model.DNAModel;
import com.meli.lv3.model.StatisticsDNA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DNADaoTest {

    @Mock
    private DNARepository repository;
    @InjectMocks
    private DNADao dnaDao;

    private ArgumentCaptor<DNA> captor = ArgumentCaptor.forClass(DNA.class);

    @Test
    public void save() {
        DNAModel dna = new DNAModel();
        dna.setDna(new String[]{"first", "second"});

        dnaDao.save(dna, true);

        verify(repository, times(1)).save(captor.capture());

        DNA result = captor.getValue();

        assertTrue(Arrays.equals(new String[]{"first", "second"}, result.getDna()));
        assertTrue(result.getIsMutant());
    }

    @Test
    public void exist() {
        DNAModel dna = new DNAModel();
        dna.setDna(new String[]{"first", "second"});

        dnaDao.exist(dna);

        verify(repository, times(1)).existsByDna(eq("first,second"));
    }

    @Test
    public void findStatistic() {
        when(repository.getHumanCount()).thenReturn(100);
        when(repository.getMutantCount()).thenReturn(40);

        StatisticsDNA result = dnaDao.findStatistic();

        assertEquals(100, result.getTotalHuman());
        assertEquals(40, result.getTotalMutant());
        assertTrue(Double.compare(0.4, result.getRatio()) == 0);

    }
}