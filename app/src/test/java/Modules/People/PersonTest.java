package Modules.People;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("John", "Smith");
    }

    @Test
    public void testCorrectInstantiatedName() {
        String expectedName = "John Smith";
        String actualName = person.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testCorrectInstantiatedInitials() {
        String expectedName = "JS";
        String actualName = person.getInitials();

        assertEquals(expectedName, actualName);
    }
}