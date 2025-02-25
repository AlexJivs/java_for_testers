package ContactManager;
import org.openqa.selenium.By;


public class CntLoginHelper {
    private final ContactAppManager manager;

    public  CntLoginHelper(ContactAppManager manager) {
        this.manager = manager;
    }
    void cntLogin(String user, String password) {
        manager.driver.findElement(By.name("user")).sendKeys(user);
        manager.driver.findElement(By.name("pass")).sendKeys(password);
        manager.driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }
}
