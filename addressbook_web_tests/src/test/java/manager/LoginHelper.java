package manager;


import org.openqa.selenium.By;

import java.nio.file.Paths;

public class LoginHelper extends HelperBase {



    public LoginHelper(Applicationmanager manager) {
        super(manager);
    }

    void login(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);

        click(By.xpath("//input[@value=\'Login\']"));
    }

    public static class HelperBaseContacts {
        protected final Applicationmanager manager;

        public HelperBaseContacts (Applicationmanager manager) {
            this.manager = manager;
        }

        protected void type(By locator, String text) {
            click(locator);
            manager.driver.findElement(locator).clear();
            manager.driver.findElement(locator).sendKeys(text);
        }

        protected void attach(By locator, String file) {
            manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
        }

        protected void click(By locator) {
            manager.driver.findElement(locator).click();
        }
    }
}
