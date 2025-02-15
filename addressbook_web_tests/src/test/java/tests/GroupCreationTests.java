package tests;

import model.Groupdata;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new Groupdata("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new Groupdata());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new Groupdata().withName("some name"));
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new Groupdata().withHeader("some header"));
    }

    @Test
    public void canCreateGroupWithFooterOnly() {
        app.groups().createGroup(new Groupdata().withFooter("some footer"));
    }
}
