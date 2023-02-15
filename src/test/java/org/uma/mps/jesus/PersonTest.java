package org.uma.mps.jesus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    @BeforeEach
    void setup()
    {
        person = new Person("Jesús", 22, "Hombre");
    }

    @AfterEach
    void shutdown()
    {
        person = null;
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

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    void GenderOfPersonIsSavedProperly()
    {
        String obtainedValue = person.gender();
        String expectedValue = "Hombre";

        assertEquals(obtainedValue, expectedValue);
    }
}