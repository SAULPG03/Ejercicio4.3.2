module com.example.ejercicio432 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio432 to javafx.fxml;
    exports com.example.ejercicio432;
}