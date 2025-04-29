module ch.fhnw.assignment1.cartelgroup {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.fhnw.assignment1.cartelgroup to javafx.fxml;
    exports ch.fhnw.assignment1.cartelgroup;
}