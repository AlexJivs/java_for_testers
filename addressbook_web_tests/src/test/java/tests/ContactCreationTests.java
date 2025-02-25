package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestContactBase {

    public static List<ContactData> contactProvider() {
       var result = new ArrayList<ContactData>();

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(
                    randomStr(i * 10), // firstname
                    randomStr(i * 10), // middlename
                    randomStr(i * 10), // lastname
                    randomStr(i * 10), // nickname
                    randomStr(i * 10),  // address
                    randomStr(i * 10), // home
                    randomStr(i * 10))); // email
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultContacts(ContactData contact) {
        cntapp.contacts().createContact(contact);
    }
}
