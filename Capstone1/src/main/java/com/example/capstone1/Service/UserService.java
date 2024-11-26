package com.example.capstone1.Service;

import com.example.capstone1.Model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<Product> getBuy = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    private final MerchantService merchant;
    private final ProductService product;
    private final MerchantStockService merchantStock;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public boolean updateUser(String id ,User user) {
        for(User u : users) {
            if (u.getUserID().equals(id)) {
                u.setUserName(user.getUserName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String id) {
        for(User u : users) {
            if (u.getUserID().equals(id)) {
                users.remove(u);
                return true;
            }
        }
        return false;
    }


    public int buy(String userId , String productId , String merchantId ) {
//        Product p ;
//        for(User u : users) {
//            if (u.getUserID().equals(userId)) {
//                for (Product p : product.products) {
//                    if(p.getProductId().equals(productId)) {
//                        for (Merchant m : merchant.merchants) {
//                            if (m.getMerchantId().equals(merchantId)) {
//                                for (MerchantStock ms : merchantStock.merchantStocks) {
//                                    if (ms.getMerchantId().equals(merchantId)) {
//                                        ms.setStock(ms.getStock() - 1);
//                                        if (u.getBalance()>=p.getProductPrice()){
//                                            u.setBalance(u.getBalance()-p.getProductPrice());
//                                        }
//                                    }
//                                }
//                            }else return 1;
//                        }
//                    }else
//                        return -1;
//                }
//
//            }else
//                return 0;
//        }

        for(User u : users) {
            if (!u.getUserID().equals(userId)) {
                return 0;
            }
        }

        for (Product p : product.products) {
            if(!p.getProductId().equals(productId)) {
                return 1;
            }
        }

        for (Merchant m : merchant.merchants) {
            if (!m.getMerchantId().equals(merchantId)) {
                return 2;
            }
        }
        for (MerchantStock ms : merchantStock.merchantStocks) {
            if(ms.getStock()!=null) {
                ms.setStock(ms.getStock()-1);
            }else return 3;
        }

        for (User u : users) {
            if (u.getUserID().equals(userId)) {
                for (Product p : product.products) {
                if(p.getProductId().equals(productId)) {
                    if(u.getBalance() >= p.getProductPrice()){
                        u.setBalance(u.getBalance()-p.getProductPrice());
                        getBuy.add(p);
                    }else return 4;
                }
             }
            }
        }


                return 5;
            }












//////1
        public ArrayList<Product> getBuyProduct(String userId,String productName ) {
                ArrayList<Product> products = new ArrayList<>();


              for (Product p : product.products) {
                  if (!p.getProductName().equals(productName)) {
                      for (User u : users) {
                          if (!u.getUserID().equals(userId)) {
                              return null;
                          }
                      }

                  }
              }

            for(User u : users) {
                if (u.getUserID().equals(userId)) {
                    for ( Product p: getBuy) {
                        if(p.getProductName().equals(productName)){
                            products.add(p);
                        }

                    }

                }
            }
            return products;

        }

/////////2
        public ArrayList<Product> getRangPriceCategory(String categoryId,int p1 , int p2 ) {

        ArrayList<Product> products = new ArrayList<>();
        for(Product p : product.products ) {
            if(!p.getCategoryId().equals(categoryId)) {
               return null;
            }
          }
        if (p1 < 0 && p2 <0 && p1<p2){
            return null;
        }

        for (Product p : product.products) {
            if(p1>=p.getProductPrice() || p2<=p.getProductPrice()){
                products.add(p);
            }
        }
        return products;

        }

/////////3
        public String ReturnProduct(String userAdmin ,String userCustomer,  String productId , String merchantId){
            int stock = 0 ;
            double price = 0;
            for(User u : users) {
            if (u.getUserID().equals(userAdmin)) {
                if(!userAdmin.equals("Admin")) {
                    return "You do not have permission to edit.";
                }
            }else
                return "id admin isn't found";
        }

        for(User u : users) {
            if (u.getUserID().equals(userCustomer)) {
                if(!userCustomer.equals("Customer")) {
                    return "Log in with your user account ";
                }
            }else
                return "id customer isn't found";
        }

       for(Product p : product.products) {
           if(!p.getProductId().equals(productId)) {
               return "Product id isn't found";
           }
          price = p.getProductPrice();
       }
       for(MerchantStock m : merchantStock.merchantStocks) {
           if(!m.getMerchantId().equals(merchantId)) {
               return "Merchant id isn't found";
           }
           stock = m.getStock();
       }

       for(User u : users) {
           if(u.getUserID().equals(userCustomer)) {
               u.setBalance(u.getBalance()+price);
           }
       }

       for(MerchantStock m : merchantStock.merchantStocks) {
           if(m.getMerchantId().equals(merchantId)) {
               m.setStock(m.getStock()+stock);
           }
       }

       return "The amount has been refunded";
        }


        ///////4

    public ArrayList<Product> Favorites(String userId , String productId ) {
        ArrayList<Product> products = new ArrayList<>();
        for(User u : users) {
            if (!u.getUserID().equals(userId)) {
                for (Product p : product.products) {
                    if(!p.getProductId().equals(productId)) {
                        return null;
                    }
                }

            }
        }
        for(Product p : product.products) {
            if(p.getProductId().equals(productId)) {
                products.add(p);
            }
        }
        return products;
    }


    ////////////5




        public String generateRating(String userId, String productId) {
        Random random = new Random();

        for(User u : users) {
            if (!u.getUserID().equals(userId)) {
                return "user id isn't found";
            }
        }

        for (Product p : product.products) {
            if (!p.getProductId().equals(productId)) {
                return "product id isn't found";
            }
        }

            int rating = random.nextInt(5) + 1;
            String star = "*".repeat(rating);
            return star;
        }






























    }
