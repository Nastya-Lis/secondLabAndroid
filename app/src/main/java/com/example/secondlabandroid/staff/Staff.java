package com.example.secondlabandroid.staff;

import java.util.ArrayList;
import com.example.secondlabandroid.units.Person;
public class Staff {
    public ArrayList<Person> collectionStaffPeople;

    public Staff(){
        collectionStaffPeople = new ArrayList<>();
    }

    public Staff(ArrayList<Person> collection){
        this.collectionStaffPeople = collection;
    }

    public void addToCollection(Person person){
        addPerson.addOperation(person);
    }

    OperationAdd addPerson = (person) -> collectionStaffPeople.add(person);

    public void deleteFromCollection(Person person){

        if(collectionStaffPeople.contains(person)){
            collectionStaffPeople.remove(person);
        }
    }

    }
    //functional interface
    interface OperationAdd{
    void addOperation(Person person);
    }

