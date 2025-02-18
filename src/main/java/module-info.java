module com.edu.ijse.print_shop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
                            
    opens com.edu.ijse.print_shop.controller to javafx.fxml;
    opens com.edu.ijse.print_shop.dto.tm to javafx.base;
    exports com.edu.ijse.print_shop;
}