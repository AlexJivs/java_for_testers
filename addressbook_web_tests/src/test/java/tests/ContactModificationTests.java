package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestContactBase {


    @Test
    void canModifyContact() {
        if (cntapp.contacts().getCount() == 0) {
            cntapp.contacts().createContact(new ContactData("","FirstName", "MiddleName", "LastName", "","Address", "890", "email"));

        }
        var oldContacts = cntapp.contacts().getListContact();

        if (oldContacts.isEmpty()) {
            throw new IllegalStateException("Список контактов пуст. Невозможно модифицировать контакт.");
        }

        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        var testData = new ContactData().withFirstname("modified firstname").withLastname("Modified lastname");
        cntapp.contacts().modifyContact(oldContacts.get(index), testData);

        var newContacts = cntapp.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withIdCntct(oldContacts.get(index).id()));

        Comparator<ContactData> compareById = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
        //(o1, o2) -> {
         //   return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}



