package com.edu.ijse.print_shop.controller;

import com.edu.ijse.print_shop.bo.BOFactory;
import com.edu.ijse.print_shop.bo.custom.CustomerBO;
import com.edu.ijse.print_shop.dto.CustomerDTO;
import com.edu.ijse.print_shop.dto.tm.CustomerTm;
import com.edu.ijse.print_shop.util.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private Button btnReset;

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
        pageDefaullt();
    }

    private void genarateId() {
        try{
            lblCustId.setText(customerBO.genarateId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isDataValid(){
        if(Validation.isValidName(txtName.getText())){
            if(Validation.isValidName(txtAddress.getText())){
                if(Validation.isValidEmail(txtEmail.getText())){
                    if(Validation.isValidMobileNumber(txtContact.getText())){
                        return true;
                    }else{
                        new Alert(Alert.AlertType.WARNING, "Invalid Contact").show();
                        return false;
                    }
                }else{
                    new Alert(Alert.AlertType.WARNING, "Invalid Email").show();
                    return false;
                }
            }else{
                new Alert(Alert.AlertType.WARNING, "Invalid Address").show();
                return false;
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "Invalid name").show();
            return false;
        }
    }
    private boolean isEmailValidAndUnique(){
        if(Validation.isValidEmail(txtEmail.getText())){
            try{
                if(customerBO.isEmailExist(txtEmail.getText())){
                    //UNIQUE
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    private void pageDefaullt() {
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnReset.setDisable(true);
        btnSave.setDisable(false);
    }

    private void loadTable() {
        genarateId();
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation Dialog");
        // Show the alert and wait for the user's response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                //DELETE
                try{
                    if(customerBO.deleteCustomers(lblCustId.getText())){
                        pageDefaullt();
                        loadTable();
                        new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted").show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    void update(ActionEvent event) {
        if(isDataValid()){
            try{
                if(txtEmail.getText().equals(customerBO.getEmail(lblCustId.getText())) || isEmailValidAndUnique()){
                    if(customerBO.update(new CustomerDTO(lblCustId.getText(), txtName.getText(), txtAddress.getText(), txtEmail.getText(), txtContact.getText()))){
                        loadTable();
                        pageDefaullt();
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void save(ActionEvent event) {
        if(isDataValid() && isEmailValidAndUnique()){
            try{
                if(customerBO.save(new CustomerDTO(lblCustId.getText(), txtName.getText(), txtAddress.getText(), txtEmail.getText(), txtContact.getText()))){
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
                    loadTable();
                    pageDefaullt();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void reset(ActionEvent event) {
        pageDefaullt();
        genarateId();
        txtContact.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtName.setText("");

        txtName.setPromptText("name");
        txtAddress.setPromptText("address");
        txtContact.setPromptText("contact");
        txtEmail.setPromptText("email");
    }

    @FXML
    void onClick(MouseEvent event) {
        CustomerTm customerTm = tblCustomer.getSelectionModel().getSelectedItem();
        if(customerTm != null){
            btnReset.setDisable(false);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnSave.setDisable(true);

            lblCustId.setText(customerTm.getCustomer_ID());
            txtName.setText(customerTm.getName());
            txtAddress.setText(customerTm.getAddress());
            txtContact.setText(customerTm.getContact());
            txtEmail.setText(customerTm.getEmail());
        }
    }
}
