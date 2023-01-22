package mx.com.gapsi.ecommerce.gapsiecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Branch;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;
import mx.com.gapsi.ecommerce.gapsiecommerce.repository.BranchRepository;
import mx.com.gapsi.ecommerce.gapsiecommerce.service.IBranchService;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements IBranchService{

    private final BranchRepository branchRepository;

    @Override
    @Transactional(readOnly = true)
    public Branch findById(Long id) throws GeneralException {
        return branchRepository.findById(id).orElseThrow(()-> new GeneralException("Branch not found", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Branch> findAll() throws GeneralException {
        try {
            return branchRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
