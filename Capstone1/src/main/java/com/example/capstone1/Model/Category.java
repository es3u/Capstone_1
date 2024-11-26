package com.example.capstone1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

//    @NotEmpty(message = "category ID can not be Empty")
//    @Size(min = 1 , max = 10 , message = "Enter ID between 1 to 10")
    private String categoryId;
//    @NotEmpty(message = "Category Name can not be Empty")
//   @Min(value = 3 , message = "Enter the Name between 4 to 30")
    private String categoryName;
}
