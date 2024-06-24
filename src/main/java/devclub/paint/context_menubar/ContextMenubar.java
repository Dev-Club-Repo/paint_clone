package devclub.paint.context_menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
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

    private final List<Menu> menuList;


    private ContextMenubar(){
        this.menuList = new ArrayList<Menu>();

        menuList.add(fileContextMenu());
        menuList.add(editContextMenu());
        menuList.add(viewContextMenu());
        menuList.add(iconContextMenu("src/assets/icons/save_icon.png"));
        menuList.add(iconContextMenu("src/assets/icons/back_icon.png"));
        menuList.add(iconContextMenu("src/assets/icons/forward_icon.png"));
        menuList.add(iconContextMenu("src/assets/icons/setting_icon.png"));
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
        MenuItem openMenuItem = new MenuItem("Öffnen");
        MenuItem safeMenuItem = new MenuItem("Speichern");
        MenuItem exitMenuItem = new MenuItem("Beenden");

        menu.getItems().addAll(openMenuItem, safeMenuItem, exitMenuItem);

        return menu;
    }


    private Menu editContextMenu() {
        Menu menu = new Menu("Bearbeiten");
        MenuItem cutMenuItem = new MenuItem("Ausschneiden");
        MenuItem copyMenuItem = new MenuItem("Kopieren");
        MenuItem pasteMenuItem = new MenuItem("Einfügen");

        menu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem);

        return menu;
    }


    private Menu viewContextMenu() {
        Menu menu = new Menu("Ansicht");
        Menu subMenuZoom = new Menu("Zoom In");
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
        Image icon = new Image("file:" + path);
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(18);
        iconView.setFitWidth(18);

        Menu menu = new Menu(text, iconView);

        return menu;
    }
    //</editor-fold>
    //</editor-fold>

}
