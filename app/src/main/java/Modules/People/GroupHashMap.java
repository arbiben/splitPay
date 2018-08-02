package Modules.People;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupHashMap implements Group {
    private HashMap<Integer, Person> groupMembers;
    private int curKeyVal;

    GroupHashMap() {
        groupMembers = new HashMap<>();
        curKeyVal = 0;
    }

    @Override
    public int addMember(String firstName, String lastName) {
        Person newMember = new Person(firstName, lastName);
        addPerson(newMember);
        return getLastKey();
    }

    private void addPerson(Person person) {
        if (!keyExists(curKeyVal)) {
            groupMembers.put(curKeyVal++, person);
        }
        else {
            throw new IndexOutOfBoundsException("Unable to add person");
        }
    }

    private boolean keyExists(int key) {
        return groupMembers.containsKey(key);
    }

    private int getLastKey() {
        return curKeyVal-1;
    }

    @Override
    public void removeMember(int key) {

    }

    @Override
    public ArrayList<Integer> addMultipleMembers(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        if (firstNames.size() != lastNames.size()) {
            throw new IndexOutOfBoundsException("FirstNames and LastNames don't match up!");
        }
        ArrayList<Integer> keyValues = new ArrayList<>();
        for (int i=0; i<firstNames.size(); i++) {
            addMember(firstNames.get(i), lastNames.get(i));
            keyValues.add(getLastKey());
        }
        return keyValues;
    }

    @Override
    public String getName(int key) {
        return findPerson(key).toString();
    }

    private Person findPerson(int key) {
        if (keyExists(key)) {
            return groupMembers.get(key);
        }
        else {
            throw new IndexOutOfBoundsException("Key not found");
        }
    }

    @Override
    public String getInitials(int key) {
        return findPerson(key).getInitials();
    }
}
