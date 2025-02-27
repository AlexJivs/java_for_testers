package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group header")) {
                    result.add(new GroupData(name, header, footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData(randomString(i * 10), randomString(i * 10),randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> NegativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("group name'","", "")));
        return result;
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCreateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("some footer"));
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @ParameterizedTest
    @MethodSource("NegativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}




