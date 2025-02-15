import model.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactRemovalTests extends TestContactBase {

    @Test
    public void deleteContact() {
        isHome();
        if (!isContactPresent()) {
            createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "iii", "USA", "222", "@iii"));
        }
        removeContact();
    }

}
