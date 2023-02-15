package org.uma.mps.jesus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
11. Checks if an empty lists get treated properly.
12. Checks if a man and a woman added to the list, with its gender string having different types of lower/upper cases.
(13). When trying to check if a person with a non integer age returns a RuntimeException, java doesn't compile because of incompatible types
(14). When trying to give a number too big for age java doesn't compile because "integer number too large".
 */

class PersonTest {
    Person person1, person2, person3, person4, person5, person6;
    Person manNegativeAge, womanNegativeAge;

    Person manWithDifferentUpperCases, womanWithDifferentUpperCases;

    Person personNoninteger;
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

        manNegativeAge = new Person("Jesús Negativo", -22, "Man");
        womanNegativeAge = new Person("Jesús Negativo", -22, "woman");

        manWithDifferentUpperCases = new Person("Jesús", 22, "mAn");
        womanWithDifferentUpperCases = new Person("Jesús", 22, "woMan");

        personNoninteger = new Person ("Jesús", 22, "MAN");

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
    @DisplayName("1. Name of person is saved properly")
    void nameOfPersonsIsSavedProperly(){

        String obtainedValue = person1.name();
        String expectedValue = "Jesús";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("2. Age of person is saved properly")
    void ageOfPersonIsSavedProperly()
    {
        int obtainedValue = person1.age();
        int expectedValue = 22;

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("3. Gender of a man is saved properly")
    void genderOfAManIsSavedProperly()
    {
        String obtainedValue = person1.gender();
        String expectedValue = "Man";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("4. Gender of a woman is saved properly")
    void genderOfAWomanIsSavedProperly()
    {
        String obtainedValue = person2.gender();
        String expectedValue = "Woman";

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("5. Mean of one man is its own age")
    void meanOfOneManIsItsOwnAge()
    {
        listOfPeople.add(person1);
        double[] obtainedValue = person1.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("6. Mean of one woman is its own age")
    void meanOfOneWomanIsItsOwnAge()
    {
        listOfPeople.add(person2);
        double[] obtainedValue = person2.averageAgePerGender(listOfPeople);
        double[] expectedValue = {0, 22};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("7. Mean of one man and one woman are its ages")
    void meanOfOneManAndOneWomanAreItsAges()
    {
        listOfPeople.add(person1);
        listOfPeople.add(person2);
        double[] obtainedValue = person1.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 22};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("8. Correct mean with multiple men and multiple women")
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
    @DisplayName("9. Check negative age of a man")
    void checkManNegativeAge()
    {
        listOfPeople.add(manNegativeAge);
        double[] obtainedValue = manNegativeAge.averageAgePerGender(listOfPeople);
        double[] expectedValue = {-1, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("10. Check negative age of a woman")
    void checkWomanNegativeAge()
    {
        listOfPeople.add(womanNegativeAge);
        double[] obtainedValue = womanNegativeAge.averageAgePerGender(listOfPeople);
        double[] expectedValue = {0, -1};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("11. Check if the list is empty")
    void checkIfTheListIsEmpty()
    {
        double[] obtainedValue = person1.averageAgePerGender(listOfPeople);
        double[] expectedValue = {0, 0};

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("12. Check for a man and a woman added to the list with different upper cases")
    void checkForAManAndAWomanAddedToTheListWithDifferentUpperCases()
    {
        listOfPeople.add(manWithDifferentUpperCases);
        listOfPeople.add(womanWithDifferentUpperCases);

        double[] obtainedValue = manWithDifferentUpperCases.averageAgePerGender(listOfPeople);
        double[] expectedValue = {22, 22};

        assertArrayEquals(expectedValue, obtainedValue);
    }
}