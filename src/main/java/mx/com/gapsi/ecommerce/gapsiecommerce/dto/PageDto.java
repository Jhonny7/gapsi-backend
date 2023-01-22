package mx.com.gapsi.ecommerce.gapsiecommerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageDto {
    private int numberOfElements;
    private List<ProviderResponse> providers;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private int size;
}
