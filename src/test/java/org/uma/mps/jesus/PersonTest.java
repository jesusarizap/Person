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
    void NameOfPersonsIsSafeProperly(){

        String obtainedValue = person.name();
        String expectedValue = "Jesús";

        assertEquals(expectedValue, obtainedValue);
    }
}