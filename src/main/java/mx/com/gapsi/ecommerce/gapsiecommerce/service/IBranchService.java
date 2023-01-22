package mx.com.gapsi.ecommerce.gapsiecommerce.service;

import java.util.List;

import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Branch;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBranchService {

    public Branch findById(Long id) throws GeneralException;

    public List<Branch> findAll() throws GeneralException;

}
