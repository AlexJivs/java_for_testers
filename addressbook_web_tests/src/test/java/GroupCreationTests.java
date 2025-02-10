import model.Groupdata;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup(new Groupdata("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new Groupdata());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new Groupdata();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {
        openGroupsPage();
        var emptyGroup = new Groupdata();
        var groupWithHeader = emptyGroup.withHeader("some header");
        createGroup(groupWithHeader);
    }

    @Test
    public void canCreateGroupWithFooterOnly() {
        openGroupsPage();
        var emptyGroup = new Groupdata();
        var groupWithFooter = emptyGroup.withFooter("some footer");
        createGroup(groupWithFooter);
    }
}
