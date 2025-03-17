package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canDeleteContact() {
        app.contacts().isHome();
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData ()); //("","Ivan", "Ivanovich", "Ivanov", "iii", "USA", "222", "@iii"));
        }
        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContacts = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    public void canDeleteAllContacts() {
        app.contacts().isHome();
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData());
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
