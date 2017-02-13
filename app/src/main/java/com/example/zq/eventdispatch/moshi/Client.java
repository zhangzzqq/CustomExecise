package com.example.zq.eventdispatch.moshi;

import com.example.zq.eventdispatch.moshi.factory.ConcreateFactory;
import com.example.zq.eventdispatch.moshi.factory.Factory;
import com.example.zq.eventdispatch.moshi.product.ConcreteProductB;
import com.example.zq.eventdispatch.moshi.product.Product;

/**
 * Created by stevenzhang on 2017/2/13 0013.
 */

public class Client {
    
    public static void main (String [] args){
        
        Factory factory = new ConcreateFactory();
//        Product p = factory.creatProduct();
        Product p = factory.createProduct(ConcreteProductB.class);
        p.method();
        
        
    }
}
