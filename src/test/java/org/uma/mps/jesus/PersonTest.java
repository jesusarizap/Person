package org.uma.mps.jesus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    Person person2;
    Person personNegativeAge;
    List<Person> listOfPeople;
    @BeforeEach
    void setup()
    {
        person1 = new Person("Jesús", 22, "Man");
        person2 = new Person("María Jesús", 22, "Woman");
        personNegativeAge = new Person("Jesús Negativo", -22, "Man");
        listOfPeople = new ArrayList<Person>();
    }

    @AfterEach
    void shutdown()
    {
        person1 = null;
        person2 = null;
        listOfPeople = null;
    }
    @Test
    void nameOfPersonsIsSavedProperly(){

        String obtainedValue = person1.name();
        String expectedValue = "Jesús";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ageOfPersonIsSavedProperly()
    {
        int obtainedValue = person1.age();
        int expectedValue = 22;

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void genderOfAManIsSavedProperly()
    {
        String obtainedValue = person1.gender();
        String expectedValue = "Man";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void genderOfAWomanIsSavedProperly()
    {
        String obtainedValue = person2.gender();
        String expectedValue = "Woman";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void meanOfOneManIsItsOwnAge()
    {
        listOfPeople.add(person1);
        double[] obtainedValue = person1.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void meanOfOneWomanIsItsOwnAge()
    {
        listOfPeople.add(person2);
        double[] obtainedValue = person2.averageAgePerGender(listOfPeople);
        double[] expectedValue = {0, 22};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void meanOfOneManAndOneWomanAreItsAges()
    {
        listOfPeople.add(person1);
        listOfPeople.add(person2);
        double[] obtainedValue = person2.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 22};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void checkNegativeAges()
    {
        listOfPeople.add(personNegativeAge);
        double[] obtainedValue = personNegativeAge.averageAgePerGender(listOfPeople);
        double[] expectedValue = {-1, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }
}