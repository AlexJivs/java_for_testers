package ContactManager;
import org.openqa.selenium.By;

public class HelperBaseContacts {
    protected final ContactAppManager manager;

    public HelperBaseContacts (ContactAppManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }
}

