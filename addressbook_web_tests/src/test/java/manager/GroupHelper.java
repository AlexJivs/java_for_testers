package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(Applicationmanager manager) {
        super(manager);
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroups();
        returnGroupPage();
    }


    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnGroupPage();
    }

    public void modyfyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        iniGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnGroupPage();
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }


    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }


    private void returnGroupPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }


    private void iniGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }

    public int getCount() {
        openGroupsPage();
       return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllgroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
