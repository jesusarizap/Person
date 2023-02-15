package org.uma.mps.jesus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
@author Jesús Ariza Pomares
Test cases:
1. Checks if the name that's been given to a person is saved/stored properly.
2. Checks if the age that's been given to a person is saved/stored properly.
3. Checks if the gender (man) that's been given to a person is saved/stored properly.
4. Checks if the gender (woman) that's been given to a person is saved/stored properly.
5. Checks if when only one man is added to a list, the mean gets calculated properly.
6. Checks if when only one woman is added to a list, the mean gets calculated properly.
7. Checks if when one man and one woman are added to a list, both means get calculated properly.
8. Checks if a list with multiple men and multiple women returns the means for both genders properly.
9. Checks if a negative value for the age of man is treated correctly.
10. Checks if a negative value for the age of a woman is treated correctly.
 */

class PersonTest {
    Person person1, person2, person3, person4, person5, person6;
    Person personNegativeAge;
    List<Person> listOfPeople;
    @BeforeEach
    void setup()
    {
        person1 = new Person("Jesús", 22, "Man");
        person2 = new Person("María Jesús", 22, "Woman");
        person3 = new Person("JesúsDos", 44, "Man");
        person4 = new Person("María JesúsDos", 44, "Woman");
        person5 = new Person("JesúsDos María", 53, "Woman");
        person6 = new Person("Ultima", 19, "Woman");
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
    void correctMeanWithMultipleMenAndMultipleWomen()
    {
        listOfPeople.add(person1);
        listOfPeople.add(person2);
        listOfPeople.add(person3);
        listOfPeople.add(person4);
        listOfPeople.add(person5);
        listOfPeople.add(person6);

        double[] obtainedValue = person1.averageAgePerGender(listOfPeople);
        double[] expectedValue = {33, 34.5};

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