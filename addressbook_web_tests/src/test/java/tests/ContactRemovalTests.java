package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestContactBase {

    @Test
    public void deleteContact() {
        cntapp.contacts().isHome();
        if (!cntapp.contacts().isContactPresent()) {
            cntapp.contacts().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "iii", "USA", "222", "@iii"));
        }
        cntapp.contacts().removeContact();
    }

}
