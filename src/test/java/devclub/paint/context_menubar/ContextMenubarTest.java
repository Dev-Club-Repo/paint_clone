package devclub.paint.context_menubar;

import static org.junit.jupiter.api.Assertions.*;

import devclub.paint.HelloApplication;
import devclub.paint.HelloController;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ContextMenubarTest{

    @BeforeAll
    static void setUp() {
        new Thread( () -> HelloApplication.main(new String[]{""})).start();

        HelloController helloController = new HelloController();
    }

    @Test
    void test_SameContextMenubar(){
        assertSame(ContextMenubar.getInstance(), ContextMenubar.getInstance(), "Same object reference");
        assertNotSame(ContextMenubar.getInstance(), new ContextMenubar(), "Different objects");
    }

    @Test
    void test_ListSizeOfMenu(){
        assertEquals(7,
                ContextMenubar.getInstance().getMenuList().size(),
                "ListSizeOfMenu should have 7 elements");
    }

    @Test
    void test_checkIfSubMenuExist(){
        assertEquals(4,
                ContextMenubar.getInstance().getMenuList().getFirst().getItems().size(),
                "'Datei'-SubMenu should have 4 elements");
    }

    @Test
    void test_checkForValidImage(){
        assertTrue(new Image("file:src/assets/icons/setting_icon.png").isError(),
                "Icon shouldn't be valid");
    }
}
