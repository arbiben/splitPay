package com.example.ben.splitpay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkItemsTest {
    LinkItems linkItems;
    @Before
    public void setUp() throws Exception {
        linkItems = new LinkItems();
    }

    @Test
    public void linkItems() {
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
    }
}