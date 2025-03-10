package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestContactBase {

    @Test
    public void canDeleteContact() {
        cntapp.contacts().isHome();
        if (!cntapp.contacts().isContactPresent()) {
            cntapp.contacts().createContact(new ContactData ()); //("","Ivan", "Ivanovich", "Ivanov", "iii", "USA", "222", "@iii"));
        }
        var oldContacts = cntapp.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        cntapp.contacts().deleteContact(oldContacts.get(index));
        var newContacts = cntapp.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    public void canDeleteAllContacts() {
        cntapp.contacts().isHome();
        if (cntapp.contacts().getCount() == 0) {
            cntapp.contacts().createContact(new ContactData());
        }
        cntapp.contacts().removeAllContact();
        Assertions.assertEquals(0, cntapp.contacts().getCount());
    }
}
