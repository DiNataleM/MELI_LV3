package com.meli.lv3.controller;

import com.meli.lv3.exception.InvalidMutantDnaException;
import com.meli.lv3.model.DNAModel;
import com.meli.lv3.model.ErrorResponse;
import com.meli.lv3.service.MutantCheckerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;

@RunWith(MockitoJUnitRunner.class)
public class MutantCheckerControllerTest {

    @Mock
    private MutantCheckerService mutantChecker;

    @InjectMocks
    private MutantCheckerController controller;

    @Test
    public void isMutant_true() {
        DNAModel dnaModel = new DNAModel();
        dnaModel.setDna(new String[]{});
        when(mutantChecker.isMutant(dnaModel.getDna())).thenReturn(true);

        ResponseEntity result = controller.isMutant(dnaModel);

        assertEquals(OK, result.getStatusCode());

    }

    @Test
    public void isMutant_false() {
        DNAModel dnaModel = new DNAModel();
        dnaModel.setDna(new String[]{});
        when(mutantChecker.isMutant(dnaModel.getDna())).thenReturn(false);

        ResponseEntity result = controller.isMutant(dnaModel);

        assertEquals(FORBIDDEN, result.getStatusCode());

    }

    @Test(expected = InvalidMutantDnaException.class)
    public void isMutant_Exception_doNothing() {
        DNAModel dnaModel = new DNAModel();
        dnaModel.setDna(new String[]{});
        when(mutantChecker.isMutant(dnaModel.getDna())).thenThrow(new InvalidMutantDnaException(""));

        controller.isMutant(dnaModel);

    }

    @Test
    public void invalidParamter() {
        String myError = "myError";
        InvalidMutantDnaException e = new InvalidMutantDnaException(myError);

        ErrorResponse result = controller.invalidParamter(e);

        assertEquals(myError, result.getMessage());
        assertEquals(BAD_REQUEST, result.getHttpStatus());
    }
}