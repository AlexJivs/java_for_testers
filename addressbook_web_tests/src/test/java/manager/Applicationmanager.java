package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Applicationmanager {
    protected WebDriver driver;
    private loginHelper session;
    private grouphelper groups;

    public void init() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1284, 895));
            session().login("admin", "secret");
        }
    }

    public loginHelper session() {
        if (session == null) {
            session = new loginHelper(this);
        }
        return  session;
    }

    public grouphelper groups() {
        if (groups == null) {
            groups = new grouphelper(this);
        }
        return  groups;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
