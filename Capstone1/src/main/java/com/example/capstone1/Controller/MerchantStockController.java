package com.example.capstone1.Controller;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merStock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;


    @GetMapping("/getMerchantStocks")
    public ResponseEntity getMerchantStocks() {
        return ResponseEntity.ok().body(merchantStockService.getMerchantStocks());
    }

    @PostMapping("/addMerchantStock")
    public ResponseEntity addMerchantStock(@RequestBody@Valid MerchantStock merchantStock) {
        int result = merchantStockService.addMerchantStock(merchantStock);
        if (result == 1) {
            return ResponseEntity.ok().body("Product id not found");
        }
        if (result == -1) {
            return ResponseEntity.ok().body("merchant id not found");
        }
            if (result == 0) {
                return ResponseEntity.ok().body("added is successful");
            }
            return ResponseEntity.ok().body("bad");

    }

    @PutMapping("/updateMerchantStock/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id, @RequestBody@Valid MerchantStock merchantStock) {
        boolean result = merchantStockService.updateMerchantStock(id, merchantStock);
        if (result) {
            return ResponseEntity.ok().body("update is successful");
        }
        return ResponseEntity.ok().body("update failed");
    }

    @DeleteMapping("/deleteMerchantStock/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id) {
        boolean result = merchantStockService.deleteMerchantStock(id);
        if (result) {
            return ResponseEntity.ok().body("delete is successful");
        }
        return ResponseEntity.ok().body("delete failed");
    }

    @PostMapping("/addStock/{merchantId}/{productId}/{stock}")
    public ResponseEntity addStock(@PathVariable String merchantId ,@PathVariable String productId ,@PathVariable int stock){

        int result = merchantStockService.addStock(merchantId,productId,stock);
        if (result == 0) {
            return ResponseEntity.ok().body("merchant Id  not found");
        }
        if (result == 1) {
            return ResponseEntity.ok().body("product Id  not found");
        }
        if (result == 2) {
            return ResponseEntity.ok().body("merchant Stocks  not found");
        }
        return ResponseEntity.ok().body("added is successful");
    }
}
