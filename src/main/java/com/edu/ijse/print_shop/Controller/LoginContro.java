package com.edu.ijse.print_shop.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginContro {
    @FXML
    private AnchorPane body;

    @FXML
    private Button btnLogin;

    @FXML
    private Label error;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPw;

    @FXML
    void Login(ActionEvent event) {
        if(txtEmail.getText().equals("admin@gmail.com") && txtPw.getText().equals("admin")){
            error.setVisible(false);
            //NAVIGATE TO DASHBOARD
            try{
                AnchorPane load = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
                body.getChildren().clear();
                body.getChildren().add(load);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            error.setVisible(true);
        }
    }
}
