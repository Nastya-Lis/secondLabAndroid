package com.example.secondlabandroid.educationManager;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.secondlabandroid.exception.ExclusivePeopleException;
import com.example.secondlabandroid.organization.University;
import com.example.secondlabandroid.staff.Staff;
import com.example.secondlabandroid.units.Listener;
import com.example.secondlabandroid.units.Person;
import com.example.secondlabandroid.units.Student;



import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Stream;

public class Manager implements IAction{
    private Staff staff = new Staff();
    public Person person;
    File file;
    public JsonManipulations jsonManipulations = new JsonManipulations();

    public List<Student> topThreeStudents(){
        if(staff.collectionStaffPeople.size()!=0)
        {
            ArrayList<Student> students = new ArrayList<>();
            for (Person student: staff.collectionStaffPeople) {
                if(student instanceof Student) {
                    students.add((Student) student);
                }
            }
            if(students.size()!=0 && students.size() > 3 ){
               students.sort((a, b) -> String.valueOf(b.getMark()).
                       compareTo(String.valueOf(a.getMark())) );
               List<Student> topStudents = students.subList(0,3);
               return topStudents;
            }
            else{
                return null;
            }
        }
        else{
            Log.i("Log_manager","There aren't or not necessary amount of student");
            return null;
        }
    }

    public void doubleCriterion(){
        Comparator<Person> personsComparing= new ComparatorPerson().
                thenComparing(person -> person.getSurName());
        Collections.sort(staff.collectionStaffPeople,personsComparing);
    }

    public void createdRandomPerson() throws ExclusivePeopleException
    {
       // boolean kindOfPeople = (new Random()).nextBoolean();
        if((new Random()).nextBoolean()){
            person = new Student();
            ((Student)person).setUniversity((University.values()
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

        if(staff.collectionStaffPeople.contains(person)){
            throw new ExclusivePeopleException("Such object exists");
        }
        else
        staff.addToCollection(person);

    }
    public void serialize(){
        if(file!=null && staff!=null)
            jsonManipulations.serializationToJson(file,staff);
    }

    public Staff deserialize(){
        Staff staff1 = jsonManipulations.deserializationFromJson(file);
        return staff1;
    }

//или лучше было бы сделать конструктор с/ без параметров
    public void takeFileFromActivity(File file){
        this.file = file;
    }

   /* static class GeneratedPeople{
        public static String[] getNames(){return new String[]{"Настя", "Катя", "Диана",
                "Лера", "Оля"}; }
        public static String[] getSurnames(){return  new String[]{"Лисункова", "Гарляк","Керезь",
                "Япубенко", "Буденок"};}
        public static String[] getCurses(){return new String[]{"C#","Java","Js","Python","Kotlin"};}
        public static  String[] getOrganizations(){return new String[]{"Itechart","EPAM","SAP",
                "Belhard"};}
    }*/
}
