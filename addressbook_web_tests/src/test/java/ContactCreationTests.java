import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestContactBase {

    @Test
    public void canCreateContact() {
        ifAddNewNotExist();
        createContact("Ivan");

    }


    @Test
    public void canCreateContactWithEmptyFields() {
        ifAddNewNotExist();
        createContact("");

    }

}
