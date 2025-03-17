package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();

    //    for (var firstname : List.of("", "contact firstname")) {
     //       for (var lastname : List.of("", "contact lastname")) {
       //        for (var address : List.of("", "contact address")) {
         //           for (var mobile : List.of("", "contact mobile")) {
         //               for (var email : List.of("", "contact email")) {
        //                    result.add(new ContactData()
        //                            .withFirstname(firstname)
        //                            .withLastname(lastname)
       //                             .withAddress(address)
       //                             .withHome(mobile)
      //                              .withEmail(email));
      //                  }
       //             }
      //          }
      //      }
     //   }


      //  for (int i = 0; i < 3; i++) {
           // result.add(new ContactData()

                 //   .withFirstname(CommonFunctions.randomStr(i * 5))
                  //  .withLastname(CommonFunctions.randomStr(i * 5))
                 //   .withAddress(CommonFunctions.randomStr(i * 5))
                 //   .withHome(CommonFunctions.randomStr(i * 5))
                 //   .withEmail(CommonFunctions.randomStr(i * 5))
                 //   .withPhoto("src/test/resources/images/avatar.png"));


       // }
       // return result;

        var json = "";
        try (var reader = new FileReader("contacts.json");
            var breader = new BufferedReader(reader)
       ) {
           var line = breader.readLine();
           while (line != null) {
               json = json + line;
                line = breader.readLine();
           }
        }
        //var json = Files.readString(Paths.get("groups.json"));
        var mapper = new JsonMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
        //var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
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
                .withHome("")
                .withPhoto(""));





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
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContactWithPhoto(contact);



    }
}







