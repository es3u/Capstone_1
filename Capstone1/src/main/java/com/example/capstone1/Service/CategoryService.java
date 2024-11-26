package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public boolean updateCategory(String id ,Category category) {
       for(int i = 0; i < categories.size(); i++) {
           if (category.getCategoryId().equals(id)) {
               categories.get(i).setCategoryName(category.getCategoryName());
           }
       }
       return true;
    }

    public boolean deleteCategory(String id) {
        for (Category category : categories) {
            if(category.getCategoryId().equals(id)) {
                categories.remove(category);
            }
        }
        return true;
    }



}
