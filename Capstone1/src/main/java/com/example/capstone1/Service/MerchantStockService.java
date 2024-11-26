package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final ProductService product;
    private final MerchantService merchant;
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();


    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public int addMerchantStock(MerchantStock merchantStock ) {
            for(Product p : product.products ) {
                if (!p.getProductId().equals(merchantStock.getProductId())) {
                    return 1;
                }
            }
                for (Merchant m : merchant.merchants) {
                    if (!m.getMerchantId().equals(merchantStock.getMerchantId())) {
                        return -1;
                    }
                }
        merchantStocks.add(merchantStock);
        return 0;

    }

    public boolean updateMerchantStock(String id ,MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantId().equals(id)) {
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchantStock(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (id.equals(merchantStocks.get(i).getId())) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }


    public int addStock(String merchantId  ,String productId , int stock  ) {
        for (int i = 0; i < merchant.merchants.size(); i++) {
            if (!merchant.merchants.get(i).getMerchantId().equals(merchantId)) {
                return 0;
            }
        }
            for (Product product : product.products) {
                if (!product.getProductId().equals(productId))
                    return 1;
            }
            for (MerchantStock ms : merchantStocks) {
                if (ms.getMerchantId().equals(merchantId)) {
                        ms.setStock(ms.getStock()+stock);
                }else return 2;
            }
            return 3;
    }



}
