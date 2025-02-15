package tests;

import manager.Applicationmanager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static Applicationmanager app;


    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new Applicationmanager();
            app.init(System.getProperty("browser", "Chrome"));
        }
    }

}
