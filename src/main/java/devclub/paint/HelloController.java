package devclub.paint;

import devclub.paint.context_menubar.ContextMenubar;
import devclub.paint.interfaces.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

public class HelloController implements Controller {

    public HelloController(){
        this.menuBar = new MenuBar();
        this.welcomeText = new Label();
    }

    @FXML
    protected MenuBar menuBar;

    @FXML // Will be removed, only for reference
    protected Label welcomeText;

    private ContextMenubar contextMenubar;


    @Override
    public void init() {
        contextMenubar = ContextMenubar.getInstance();

        if(contextMenubar == null){
            throw new RuntimeException("ContextMenubar is null");
        }
        addMenuAndSubItems();
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
    private void addMenuAndSubItems(){
        menuBar.getMenus().addAll(contextMenubar.getMenuList());
    }

}