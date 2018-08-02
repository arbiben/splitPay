package Modules.People;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GroupMakerTest {
    private Group group;

    @Before
    public void setUp() throws Exception {
        GroupMaker groupMaker = new GroupMaker();
        group = groupMaker.createGroup();
    }

    @Test
    public void addMember() {
        int key = group.addMember("Jonny", "Appleseed");
        assertEquals(group.getName(key), "Jonny Appleseed");
    }

    @Test
    public void addThreeMembersNamesMatch() {
        int key1 = group.addMember("apples", "oranges");
        int key2 = group.addMember("apples", "oranges");
        int key3 = group.addMember("pineapples", "bees");
        assertEquals(group.getName(key1), "apples oranges");
        assertEquals(group.getName(key2), "apples oranges");
        assertEquals(group.getName(key3), "pineapples bees");
    }

    @Test
    public void addMultipleItemsExistsByKey() {
        ArrayList<String> firstNames = new ArrayList<>();
        firstNames.add("Bob");
        firstNames.add("Sam");
        firstNames.add("Danny");
        firstNames.add("John");

        ArrayList<String> lastNames = new ArrayList<>();
        lastNames.add("Abc");
        lastNames.add("Cba");
        lastNames.add("Dae");
        lastNames.add("Abc");

        ArrayList<Integer> keys = group.addMultipleMembers(firstNames, lastNames);

        assertEquals(group.getName(keys.get(0)), "Bob Abc");
        assertEquals(group.getName(keys.get(1)), "Sam Cba");
        assertEquals(group.getName(keys.get(2)), "Danny Dae");
        assertEquals(group.getName(keys.get(3)), "John Abc");
    }
}