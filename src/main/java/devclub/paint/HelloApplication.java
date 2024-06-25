package devclub.paint;

import devclub.paint.interfaces.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 786);
        stage.setTitle("Paint Application by Dev-Club");
        stage.setScene(scene);

        // Adding Stylesheet for Context Menubar
        scene.getStylesheets().add("file:src/main/resources/devclub/paint/css/context_menubar.css");

        // Initialize Components
        Controller controller = fxmlLoader.getController();
        controller.init();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}