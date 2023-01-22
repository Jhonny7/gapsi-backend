package mx.com.gapsi.ecommerce.gapsiecommerce.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.PageDto;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderRequest;
import mx.com.gapsi.ecommerce.gapsiecommerce.dto.ProviderResponse;
import mx.com.gapsi.ecommerce.gapsiecommerce.entity.Provider;
import mx.com.gapsi.ecommerce.gapsiecommerce.exception.GeneralException;
import mx.com.gapsi.ecommerce.gapsiecommerce.repository.ProviderRepository;
import mx.com.gapsi.ecommerce.gapsiecommerce.service.IProviderService;
import org.springframework.http.HttpStatus;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements IProviderService {

    private final ProviderRepository providerRepository;

    @Override
    @Transactional(readOnly = true)
    public ProviderResponse findById(Long id) throws GeneralException {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new GeneralException("Provider not exist", HttpStatus.NOT_FOUND));
        return new ProviderResponse(
                provider.getName(),
                provider.getLastName(),
                provider.getCreateAt(),
                provider.getUpdateAt());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProviderResponse> findAll() throws GeneralException {
        return providerRepository.findAll().stream().map((provider) -> new ProviderResponse(
                provider.getName(),
                provider.getLastName(),
                provider.getCreateAt(),
                provider.getUpdateAt())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto findAll(int size, int page) throws GeneralException {

        try {
            Pageable paging = PageRequest.of(page, size);

            Page<ProviderResponse> pageProviders = providerRepository.findAll(paging)
                    .map((provider) -> new ProviderResponse(
                            provider.getName(),
                            provider.getLastName(),
                            provider.getCreateAt(),
                            provider.getUpdateAt()));

            return new PageDto(
                    pageProviders.getNumberOfElements(),
                    pageProviders.getContent(),
                    pageProviders.getPageable().getPageNumber(),
                    pageProviders.getPageable().getPageSize(),
                    pageProviders.getTotalPages(),
                    pageProviders.getTotalElements(),
                    pageProviders.getSize());
        } catch (Exception e) {
            throw new GeneralException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ProviderResponse save(ProviderRequest providerRequest) throws GeneralException {
        if (providerRepository.existsByName(providerRequest.getName())) {
            throw new GeneralException("provider exist", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Provider provider = providerRepository.save(new Provider(
                providerRequest.getName(),
                providerRequest.getLastName(),
                new Date()));

        return new ProviderResponse(
                provider.getName(),
                provider.getLastName(),
                provider.getCreateAt(),
                provider.getUpdateAt());
    }

    @Override
    public ProviderResponse update(ProviderRequest providerRequest) throws GeneralException {
        Provider provider = null;// Compare provider for // update

        try {
            provider = providerRepository.findByName(providerRequest.getName()).get(0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        
        Provider providerUpdate = providerRepository.findById(providerRequest.getId()).get();
        if (provider != null && !provider.equals(providerUpdate)) {
            throw new GeneralException("provider with name already exist", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        providerUpdate.setName(providerRequest.getName());
        providerUpdate.setLastName(providerRequest.getLastName());
        providerUpdate.setUpdateAt(new Date());
        providerRepository.save(providerUpdate);

        return new ProviderResponse(
                providerUpdate.getName(),
                providerUpdate.getLastName(),
                providerUpdate.getCreateAt(),
                providerUpdate.getUpdateAt());
    }

    @Override
    public Map<String, Object> delete(Long id) throws GeneralException {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            if (!providerRepository.findById(id).isPresent())
                throw new GeneralException("provider not exist", HttpStatus.UNPROCESSABLE_ENTITY);

            providerRepository.deleteById(id);
            response.put("deleted", true);

            return response;

        } catch (Exception e) {
            throw new GeneralException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
