package week2;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Order(2)
    @Test
    public void assertAdult() {
        Person person = new Person(18);
        assertTrue(person.isAdult());
    }
    @Test
    public void assertChild(){
        Person person = new Person(15);
        assertFalse(person.isAdult());
    }

    @Test
    public void testArrayOfPersons() {
        Person[] persons = {new Person(18), new Person(15), new Person(20), new Person(10), new Person(25)};
        for (Person person : persons) {
            if (person.isAdult()) {
                assertTrue(person.isAdult());
                System.out.println(person.age + " is an adult");
            } else {
                assertFalse(person.isAdult());
                System.out.println(person.age + " is a child");
            }
        }
        for (int i = 0; i < persons.length; i++) {
            persons[i] = null;
        }
    }

    @Test
    public void testAgeLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> new Person(-1));
    }

    @Order(1)
    @Test
    public void testIfPersonCanGoToSchool() {
        Person person = new Person(6);
        assertTrue(person.canGoToSchool());
    }
}