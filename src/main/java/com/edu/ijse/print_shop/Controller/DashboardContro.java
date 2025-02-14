package com.edu.ijse.print_shop.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.nio.file.FileAlreadyExistsException;

public class DashboardContro {
    @FXML
    private Label Lblorder;

    @FXML
    private Label Lblpapers;

    @FXML
    private Label lblHome;

    @FXML
    private Label lblCustomer;

    @FXML
    void showlblHome(MouseEvent event) {
        lblHome.setVisible(true);
    }

    @FXML
    void removelblHome(MouseEvent  event) {
        lblHome.setVisible(false);
    }

    @FXML
    void showlblPaper(MouseEvent event) {
        Lblpapers.setVisible(true);
    }

    @FXML
    void removelblPaper(MouseEvent event) {
        Lblpapers.setVisible(false);
    }

    @FXML
    void showlblOrder(MouseEvent event) {
        Lblorder.setVisible(true);
    }

    @FXML
    void removelblOrder(MouseEvent event) {
        Lblorder.setVisible(false);
    }

    @FXML
    void showlblCust(MouseEvent event) {
        lblCustomer.setVisible(true);
    }

    @FXML
    void removelblCust(MouseEvent event) {
        lblCustomer.setVisible(false);
    }
}
