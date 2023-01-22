package mx.com.gapsi.ecommerce.gapsiecommerce.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import mx.com.gapsi.ecommerce.gapsiecommerce.dto.PageDto;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderRequest;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderResponse;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;

public interface IProviderService {

    ProviderResponse findById(Long id) throws GeneralException;

    List<ProviderResponse> findAll() throws GeneralException;

    PageDto findAll(int size, int page) throws GeneralException;

    ProviderResponse save(ProviderRequest providerRequest) throws GeneralException;

    ProviderResponse update(ProviderRequest providerRequest) throws GeneralException;

    Map<String, Object> delete(Long id) throws GeneralException;
}
