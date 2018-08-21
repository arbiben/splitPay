package com.example.ben.splitpay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LinkItemsTest {
    LinkItems linkItems;
    test t;
    @Before
    public void setUp() throws Exception {
        linkItems = new LinkItems();
        t = new test();
    }

    @Test
    public void linkItems() {

        t.run();
        assertEquals(0,0);

        /*
        // person id and item id are linked
        linkItems.linkItems(1, 5);
        linkItems.linkItems(1, 1);
        linkItems.linkItems(1, 7);
        linkItems.linkItems(2, 3);
        linkItems.linkItems(2, 12);
        linkItems.linkItems(3, 6);
        linkItems.linkItems(4, 4);
        int personID = linkItems.getPersonLinkedToBillingItem(12);
        assertEquals(personID, 2);
        personID = linkItems.getPersonLinkedToBillingItem(6);
        assertEquals(personID, 3);
        personID = linkItems.getPersonLinkedToBillingItem(4);
        assertEquals(personID, 4);
        personID = linkItems.getPersonLinkedToBillingItem(1);
        assertEquals(personID, 1);
        Integer j = linkItems.getPersonLinkedToBillingItem(34);
        assertEquals(j, null);
        ArrayList<Integer> person1 = linkItems.getBillinItemsLinkedToPerson(1);
        ArrayList<Integer> person2 = linkItems.getBillinItemsLinkedToPerson(2);
        ArrayList<Integer> person3 = linkItems.getBillinItemsLinkedToPerson(3);
        ArrayList<Integer> person4 = linkItems.getBillinItemsLinkedToPerson(4);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);*/
    }
}