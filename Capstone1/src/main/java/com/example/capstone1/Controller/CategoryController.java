package com.example.capstone1.Controller;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getCategories")
    public ResponseEntity getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }
    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody @Valid Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.ok().body("Added Category is successfully ");
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity updateCategory(@PathVariable String id , @RequestBody @Valid Category category) {
        boolean b = categoryService.updateCategory(id, category);
        if (b) {
            return ResponseEntity.ok().body("Updated Category is successfully ");
        }else
        return ResponseEntity.ok().body("Update Category Failed");
    }
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id) {
        boolean b = categoryService.deleteCategory(id);
        if (b) {
            return ResponseEntity.ok().body("Deleted Category is successfully ");
        }
        return ResponseEntity.ok().body("Deleted Category Failed");
    }


}
