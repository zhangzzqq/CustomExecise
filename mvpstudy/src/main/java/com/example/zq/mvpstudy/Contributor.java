//package com.example.zq.mvpstudy;
//
///**
// * Created by stevenzhang on 2017/2/13 0013.
// */
//
//public class Contributor extends BaseObservable{
//
//    private String login;
//    private int contributions;
//
//    @Bindable
//    public String getLogin(){
//        return login;
//    }
//
//    @Bindable
//    public int getContributions(){
//        return contributions;
//    }
//
//    public void setLogin(String login){
//        this.login = login;
//        notifyPropertyChanged(BR.login);
//    }
//
//    public void setContributions(int contributions){
//        this.contributions = contributions;
//        notifyPropertyChanged(BR.contributions);
//    }
//
//    @Override
//    public String toString() {
//        return login + ", " + contributions;
//    }
//}
