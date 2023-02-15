package org.uma.mps.jesus;

import java.util.List;

public class Person {
    private final String name;

    private final int age;

    private final String gender;

    public Person(String name, int age, String gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name()
    {
        return name;
    }

    public int age()
    {
        return age;
    }

    public String gender()
    {
        return gender;
    }

    public double[] averageAgePerGender(List<Person> persons)
    {
        double[] numberOfPeoplePerGender = {0, 0};
        double[] sumOfAgesPerGender = {0, 0};
        double[] meansOfAgesPerGender = {0, 0};
        int numberOfGendersAnalyzed = 2;

        for (Person peopleOnTheList : persons)
        {
            if(peopleOnTheList.gender().toLowerCase().equals("man"))
            {
                numberOfPeoplePerGender[0]++;
                sumOfAgesPerGender[0] += peopleOnTheList.age();
            }

            if(peopleOnTheList.gender().toLowerCase().equals("woman"))
            {
                numberOfPeoplePerGender[1]++;
                sumOfAgesPerGender[1] += peopleOnTheList.age();
            }
        }

        for(int i = 0; i < numberOfGendersAnalyzed; i++)
        {
            if(sumOfAgesPerGender[i] == 0)
            {
                meansOfAgesPerGender[i] = 0;
            }
            else if (sumOfAgesPerGender[i] >= 0)
            {
                meansOfAgesPerGender[i] = sumOfAgesPerGender[i] / numberOfPeoplePerGender[i];
            }
            else
            {
                meansOfAgesPerGender[i] = -1;
            }
        }

        return meansOfAgesPerGender;
    }
}
