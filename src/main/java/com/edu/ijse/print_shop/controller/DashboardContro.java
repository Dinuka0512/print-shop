package com.edu.ijse.print_shop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private AnchorPane body;

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

    @FXML
    void openManageCustomer(MouseEvent event) {
        try{
            body.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/customer.fxml"));
            body.getChildren().add(load);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void openDashboard(MouseEvent event) {
        try{
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
            Parent root = fxmlLoader.load();

            // Set up a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Huruwagraphy print Shop");
            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
