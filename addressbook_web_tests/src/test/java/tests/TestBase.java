package tests;

import manager.Applicationmanager;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static Applicationmanager app;

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) {
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new Applicationmanager();
            app.init(System.getProperty("browser", "Chrome"), properties);
        }
    }

}


