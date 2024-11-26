package com.example.capstone1.Controller;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody@Valid Product product){
        boolean result = productService.addProduct(product);
        if(result){
            return ResponseEntity.ok().body("add product success");
        }
        return ResponseEntity.badRequest().body("add product fail because product category is not exist");
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable String id,@RequestBody@Valid Product product){
        boolean result = productService.updateProduct(id,product);
        if(result== true){
            return ResponseEntity.ok().body("update product success");

        }
        return ResponseEntity.badRequest().body("update product fail");
    }

    @DeleteMapping("/removeProduct/{id}")
    public ResponseEntity removeProduct(@PathVariable String id){
        boolean result = productService.removeProduct(id);
        if(result){
            return ResponseEntity.ok().body("remove product success");

        }

        return ResponseEntity.badRequest().body("remove product fail");
    }


}
