package com.edu.ijse.print_shop.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginContro {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPw;

    @FXML
    void Login(ActionEvent event) {
        if(txtEmail.getText().equals("admin@gmail.com") && txtPw.getText().equals("admin")){
            //NAVIGATE TO DASHBOARD
        }
    }
}
