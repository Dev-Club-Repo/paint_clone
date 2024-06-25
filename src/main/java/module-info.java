module devclub.paint {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens devclub.paint to javafx.fxml;
    exports devclub.paint;

    opens devclub.paint.context_menubar to javafx.fxml;
    exports devclub.paint.context_menubar;
}