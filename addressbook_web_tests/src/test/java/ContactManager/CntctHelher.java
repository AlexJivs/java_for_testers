package ContactManager;

import model.ContactData;
import org.openqa.selenium.By;

public class CntctHelher {
    private final ContactAppManager manager;

    public CntctHelher(ContactAppManager manager) {
        this.manager = manager;
    }

    public void isHome() {
        if (!manager.iselementPresent(By.linkText("home"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }

    public boolean isContactPresent() {
        ifAddNewNotExist();
        return manager.iselementPresent(By.id("0"));
    }

    public void createContact(ContactData contact) {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public void removeContact() {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("home")).click();
        manager.driver.findElement(By.xpath("//input[@id=\'MassCB\']")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }

    public void ifAddNewNotExist() {
        if (!manager.iselementPresent(By.linkText("add new"))) {
            manager.driver.findElement(By.name("firstname")).click();
        }
    }
}