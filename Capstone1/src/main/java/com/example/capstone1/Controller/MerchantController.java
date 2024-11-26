package com.example.capstone1.Controller;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/getMerchants")
    public ResponseEntity getMerchants(){
        return ResponseEntity.ok().body(merchantService.getMerchants());
    }
    @PostMapping("/addMerchant")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.ok().body("added merchant successfully");
    }
    @PutMapping("/updateMerchant/{id}")
    public ResponseEntity updateMerchant(@PathVariable@Valid String id ,@RequestBody@Valid Merchant merchant){
        boolean b = merchantService.updateMerchant(id,merchant);

        if (b){
            return ResponseEntity.ok().body("update success");
        }
        return ResponseEntity.ok().body("update fail");
    }
    @DeleteMapping("/deleteMerchant/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean b = merchantService.deleteMerchant(id);
        if (b){
            return ResponseEntity.ok().body("delete success");
        }
        return ResponseEntity.ok().body("delete fail");
    }


}
