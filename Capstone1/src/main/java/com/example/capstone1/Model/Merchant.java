package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "ID can not be Empty")
    @Size(min = 1 , max = 10 , message = "Enter ID between 1 to 10 ")
    private String merchantId ;
    @NotEmpty(message = "Name can not be Empty")
    @Size(min = 3 , message = "Name must be more than 3 letters")
    private String merchantName ;


}
