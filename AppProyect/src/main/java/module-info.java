module mi.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    exports org.example;
    opens org.example to javafx.fxml, javafx.controls, javafx.graphics;
}
