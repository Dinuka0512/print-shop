module com.edu.ijse.print_shop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
                            
    opens com.edu.ijse.print_shop.controller to javafx.fxml;
    exports com.edu.ijse.print_shop;
}