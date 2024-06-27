package devclub.paint.interfaces;

/**
 * <p>
 *     Interfaces for Controller files<br>
 *     Use {@link javafx.fxml.FXMLLoader}.getController() Method to get the Controller that's assigned in the view file
 *     Overwrite the {@link #init()} Method in your Controller Class and implement all important things that should be initialized
 * </p>
 * @author Michael
 * @version 1.0
 */

public interface Controller {
    void init();
}
