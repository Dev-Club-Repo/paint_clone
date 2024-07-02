package devclub.paint;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example:
 */
public class HelloControllerTest extends BaseTest{

    /**
     * Set up the specific test requirements to run the test
     *
     * @author Michael
     */
    @BeforeAll
    static void setUpTest() {
//        Set your test requirements here
    }

    /**
     * Example Test
     */
    @Test
    void exampleTest_ChangingLabelText_OnButtonPressed(){
        BaseTest.helloController.onHelloButtonClick();
        assertEquals("Welcome to JavaFX Application!", BaseTest.helloController.welcomeText.getText());
    }
}