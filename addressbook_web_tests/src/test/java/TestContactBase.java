
 import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContactBase {
    protected static WebDriver driver;

    protected static void createContact(ContactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).sendKeys(contact.home());
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    protected static void removeContact() {
        driver.findElement(By.linkText("home")).click();
        driver.findElement(By.xpath("//input[@id=\'MassCB\']")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }


    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1284, 895));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    protected boolean iselementPresent(By locator) {

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void ifAddNewNotExist() {
        if (!iselementPresent(By.linkText("add new"))) {
            driver.findElement(By.name("firstname")).click();
        }
    }

    protected boolean isContactPresent() {
        return iselementPresent(By.id("0"));
    }

    protected void isHome() {
        if (!iselementPresent(By.linkText("home"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }
}
