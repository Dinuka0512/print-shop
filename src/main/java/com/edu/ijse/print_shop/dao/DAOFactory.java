package com.edu.ijse.print_shop.dao;

import com.edu.ijse.print_shop.dao.custom.impl.CustomerDAOimpl;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum getDAO{
        CUSTOMER
    }

    public SuperDAO getDAOType(getDAO type){
        switch (type){
            case CUSTOMER -> {
                return new CustomerDAOimpl();
            }
            default -> {
                return null;
            }
        }
    }
}
