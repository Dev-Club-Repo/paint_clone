package devclub.paint.context_menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle the Context_Menubar
 * Using Singleton Pattern
 * @author Michael
 */
public class ContextMenubar {

    public static ContextMenubar contextMenubar = null;

    private final int iconWidthAndHeight = 18;

    private final List<Menu> menuList;


    ContextMenubar(){
        this.menuList = new ArrayList<>();

        menuList.add(fileContextMenu());
        menuList.add(editContextMenu());
        menuList.add(viewContextMenu());
        menuList.add(iconContextMenu("save_icon.png"));
        menuList.add(iconContextMenu("back_icon.png"));
        menuList.add(iconContextMenu("forward_icon.png"));
        menuList.add(iconContextMenu("setting_icon.png"));
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
        return new Menu(text, insertIcon(path));
    }
    //</editor-fold>
    //</editor-fold>

    private ImageView insertIcon(String path){
        ImageView icon =  new ImageView("file:src/assets/icons/" + path);
        icon.setFitWidth(iconWidthAndHeight);
        icon.setFitHeight(iconWidthAndHeight);
        return icon;
    }

    /*
     * ToDo Michael - 24.06.2024, 16:08 - Some Styling to fit the look of the context bar in paint and some refactoring
     */
}
