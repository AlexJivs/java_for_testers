package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CntctHelper extends LoginHelper.HelperBaseContacts {
   
    public CntctHelper(Applicationmanager manager) {
        super(manager);
    }

    public void isHome() {
            manager.driver.findElement(By.linkText("home")).click();
    }

    public boolean isContactPresent() {
        ifAddNewNotExist();
        return manager.isElementPresent(By.id("0"));
    }

    public void createContact(ContactData contact) {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("add new")).click();
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("home"), contact.home());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public void createContactWithPhoto(ContactData contact) {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("add new")).click();
        fillContactForm(contact);
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public void removeAllContact() {
        ifAddNewNotExist();
        manager.driver.findElement(By.linkText("home")).click();
        manager.driver.findElement(By.xpath("//input[@id=\'MassCB\']")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }

    public void deleteContact(ContactData contact) {
        selectContact(contact);
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    public void ifAddNewNotExist() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
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
            //var firstname = tr.getText();
            var firstname = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastname = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withIdCntct(id).withFirstname(firstname).withLastname(lastname));
        }
        return  contacts;
    }

   public void modifyContact(ContactData contact, ContactData modifiedContact) {
        isHome();
       selectContact(contact);
       initContactModification(contact);
       type(By.name("lastname"), contact.lastname());
       type(By.name("firstname"), contact.firstname());
       type(By.name("address"), contact.address());
       type(By.name("email"), contact.email());
       type(By.name("home"), contact.home());
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
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("home"), contact.home());
        attach(By.name("photo"), contact.photo());
    }



    private void submitContactModification() {
        click(By.name("update"));
    }
}