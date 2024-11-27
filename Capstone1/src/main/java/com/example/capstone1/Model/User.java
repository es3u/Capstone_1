package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {
//    @NotEmpty(message = "User ID can not be Empty")
//   @Min(1)
//    @Max(10)
    private String UserID ;
//    @NotEmpty(message = "UserName can not be Empty")
//   @Min(3)
//    @Max(20)
    private String UserName ;
//    @NotEmpty(message = "Password can not be Empty")
//    @Min(1)
//    @Max(20)
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$" ,
//            message = "Password must be at least 8 characters long, include uppercase and lowercase letters, a digit, and a special character.")
    private String Password ;
//    @NotEmpty(message = "Email can not be Empty")
//    @Email
    private String email ;
//    @NotEmpty(message = "Role can not be Empty")
//    @Pattern(regexp = "^(Admin|Customer)$" , message = "must be Enter between admin and Customer")
    private String Role ;

//    @NotNull(message = "balance can not be null")
//    @Positive(message = "must be positive number")
    private double balance ;


   private final ArrayList<Product> getBuy = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();

    public void setbuy(Product product){
        getBuy.add(product);
    }

    public ArrayList<Product> getGetBuy() {
        return getBuy;
    }

    public void setproducts(Product p) {
        products.add(p);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }



}
