package tests;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

@Test
void canModifyContact() {
    if (app.contacts().getCount() == 0) {
        app.contacts().createContact(new ContactData("", "FirstName", "LastName", "Address", "1234567890", "contact email", ""));
    }
    var oldContacts = app.contacts().getListContact();
    var rnd = new Random();
    var index = rnd.nextInt(oldContacts.size());
    var testData = new ContactData().withFirstname("FirstName").withLastname("LastName");
    app.contacts().modifyContact(oldContacts.get(index), testData);

    var newContacts = app.contacts().getListContact();
    var expectedList = new ArrayList<>(oldContacts);
    expectedList.set(index, testData.withIdCntct(oldContacts.get(index).id()));

    Comparator<ContactData> compareById = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
    newContacts.sort(compareById);
    expectedList.sort(compareById);

    Assertions.assertEquals(expectedList, newContacts);;
}
}



