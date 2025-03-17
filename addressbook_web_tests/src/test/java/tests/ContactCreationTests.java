package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();

        for (var firstname : List.of("", "contact firstname")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var address : List.of("", "contact address")) {
                    for (var mobile : List.of("", "contact mobile")) {
                        for (var email : List.of("", "contact email")) {
                            result.add(new ContactData()
                                    .withFirstname(firstname)
                                    .withLastname(lastname)
                                    .withAddress(address)
                                    .withHome(mobile)
                                    .withEmail(email));
                        }
                    }
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            result.add(new ContactData()

                    .withFirstname(CommonFunctions.randomStr(i * 5))
                    .withLastname(CommonFunctions.randomStr(i * 5))
                    .withAddress(CommonFunctions.randomStr(i * 5))
                    .withHome(CommonFunctions.randomStr(i * 5))
                    .withEmail(CommonFunctions.randomStr(i * 5))
                    .withPhoto("src/test/resources/images/avatar.png"));


        }
        return result;
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultContacts(ContactData contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().createContact(contact);

        var newContacts = app.contacts().getListContact();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact
                .withIdCntct(newContacts.get(newContacts.size() - 1).id())
              .withFirstname(contact.firstname())
               // .withFirstname("Vasya")
               // .withLastname("")
                .withAddress("")
                .withEmail("")
                .withHome(""));




        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);


    }

    @Test
    void  canCreateContact() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomStr(5))
                .withLastname(CommonFunctions.randomStr(5))
                .withAddress(CommonFunctions.randomStr(5))
                .withHome(CommonFunctions.randomStr(5))
                .withEmail(CommonFunctions.randomStr(5))
                .withPhoto("src/test/resources/images/ava.png");
        app.contacts().createContactWithPhoto(contact);



    }
}







