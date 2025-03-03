package ContactManager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CntctHelper extends HelperBaseContacts {
   // private final ContactAppManager manager;

    public CntctHelper(ContactAppManager manager) {
        super(manager);
    }

    public void isHome() {
            manager.driver.findElement(By.linkText("home")).click();
    }

    public boolean isContactPresent() {
        ifAddNewNotExist();
        return manager.iselementPresent(By.id("0"));
    }

    public void createContact(ContactData contact) {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("add new")).click();
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("email"), contact.email());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public void removeContact() {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("home")).click();
        manager.driver.findElement(By.xpath("//input[@id=\'MassCB\']")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }

    public void ifAddNewNotExist() {
        if (!manager.iselementPresent(By.linkText("add new"))) {
            manager.driver.findElement(By.name("firstname")).click();
        }
    }


    public int getCount() {
        isHome();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getListContact() {
        isHome();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var tr : trs) {
            var id = tr.findElement(By.name("selected[]")).getAttribute("value"); //
            var firstname = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
          //  var lastname = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
          //  var address = tr.findElement(By.cssSelector("td:nth-child(4)")).getText(); //
          //  var email = tr.findElement(By.cssSelector("td:nth-child(5)")).getText(); //
          //  var home = tr.findElement(By.cssSelector("td:nth-child(6)")).getText();

            // var checkbox = tr.findElement(By.name("selected[]"));
            //  var id = checkbox.getAttribute("value");
            contacts.add(new ContactData()
                    .withIdCntct(id)
                    .withFirstname(firstname));
                   // .withLastname(lastname));
                   // .withAddress(address)
                   // .withEmail(email)
                   // .withHome(home));
        }
        return  contacts;
    }

   public void modifyContact(ContactData contact, ContactData modifiedContact) {
        isHome();
       selectContact(contact);
       initContactModification(contact);
       fillContactForm(modifiedContact);
       submitContactModification();
       isHome();;
    }


    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void initContactModification(ContactData contact) {
        var w = String.format("//td[@class='center']/a[@href='edit.php?id=%s']", contact.id());
        click(By.xpath(w));

    }

    private void fillContactForm(ContactData contact) {
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
       // type(By.name("address"), contact.address());
       // type(By.name("email"), contact.email());
       // type(By.name("phone"), contact.mobile());

    }

    private void submitContactModification() {
        click(By.name("update"));
    }
}