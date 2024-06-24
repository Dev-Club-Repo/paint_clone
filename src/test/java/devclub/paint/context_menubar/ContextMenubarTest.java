package devclub.paint.context_menubar;

import static org.junit.jupiter.api.Assertions.*;

import devclub.paint.HelloApplication;
import devclub.paint.HelloController;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ContextMenubarTest{

    private static HelloController helloController;

    @BeforeAll
    static void setUp() {
        new Thread( () -> {
            HelloApplication.main(new String[]{""});
        }).start();

        helloController = new HelloController();
        helloController.init();
    }

    @Test
    void test_SameContextMenubar(){
        assertEquals(ContextMenubar.getInstance(), ContextMenubar.getInstance());
    }

    @Test
    void test_ListSizeOfMenu(){
        assertEquals(7,
                ContextMenubar.getInstance().getMenuList().size(),
                "ListSizeOfMenu should have 7 elements");
    }

    @Test
    void test_checkIfSubMenuExist(){
        assertEquals(3,
                ContextMenubar.getInstance().getMenuList().getFirst().getItems().size(),
                "'Datei'-SubMenu should have 3 elements");
    }

    @Test
    void test_checkForValidImage(){
        assertTrue(!(new Image("file:src/assets/icons/setting_icon.png").isError()),
                "Icon should be valid");
    }
}
