package com.meli.lv3.service;

import com.meli.lv3.db.dao.DNADao;
import com.meli.lv3.model.DNAModel;
import org.hibernate.HibernateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DNADBServiceTest {

    @Mock
    private DNADao checkedDao;

    @InjectMocks
    private DNADBService service;

    @Test
    public void testExist() {
        DNAModel dna = new DNAModel();

        when(checkedDao.exist(dna)).thenReturn(true);

        service.persistDNA(dna, true);

        verify(checkedDao, times(0)).save(any(DNAModel.class), anyBoolean());
    }

    @Test
    public void testNotExist_mutant() {
        DNAModel dna = new DNAModel();

        when(checkedDao.exist(dna)).thenReturn(false);

        service.persistDNA(dna, true);

        verify(checkedDao, times(1)).save(eq(dna), eq(true));
    }

    @Test
    public void testNotExist_human() {
        DNAModel dna = new DNAModel();

        when(checkedDao.exist(dna)).thenReturn(false);

        service.persistDNA(dna, false);

        verify(checkedDao, times(1)).save(eq(dna), eq(false));
    }

    /**
     * is @Async, only log it.
     */
    @Test
    public void testAnyError() {
        DNAModel dna = new DNAModel();

        when(checkedDao.exist(dna)).thenReturn(false);
        doThrow(new HibernateException("")).when(checkedDao).save(eq(dna), eq(false));

        service.persistDNA(dna, false);

        verify(checkedDao, times(1)).save(eq(dna), eq(false));
    }
}