package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestContactBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact name")) {
            for (var middlename : List.of("", "middle name")) {
                for (var lastname : List.of("", "last name")) {
                    for (var nickname : List.of("", "nick name")) {
                        for (var address : List.of("", "addres")) {
                            for (var home : List.of("", "home")) {
                                for (var email : List.of("", "email")) {
                                    result.add(new ContactData()
                                            .withFirstname(firstname)
                                            .withMiddlename(middlename)
                                            .withLastname(lastname)
                                            .withNickname(nickname)
                                            .withAddress(address)
                                            .withHome(home)
                                            .withEmail(email));
                                }
                            }
                        }

                    }
                }
            }
        }


        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(
                    randomStr(i * 10), // id
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
        var oldContacts = cntapp.contacts().getListContact();

        cntapp.contacts().createContact(contact);

        var newContacts = cntapp.contacts().getListContact();

       // Comparator<ContactData> compareById = (o1, o2) -> Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        Comparator<ContactData> compareById = (o1, o2) -> Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));

        newContacts.sort(compareById);

        // Создаем ожидаемый список
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withIdCntct(newContacts.get(newContacts.size() - 1).id())
                .withAddress("").withEmail("").withHome(""));
        expectedList.sort(compareById);

        // Сравниваем старый и новый список
        Assertions.assertEquals(expectedList, newContacts);
    }
}







