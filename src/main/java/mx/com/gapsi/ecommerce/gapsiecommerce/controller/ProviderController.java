/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gapsi.ecommerce.gapsiecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.PageDto;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderRequest;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderResponse;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;
import mx.com.gapsi.ecommerce.gapsiecommerce.service.IProviderService;

/**
 *
 * @author olam
 */
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/provider")
public class ProviderController {
    private final IProviderService providerService;

    @GetMapping("/all")
    public ResponseEntity<List<ProviderResponse>> getProviders() throws GeneralException {
        //throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(providerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/paginable")
    public ResponseEntity<PageDto> getProvidersPaginable(
        @RequestParam(name = "size") int size, 
        @RequestParam(name = "page") int page) throws GeneralException {
        //throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(providerService.findAll(size, page), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProviderResponse> save(@RequestBody ProviderRequest providerRequest) throws GeneralException {
        return new ResponseEntity<>(providerService.save(providerRequest), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProviderResponse> update(@RequestBody ProviderRequest providerRequest) throws GeneralException {
        return new ResponseEntity<>(providerService.update(providerRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(providerService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponse> getById(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(providerService.findById(id), HttpStatus.OK);
    }

}
