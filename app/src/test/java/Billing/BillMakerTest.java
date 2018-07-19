package Billing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BillMakerTest {
    Bill bill;

    @Before
    public void setUp() throws Exception {
        BillMaker billMaker = new BillMaker();
        bill = billMaker.createBill();
    }

    @Test
    public void addItem() {
        bill.addItem("apples", 20.00);
        assertEquals(bill.getTotalPrice(), 20.00, 0.001);
    }

    @Test
    public void addThreeItemsPriceMatches() {
        bill.addItem("apples", 20.00);
        bill.addItem("apples", 33.33);
        bill.addItem("pineapples", 10.34);
        assertEquals(bill.getTotalPrice(), 63.67, 0.001);
    }

    @Test
    public void addMultipleItemsPriceMatches() {
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

    @Test
    public void addMultipleItemsExistsByKey() {
        ArrayList<String> itemNames = new ArrayList<>();
        itemNames.add("apples");
        itemNames.add("apples");
        itemNames.add("pineapples");

        ArrayList<Double> itemPrices = new ArrayList<>();
        itemPrices.add(20.00);
        itemPrices.add(33.33);
        itemPrices.add(10.34);

        ArrayList<Integer> keys = bill.addMultipleItems(itemNames, itemPrices);

        assertEquals(bill.getName(keys.get(0)), "apples");
        assertEquals(bill.getName(keys.get(1)), "apples");
        assertEquals(bill.getName(keys.get(2)), "pineapples");

        assertEquals(bill.getPrice(keys.get(0)), 20.00, 0.001);
        assertEquals(bill.getPrice(keys.get(1)), 33.33, 0.001);
        assertEquals(bill.getPrice(keys.get(2)), 10.34, 0.001);
    }
}