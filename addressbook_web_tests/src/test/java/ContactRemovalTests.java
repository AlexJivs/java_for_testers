import model.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactRemovalTests extends TestContactBase {

    @Test
    public void deleteContact() {
        if (!iselementPresent(By.linkText("home"))) {
            driver.findElement(By.linkText("home")).click();
        }
        if (!isContactPresent()) {
            createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "iii", "USA", "222", "@iii"));
        }
        removeContact();
    }

}
