package com.example.secondlabandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.secondlabandroid.educationManager.Manager;
import com.example.secondlabandroid.staff.Staff;
import com.example.secondlabandroid.units.Person;
import com.example.secondlabandroid.units.Student;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String FILENAME = "misterJson.json";
        File file = new File(super.getFilesDir(),FILENAME);

        Person student = new Student();
        student.setName("Katia");
        student.setAge(19);
        student.setSurName("Kalala");
        Log.i("Mine_student",student.getName());
        Log.i("Mine_student",student.getSurName());
        Log.i("Mine_student",String.valueOf(student.getAge()));
        Staff staff = new Staff();
        staff.addToCollection(student);
        Log.i("Mine_campf",String.valueOf(staff.collectionStaffPeople.size()));

        Manager manager = new Manager();
        manager.takeFileFromActivity(file);
        manager.createdRandomPerson();
        Log.i("Log_name",manager.person.getName());
        ArrayList<Person> pp = manager.jsonManipulations.deserializationFromJson();
        Log.i("Log_smth",String.valueOf(pp.size()) + "lalalal");
        for (Person i: pp) {
            Log.i("Log_smth", i.toString());
        }
       // manager.jsonManipulations.serializationToJson(file);
       // manager.jsonManipulations.deserializationFromJson();
    }
}