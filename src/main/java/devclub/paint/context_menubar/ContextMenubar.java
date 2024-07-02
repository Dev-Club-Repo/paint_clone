package devclub.paint.context_menubar;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle the Context_Menubar
 * Using Singleton Pattern
 * Actual implementation replaced with .fxml file acts as Controller Class
 *
 * @author Michael
 */

/*
 * ToDo Michael - 25.06.2024, 23:36 - Refactor this Class incl. the Tests
 */

public class ContextMenubar {

    public static ContextMenubar contextMenubar = null;

    private final List<Menu> menuList;


    public ContextMenubar(){
        this.menuList = new ArrayList<>();

        menuList.add(fileContextMenu());
        menuList.add(editContextMenu());
        menuList.add(viewContextMenu());
        menuList.add(iconContextMenu("save_icon.png", "", "saveIcon"));
        menuList.add(iconContextMenu("back_icon.png"));
        menuList.add(iconContextMenu("forward_icon.png"));
        menuList.add(iconContextMenu("setting_icon.png", "", "settingIcon"));
    }

    public static ContextMenubar getInstance(){
        if (contextMenubar != null){
            return contextMenubar;
        }
        contextMenubar = new ContextMenubar();
        return contextMenubar;
    }

    public List<Menu> getMenuList() {
        return this.menuList;
    }


    //<editor-fold desc="Context Menu Items">
    private Menu fileContextMenu() {
        Menu menu = new Menu("Datei");
        MenuItem newMenuItem = new MenuItem("Neu", insertIcon("new_icon.png"));
        MenuItem openMenuItem = new MenuItem("Öffnen", insertIcon("open_icon.png"));
        MenuItem safeMenuItem = new MenuItem("Speichern", insertIcon("save_icon.png"));
        MenuItem exitMenuItem = new MenuItem("Beenden", insertIcon("close_icon.png"));

        menu.getItems().addAll(newMenuItem, openMenuItem, safeMenuItem, exitMenuItem);

        return menu;
    }


    private Menu editContextMenu() {
        Menu menu = new Menu("Bearbeiten");

        MenuItem cutMenuItem = new MenuItem("Ausschneiden", insertIcon("cut_icon.png"));
        MenuItem copyMenuItem = new MenuItem("Kopieren", insertIcon("copy_icon.png"));
        MenuItem pasteMenuItem = new MenuItem("Einfügen", insertIcon("paste_icon.png"));

        menu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem);

        return menu;
    }


    private Menu viewContextMenu() {
        Menu menu = new Menu("Ansicht");

        Menu subMenuZoom = new Menu("Zoom", insertIcon("zoom_in_icon.png") );
        MenuItem zoomInItem = new MenuItem("Vergrößern");
        MenuItem zoomOutItem = new MenuItem("Verkleinern");

        subMenuZoom.getItems().addAll(zoomInItem, zoomOutItem);
        menu.getItems().add(subMenuZoom);

        return menu;
    }


    //<editor-fold desc="Overloaded IconContextMenu Creation">
    private Menu iconContextMenu(String path){
        return iconContextMenu(path, "");
    }

    private Menu iconContextMenu(String path, String text){
        return iconContextMenu(path, text, null);
    }

    private Menu iconContextMenu(String path, String text, String id){
        Menu menu = new Menu(text, insertIcon(path));
        menu.idProperty().set(id);
        return menu;
    }
    //</editor-fold>
    //</editor-fold>

    private ImageView insertIcon(String path){
        ImageView icon =  new ImageView("file:src/assets/icons/" + path);
        int iconWidthAndHeight = 18;

        icon.setFitWidth(iconWidthAndHeight);
        icon.setFitHeight(iconWidthAndHeight);
        return icon;
    }

    public void exitApplication(){
        Platform.exit();
    }
}
