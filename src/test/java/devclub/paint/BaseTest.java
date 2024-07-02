package devclub.paint;

import org.junit.jupiter.api.BeforeAll;

/**
 * BaseTest Class to set up application for testing
 * @author Michael
 */
public abstract class BaseTest{

    public static Thread baseTestApplication = null;

    public static HelloController helloController = null;

    @BeforeAll
    public static void setUpBase(){

        if(baseTestApplication == null){
            baseTestApplication = new Thread(() -> HelloApplication.main(new String[]{""}));
        }

        if (!baseTestApplication.isAlive()){
            baseTestApplication.start();
        }

        if(helloController == null){
            helloController = new HelloController();
        }
    }
}
