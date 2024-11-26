package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

@NotEmpty(message = "Product ID can not be Empty")
@Size(min = 1, max =10 , message = "Enter between 1 to 10")
private String productId;
@NotEmpty(message = "Product Name can not be Empty")
@Size(min = 4 , max = 30 , message = "Enter Name between 4 to 30")
private String productName;
@NotNull(message = "Product price can not be null")
@Positive(message = "Price must be positive number")
private double productPrice;
@NotEmpty(message = "category ID can not be Empty")
@Size(min = 1 , max = 10 , message = "Enter category ID between 1 to 10")
private String categoryId;



}
