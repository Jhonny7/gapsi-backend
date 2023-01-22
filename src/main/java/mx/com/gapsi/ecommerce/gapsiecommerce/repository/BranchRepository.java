package mx.com.gapsi.ecommerce.gapsiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Branch;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{
    
}
