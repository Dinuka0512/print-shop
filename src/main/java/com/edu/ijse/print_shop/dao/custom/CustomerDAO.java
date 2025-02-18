package com.edu.ijse.print_shop.dao.custom;

import com.edu.ijse.print_shop.controller.CustomerController;
import com.edu.ijse.print_shop.dao.CrudDAO;
import com.edu.ijse.print_shop.dao.SuperDAO;
import com.edu.ijse.print_shop.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer>, SuperDAO {
    boolean isEmailExist(String email) throws SQLException, ClassNotFoundException;
}
