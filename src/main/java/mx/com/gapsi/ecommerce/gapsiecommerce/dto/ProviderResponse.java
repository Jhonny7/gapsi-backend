/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gapsi.ecommerce.gapsiecommerce.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author olam
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProviderResponse {
    
    private String name;

    private String lastName;

    private Date createAt; 

    private Date updateAt; 
}
