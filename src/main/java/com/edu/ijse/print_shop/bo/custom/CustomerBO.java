package com.edu.ijse.print_shop.bo.custom;

import com.edu.ijse.print_shop.bo.SuperBO;
import com.edu.ijse.print_shop.dao.DAOFactory;
import com.edu.ijse.print_shop.dao.custom.CustomerDAO;
import com.edu.ijse.print_shop.dto.CustomerDTO;
import com.edu.ijse.print_shop.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    boolean deleteCustomers(String id) throws SQLException,ClassNotFoundException;
    boolean isEmailExist(String email) throws SQLException, ClassNotFoundException;
    boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    String genarateId() throws SQLException, ClassNotFoundException;
    String getEmail(String id) throws SQLException, ClassNotFoundException;
}
