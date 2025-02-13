module com.edu.ijse.print_shop {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.edu.ijse.print_shop.Controller to javafx.fxml;
    exports com.edu.ijse.print_shop;
}