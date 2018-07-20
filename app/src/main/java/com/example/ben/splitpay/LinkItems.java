package com.example.ben.splitpay;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkItems {
    HashMap<Integer, ArrayList<Integer>> personToItem;
    HashMap<Integer, Integer> itemToPerson;

    public LinkItems(){
        personToItem = new HashMap<>();
        itemToPerson = new HashMap<>();
    }

    public void linkItems(int personID, int itemID){
        if (!personToItem.containsKey(personID)){
            personToItem.put(personID, new ArrayList<Integer>());
        }

        ArrayList<Integer> temp = personToItem.get(personID);
        temp.add(itemID);
        itemToPerson.put(itemID, personID);
    }

    public Integer getPersonLinkedToBillingItem(int itemID){
        if (itemToPerson.containsKey(itemID)) return itemToPerson.get(itemID);
        return null;
    }

    public ArrayList<Integer> getBillinItemsLinkedToPerson(int personID){
        if (personToItem.containsKey(personID)) return personToItem.get(personID);
        return null;
    }
}
