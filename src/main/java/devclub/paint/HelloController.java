package devclub.paint;

import devclub.paint.interfaces.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class HelloController implements Controller {

    @FXML
    private MenuBar menuBar;

    @FXML
    private Label welcomeText;


    @Override
    public void init() {
        addMenuAndMenuItemsToMenubar();
    }

    /**
     * Will be deleted in the future, reference for Event-Handling
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /**
     * Adding Menu-Items to the Menubar
     * @author Michael
     */
    private void addMenuAndMenuItemsToMenubar(){
        menuBar.getMenus().add(new Menu("File"));
        menuBar.getMenus().add(new Menu("Edit"));
        menuBar.getMenus().add(new Menu("View"));
    }
}