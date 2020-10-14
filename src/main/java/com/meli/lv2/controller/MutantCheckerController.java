package com.meli.lv2.controller;

import com.meli.lv2.exception.InvalidMutantDnaException;
import com.meli.lv2.model.DnaModel;
import com.meli.lv2.model.ErrorResponse;
import com.meli.lv2.service.MutantCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class MutantCheckerController {

    @Autowired
    private MutantCheckerService mutantChecker;

    @GetMapping("/")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/mutant")
    @ResponseStatus(OK)
    public ResponseEntity isMutant(@RequestBody DnaModel dna) {
        if (mutantChecker.isMutant(dna.getDna())) {
            return new ResponseEntity(OK);
        }

        return new ResponseEntity(FORBIDDEN);
    }

    @ExceptionHandler(InvalidMutantDnaException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse invalidParamter(InvalidMutantDnaException e) {
        return new ErrorResponse(e.getMessage(), BAD_REQUEST);
    }
}
