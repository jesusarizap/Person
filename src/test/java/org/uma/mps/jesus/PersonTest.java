package org.uma.mps.jesus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    List<Person> listOfPeople;
    @BeforeEach
    void setup()
    {
        person = new Person("Jesús", 22, "Hombre");
        listOfPeople = new ArrayList<Person>();
    }

    @AfterEach
    void shutdown()
    {
        person = null;
        listOfPeople = null;
    }
    @Test
    void NameOfPersonsIsSavedProperly(){

        String obtainedValue = person.name();
        String expectedValue = "Jesús";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void AgeOfPersonIsSavedProperly()
    {
        int obtainedValue = person.age();
        int expectedValue = 22;

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void GenderOfPersonIsSavedProperly()
    {
        String obtainedValue = person.gender();
        String expectedValue = "Hombre";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void MeanOfOneManIsItsOwnAge()
    {
        listOfPeople.add(person);
        double[] obtainedValue = person.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }
}