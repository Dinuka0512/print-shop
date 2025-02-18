package com.edu.ijse.print_shop.controller;

import com.edu.ijse.print_shop.bo.BOFactory;
import com.edu.ijse.print_shop.bo.custom.CustomerBO;
import com.edu.ijse.print_shop.dto.CustomerDTO;
import com.edu.ijse.print_shop.dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TableColumn<CustomerTm, String> columnId;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblCustId;

    @FXML
    private TableColumn<CustomerTm, String> columnEmail;

    @FXML
    private TableColumn<CustomerTm, String> columnAddress;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtAddress;

    @FXML
    private TableColumn<CustomerTm, String> columnContact;

    @FXML
    private TableColumn<CustomerTm, String> columnName;

    //========
    private CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBOType(BOFactory.getBO.CUSTOMER);
    //========

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up columns
        columnId.setCellValueFactory(new PropertyValueFactory<>("customer_ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadTable();
    }

    private void loadTable() {
        //HERE LOAD THE TABLE
        try{
            ArrayList<CustomerDTO> customerDTOS = customerBO.getAllCustomers();
            ObservableList<CustomerTm> observableList = FXCollections.observableArrayList();
            for(CustomerDTO customerDTO : customerDTOS){
                CustomerTm customerTm = new CustomerTm(
                        customerDTO.getCustomer_ID(),
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getEmail(),
                        customerDTO.getContact()
                );

                observableList.add(customerTm);
            }

            tblCustomer.setItems(observableList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
    @FXML
    void save(ActionEvent event) {

    }
}
