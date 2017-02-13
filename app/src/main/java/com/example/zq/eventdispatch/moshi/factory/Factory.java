package com.example.zq.eventdispatch.moshi.factory;

import com.example.zq.eventdispatch.moshi.product.Product;

/**
 * Created by stevenzhang on 2017/2/13 0013.
 */

public abstract  class Factory {

    /**
     * 抽象工厂方法
     * 具体生产什么子类去实现
     * 
     * 定义一个创建对象的接口
     * @return 具体的产品对象
     */
    
//    public abstract Product creatProduct();
    
    public abstract  <T extends Product> T createProduct (Class<T> clz);
    
    
    
    
    
}
