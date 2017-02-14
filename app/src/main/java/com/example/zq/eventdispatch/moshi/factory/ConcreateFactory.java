package com.example.zq.eventdispatch.moshi.factory;

import com.example.zq.eventdispatch.moshi.product.Product;

/**
 * Created by stevenzhang on 2017/2/13 0013.
 */

public class ConcreateFactory extends Factory {
   
    
    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
       
        Product p =null;
        
            try {
                p = (Product) Class.forName(clz.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T) p;
    }


//    @Override
//    public Product creatProduct() {
//        return new ConcreteProductA();
//    }
    
    
}
