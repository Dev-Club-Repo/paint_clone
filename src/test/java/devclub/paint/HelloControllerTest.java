package devclub.paint;

import devclub.paint.interfaces.Controller;
import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HelloControllerTest {

    private static HelloController helloController;

    /**
     * Set up the Application in the Background to Test it
     *
     * Initialized a Controller to test
     * @author Michael
     */
    @BeforeAll
    static void setUp() {
        new Thread( () -> {
            HelloApplication.main(new String[]{""});
        }).start();

        helloController = new HelloController();
    }

    /**
     * Example Test
     */
    @Test
    void exampleTest_ChangingLabelText_OnButtonPressed(){
        helloController.onHelloButtonClick();
        assertEquals("Welcome to JavaFX Application!", helloController.welcomeText.getText());
    }
}