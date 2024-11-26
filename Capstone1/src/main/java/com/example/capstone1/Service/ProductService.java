package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
        ArrayList<Product> products = new ArrayList<>();

       private final CategoryService category;

    public ArrayList<Product> getProducts() {
            return products;
    }

    public boolean addProduct(Product product ) {
            for (Category c :category.categories ){
                if(c.getCategoryId().equals(product.getCategoryId())){
                    products.add(product);
                    return true;
                }
            }
            return false;

    }

    public boolean updateProduct(String id , Product product) {
       for(Product p : products) {
           if (p.getProductId().equals(id)) {
               p.setProductName(product.getProductName());
               return true;
           }
       }
       return false;
    }

    public boolean removeProduct(String id) {
       for(Product p : products) {
           if (p.getProductId().equals(id)) {
               products.remove(p);
           }
       }
       return true;
    }

}
