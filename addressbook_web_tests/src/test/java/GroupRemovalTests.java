import model.Groupdata;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup(new Groupdata("", "", ""));

        }
        removeGroup();

    }

}
