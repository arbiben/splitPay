package Modules.People;

import java.util.ArrayList;

public interface Group {
    int addMember(String firstName, String lastName);
    void removeMember(int key);
    ArrayList<Integer> addMultipleMembers(ArrayList<String> firstNames, ArrayList<String> lastNames);
    String getName(int key);
    String getInitials(int key);
}