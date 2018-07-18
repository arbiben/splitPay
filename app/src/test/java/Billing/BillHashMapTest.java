package Billing;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BillHashMapTest {
    Bill bill;

    @Before
    public void setUp() throws Exception {
        bill = new BillHashMap();
    }

    @Test
    public void addItem() {
        bill.addItem("apples", 20.00);
        assertEquals(bill.getTotalPrice(), 20.00, 0.001);
    }

    @Test
    public void addThreeItems() {
        bill.addItem("apples", 20.00);
        bill.addItem("apples", 33.33);
        bill.addItem("pineapples", 10.34);
        assertEquals(bill.getTotalPrice(), 63.67, 0.001);
    }

    @Test
    public void addMultipleItems() {
        ArrayList<String> itemNames = new ArrayList<>();
        itemNames.add("apples");
        itemNames.add("apples");
        itemNames.add("pineapples");

        ArrayList<Double> itemPrices = new ArrayList<>();
        itemPrices.add(20.00);
        itemPrices.add(33.33);
        itemPrices.add(10.34);

        bill.addMultipleItems(itemNames, itemPrices);

        assertEquals(bill.getTotalPrice(), 63.67, 0.001);
    }
}