package ContactManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactAppManager {
    protected WebDriver driver;
    private CntLoginHelper session;
    private CntctHelper contacts;

    public void initCnt() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1284, 895));
            session().cntLogin("admin", "secret");
        }
    }

    public  CntLoginHelper session() {
        if (session == null) {
           session = new CntLoginHelper(this);
        }
        return session;
    }

    public CntctHelper contacts() {
        if (contacts == null) {
            contacts = new CntctHelper(this);
        }
        return contacts;
    }

    public boolean iselementPresent(By locator) {

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
