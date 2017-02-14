package com.example.randomtest;

/**
 * Created by stevenzhang on 2017/2/11 0011.
 */

public class RandomTest {

    public static void main(String[] args) {
        
        // TODO Auto-generated method stub
        
        java.util.Random random = new java.util.Random();
        int length = random.nextInt(20);     //标识0~19包括0，不包括19   
        System.out.println("length=="+length);
        System.out.println("length2=="+ random.nextInt()); //int范围内任意长度

    }

}

