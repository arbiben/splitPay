package Modules.Billing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillingItemTest {
    BillingItem billingItem;

    @Before
    public void setUp() throws Exception {
        billingItem = new BillingItem("apples", 20.00);
    }

    @Test
    public void testCorrectInstantiatedValue() {
        double expectedPrice = 20.00;
        double actualPrice = billingItem.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCorrectSplitValueNormally() {
        double expectedPrice = 11.11;
        billingItem.setPrice(33.33);
        double actualPrice = billingItem.splitBetween(3);

        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCorrectSplitValueRoundUp() {
        double expectedPrice = 6.67;
        double actualPrice = billingItem.splitBetween(3);

        assertEquals(expectedPrice, actualPrice, 0.001);
    }
}