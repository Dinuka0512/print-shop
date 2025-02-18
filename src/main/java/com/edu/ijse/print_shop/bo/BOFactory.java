package com.edu.ijse.print_shop.bo;

import com.edu.ijse.print_shop.bo.custom.impl.CustomerBOimpl;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        if(boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum getBO{
        CUSTOMER
    }

    public SuperBO getBOType(getBO type){
        switch(type){
            case CUSTOMER -> {
                return new CustomerBOimpl();
            }
            default -> {
                return null;
            }
        }
    }

}
