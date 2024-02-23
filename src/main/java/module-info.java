module com.example.gui_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gui_java to javafx.fxml;
    exports com.example.gui_java;
    opens controllers to javafx.fxml;
    exports controllers;

    exports com.example.gui_java.Controllers;
    opens com.example.gui_java.Controllers to javafx.fxml;
}
