package devclub.paint;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    public HelloController(){
        this.welcomeText = new Label();
    }

    @FXML // Will be removed, only for reference
    protected Label welcomeText;

    /**
     * Will be deleted in the future, reference for Event-Handling
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}