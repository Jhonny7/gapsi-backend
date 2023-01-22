package mx.com.gapsi.ecommerce.gapsiecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Branch;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;
import mx.com.gapsi.ecommerce.gapsiecommerce.service.IBranchService;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/branch")
public class BranchController {
    
    private final IBranchService branchService;

    @GetMapping("/all")
    public ResponseEntity<List<Branch>> getBranches() throws GeneralException {
        //throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(branchService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id) throws GeneralException{
        return new ResponseEntity<>(branchService.findById(id), HttpStatus.OK);
    }
    
    
}
