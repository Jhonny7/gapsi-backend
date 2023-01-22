/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gapsi.ecommerce.gapsiecommerce.exception;

import lombok.extern.slf4j.Slf4j;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.GeneralStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author olam
 */
@ControllerAdvice @Slf4j
public class HandlerException {
    
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<GeneralStatus> handleGeneralException(GeneralException ge) {
        return new ResponseEntity<>(new GeneralStatus(ge.getCode(), ge.getMessage()), ge.getCode());
    }

}
