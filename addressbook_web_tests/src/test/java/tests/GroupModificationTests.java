package tests;

import model.Groupdata;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends  TestBase{

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Groupdata("", "", ""));

        }
        app.groups().modyfyGroup(new Groupdata().withName("modified name"));

    }
}
