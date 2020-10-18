package com.meli.lv3.controller;

import com.meli.lv3.exception.InvalidMutantDnaException;
import com.meli.lv3.model.DNAModel;
import com.meli.lv3.model.ErrorResponse;
import com.meli.lv3.service.DNADBService;
import com.meli.lv3.service.MutantCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class    MutantCheckerController {

    @Autowired
    private MutantCheckerService checkerService;

    @Autowired
    private DNADBService dnadbService;

    @PostMapping("/mutant")
    @ResponseStatus(OK)
    public ResponseEntity isMutant(@RequestBody DNAModel dna) {
        boolean isMutant = checkerService.isMutant(dna.getDna());

        dnadbService.persistDNA(dna, isMutant);

        return new ResponseEntity((isMutant) ? OK : FORBIDDEN);
    }

    @ExceptionHandler(InvalidMutantDnaException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse invalidParamter(InvalidMutantDnaException e) {
        return new ErrorResponse(e.getMessage(), BAD_REQUEST);
    }
}
