package mx.com.gapsi.ecommerce.gapsiecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.gapsi.ecommerce.gapsiecommerce.dto.GapsiInformationDto;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;

@RestController
@RequestMapping("/data")
public class GapsiControllerAPI {

    @Autowired
    BuildProperties buildProperties;

    @GetMapping
    public ResponseEntity getVersion() throws GeneralException {
        // throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new GapsiInformationDto(
            buildProperties.getName(),
            buildProperties.getVersion(),
            "Juan López Sarrelangue"
        ), HttpStatus.OK);
    }
}
