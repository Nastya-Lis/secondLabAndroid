package com.example.secondlabandroid.educationManager;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.secondlabandroid.organization.University;
import com.example.secondlabandroid.staff.Staff;
import com.example.secondlabandroid.units.Listener;
import com.example.secondlabandroid.units.Person;
import com.example.secondlabandroid.units.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Manager {
    private Staff staff;
    public Person person;
    File file;
    public JsonManipulations jsonManipulations = new JsonManipulations();

    public void createdRandomPerson()
    {
       // boolean kindOfPeople = (new Random()).nextBoolean();
        if((new Random()).nextBoolean()){
            person = new Student();
            ((Student)person).setInstitution(String.valueOf(University.values()
                    [(new Random()).nextInt(University.values().length-1)]));
            ((Student)person).setMark((new Random().nextInt(10)));
        }
        else{
            person = new Listener();
            ((Listener)person).setOrganization(GeneratedPeople.getOrganizations()
                    [(new Random()).nextInt(GeneratedPeople.getOrganizations().length-1)]);
        }
        person.setName(GeneratedPeople.getNames()[(new Random()).
                nextInt(GeneratedPeople.getNames().length-1)]);
        person.setSurName(GeneratedPeople.getSurnames()[(new Random()).
                nextInt(GeneratedPeople.getSurnames().length-1)]);
        person.setCurse(GeneratedPeople.getCurses()[(new Random()).
                nextInt(GeneratedPeople.getCurses().length-1)]);
        person.setAge((new Random()).nextInt(57));

        //staff.addToCollection(person);
        if(file!=null)
        jsonManipulations.serializationToJson(file,person);

    }
//или лучше было бы сделать конструктор с/ без параметров
    public void takeFileFromActivity(File file){
        this.file = file;
    }

    static class GeneratedPeople{
        public static String[] getNames(){return new String[]{"Настя", "Катя", "Диана",
                "Лера", "Оля"}; }
        public static String[] getSurnames(){return  new String[]{"Лисункова", "Гарляк","Керезь",
                "Япубенко", "Буденок"};}
        public static String[] getCurses(){return new String[]{"C#","Java","Js","Python","Kotlin"};}
        public static  String[] getOrganizations(){return new String[]{"Itechart","EPAM","SAP",
                "Belhard"};}
    }
}
