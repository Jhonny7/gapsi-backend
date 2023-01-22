package mx.com.gapsi.ecommerce.gapsiecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Provider;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
    
    boolean existsByName(String name);
    
    List<Provider> findByName(String name);

}
