package com.example.capstone1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "ID can not be Empty")
    @Size(min = 1 , max = 10 )
    private String id;
    @NotEmpty(message = "Product ID can not be Empty")
    @Size(min = 1 , max = 10 )
    private String productId;
    @NotEmpty(message = "merchant ID can not be Empty")
    @Size(min = 1 , max = 10 )
    private String merchantId;
    @NotEmpty(message = "merchant Name can not be Empty")
    @Size(min = 1 , max = 10 )
    private String merchantName;
    @NotNull(message = "stock can not be Null")
    @Min(10)
    private Integer stock;

}
