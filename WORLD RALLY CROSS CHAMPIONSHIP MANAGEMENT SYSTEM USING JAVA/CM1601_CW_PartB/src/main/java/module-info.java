module com.example.cm1601_cw_partb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cm1601_cw_partb to javafx.fxml;
    exports com.example.cm1601_cw_partb;
}