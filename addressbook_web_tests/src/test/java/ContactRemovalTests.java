import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactRemovalTests extends TestContactBase {

    @Test
    public void deleteContact() {
        if (!iselementPresent(By.linkText("home"))) {
            driver.findElement(By.linkText("home")).click();
        }
        if (!isContactPresent()) {
            createContact("Ivan");
        }
        removeContact();
    }

}
