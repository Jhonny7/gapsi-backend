/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gapsi.ecommerce.gapsiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @author olam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralStatus {
    
    //@Schema(description = "Code of result operation.", example = "201")
    private long code;

    //@Schema(description = "Message of result operation.", example = "Success")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public GeneralStatus(HttpStatus status) {
        this.status = status;
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

    public GeneralStatus(HttpStatus status, String message) {
        this.status = status;
        this.code = status.value();
        this.message = message;
    }

    public GeneralStatus(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
