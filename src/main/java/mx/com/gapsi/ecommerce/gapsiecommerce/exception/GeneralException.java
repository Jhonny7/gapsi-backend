/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gapsi.ecommerce.gapsiecommerce.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author olam
 */
public class GeneralException extends Exception{
    private final HttpStatus code;
    private final String error;

    public HttpStatus getCode() {
        return code;
    }

    public String getError() {
        return this.error;
    }

    public GeneralException(HttpStatus code) {
        this.code = code;
        this.error = null;
    }

    public GeneralException(String message, HttpStatus code) {
        super(message);
        this.code = code;
        this.error = null;
    }

}