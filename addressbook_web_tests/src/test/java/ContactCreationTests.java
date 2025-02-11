import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestContactBase {

    @Test
    public void canCreateContactAllData() {
        ifAddNewNotExist();
        createContact(new ContactData("firstname", "middlename", "lastname",
                "nickname", "address", "home", "email"));
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        ifAddNewNotExist();
        createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithFirstname = emptyGroup.withFirstname("Clop");
        createContact(contactWithFirstname);
    }

    @Test
    public void canCreateContactWithMiddleNameOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithMiddleName = emptyGroup.withMiddlename("Ivanovich");
        createContact(contactWithMiddleName);
    }

    @Test
    public void canCreateContactWithLastnameOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithLastname = emptyGroup.withLastname("Ofigensky");
        createContact(contactWithLastname);
    }

    @Test
    public void canCreateContactWithNicknameOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithNickname = emptyGroup.withNickname("kio");
        createContact(contactWithNickname);
    }

    @Test
    public void canCreateContactWithAddressOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithAddress = emptyGroup.withAddress("USA");
        createContact(contactWithAddress);
    }

    @Test
    public void canCreateContactWithHomeOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithHome = emptyGroup.withHome("222-222");
        createContact(contactWithHome);
    }

    @Test
    public void canCreateContactWithEmailOnly() {
        ifAddNewNotExist();
        var emptyGroup = new ContactData();
        var contactWithEmail = emptyGroup.withEmail("@kio");
        createContact(contactWithEmail);
    }


}
