package com.edu.ijse.print_shop.dao.custom.impl;

import com.edu.ijse.print_shop.dao.custom.CustomerDAO;
import com.edu.ijse.print_shop.entity.Customer;
import com.edu.ijse.print_shop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public boolean isEmailExist(String email) throws SQLException, ClassNotFoundException {
        String sql = "select * from customer where email = ?";
        ResultSet res = CrudUtil.execute(sql, email);
        if(res.next()){
            //ALREADY HAVE
            return false;
        }
        //UNIQUE
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete from customer where cust_Id = ?";
        return CrudUtil.execute(sql,id);
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from customer";
        ResultSet res = CrudUtil.execute(sql);

        ArrayList<Customer> customers = new ArrayList<>();
        while(res.next()){
            Customer customer = new Customer(
                    res.getString("cust_Id"),
                    res.getString("name"),
                    res.getString("address"),
                    res.getString("email"),
                    res.getString("contact")
            );

            customers.add(customer);
        }
        return customers;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        String sql = "insert into customer values (?,?,?,?,?)";
        return CrudUtil.execute(sql,dto.getCustomer_ID(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getCustomer_ID());
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
