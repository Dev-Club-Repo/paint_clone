package devclub.paint;

import devclub.paint.context_menubar.ContextMenubar;
import devclub.paint.interfaces.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import java.util.ArrayList;
import java.util.List;

public class HelloController implements Controller {

    public HelloController(){
        this.menuBar = new MenuBar();
        this.welcomeText = new Label();
    }

    @FXML
    protected MenuBar menuBar;

    @FXML
    protected Label welcomeText;

    private ContextMenubar contextMenubar;

    private List<Menu> menus;


    @Override
    public void init() {
        contextMenubar = ContextMenubar.getInstance();
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
        menus = contextMenubar.getMenuList();

        menuBar.getMenus().addAll(menus);
    }

}