package mx.com.gapsi.ecommerce.gapsiecommerce.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ProviderRequest {
    
    private Long id;
    private String name;
    @JsonProperty("last_name") 
    private String lastName;
    
}

/*
{
    name: "jj",
    last_name:"ejemplo"
}

*/