package com.example.capstone1.Controller;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;
    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid User user){
        userService.addUser(user);
        return ResponseEntity.ok().body("added user successfully");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable String id , @RequestBody@Valid User user){
        boolean b = userService.updateUser(id ,user) ;
        if(b){
            return ResponseEntity.ok().body("update user successfully");
        }
        return ResponseEntity.ok().body("update user failed");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        boolean b = userService.deleteUser(id);
        if(b){
            return ResponseEntity.ok().body("delete user successfully");

        }
        return ResponseEntity.ok().body("delete user failed");
    }

    @PostMapping("/buy/{userId}/{productId}/{merchantId}/")
    public ResponseEntity buy(@PathVariable String userId ,@PathVariable String productId ,@PathVariable String merchantId ){
        int result = userService.buy(userId ,productId ,merchantId );
        if(result == 0){
            return ResponseEntity.ok().body("user id is not found");
        }
        if(result == 1){
            return ResponseEntity.ok().body("product id is not found");
        }
        if(result == 2){
            return ResponseEntity.ok().body("merchant id is not found");
        }
        if(result == 3){
            return ResponseEntity.ok().body("merchant Stock id is not found");
        }
        if(result == 4){
            return ResponseEntity.ok().body("the product price is more than in your balance ");
        }

        return ResponseEntity.ok().body("buy is successfully");
    }

    @GetMapping("/getBuyProduct/{userId}/{productName}")
    public ResponseEntity getBuyProduct (@PathVariable String userId,@PathVariable String productName){

        if(userService.getBuyProduct(userId ,productName) == null){
            return ResponseEntity.badRequest().body("buyProduct is not found , check if product id and user id");
        }
        return ResponseEntity.ok().body(userService.getBuyProduct(userId ,productName));
    }

    @GetMapping("/getRangPriceCategory/{categoryId}/{p1}/{p2}")
    public ResponseEntity getRangPriceCategory(@PathVariable String categoryId,@PathVariable int p1 ,@PathVariable int p2){
        if(userService.getRangPriceCategory(categoryId ,p1 ,p2) == null){
            return ResponseEntity.badRequest().body("Rang Price of Category is not found , check if category and price id");
        }
        return ResponseEntity.ok().body(userService.getRangPriceCategory(categoryId ,p1 ,p2));
    }

    @PutMapping("/ReturnProduct/{userAdmin}/{userCustomer}/{productId}/{merchantId}")
    public ResponseEntity ReturnProduct(@PathVariable String userAdmin ,@PathVariable String userCustomer, @PathVariable String productId , @PathVariable String merchantId){
      String message =   userService.ReturnProduct(userAdmin ,userCustomer ,productId ,merchantId);
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/Favorites/{userId}/{productId}")
    public ResponseEntity Favorites(@PathVariable String userId ,@PathVariable String productId ){

        if(userService.Favorites(userId ,productId) == null){
            return ResponseEntity.badRequest().body("Favorites is not found");
        }
        return ResponseEntity.ok().body(userService.Favorites(userId ,productId));
    }

    @GetMapping("/generateRating/{userId}/{productId}")
    public ResponseEntity generateRating(@PathVariable String userId,@PathVariable String productId){
        return ResponseEntity.ok().body(userService.generateRating(userId ,productId));
    }







}
