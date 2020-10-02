package com.example.secondlabandroid.educationManager;

import com.example.secondlabandroid.units.Person;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        if(person.getAge() > t1.getAge())
            return 1;
        else if(person.getAge() < t1.getAge())
            return -1;
        else
            return 0;
    }
}
