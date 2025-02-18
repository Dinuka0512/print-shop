package com.edu.ijse.print_shop.bo.custom.impl;

import com.edu.ijse.print_shop.bo.custom.CustomerBO;
import com.edu.ijse.print_shop.dao.DAOFactory;
import com.edu.ijse.print_shop.dao.custom.CustomerDAO;
import com.edu.ijse.print_shop.dto.CustomerDTO;
import com.edu.ijse.print_shop.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOimpl implements CustomerBO {
    private CustomerDAO customerDao = (CustomerDAO) DAOFactory.getInstance().getDAOType(DAOFactory.getDAO.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers =customerDao.getAll();
        ArrayList<CustomerDTO> customerDTOS =new ArrayList<>();
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomer_ID(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getEmail(),
                    customer.getContact()
            );
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;
    }
}
