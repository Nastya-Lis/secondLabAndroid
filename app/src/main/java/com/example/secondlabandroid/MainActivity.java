package com.example.secondlabandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.secondlabandroid.educationManager.JsonManipulations;
import com.example.secondlabandroid.educationManager.Manager;
import com.example.secondlabandroid.exception.ExclusivePeopleException;
import com.example.secondlabandroid.staff.Staff;
import com.example.secondlabandroid.units.Person;
import com.example.secondlabandroid.units.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String FILENAME = "misterJson.json";
        File file = new File(super.getFilesDir(), FILENAME);

        Person student = new Student();
        student.setName("Katia");
        student.setAge(19);
        student.setSurName("Kalala");
        Log.i("Mine_student", student.getName());
        Log.i("Mine_student", student.getSurName());
        Log.i("Mine_student", String.valueOf(student.getAge()));
        Staff staff = new Staff();
        staff.addToCollection(student);
        Log.i("Mine_campf", String.valueOf(staff.collectionStaffPeople.size()));

        Manager manager = new Manager();



        try {
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
            manager.createdRandomPerson();
        }
        catch (ExclusivePeopleException e){
            Log.i("Log_exception",  e.getMessage());
        }


        manager.takeFileFromActivity(file);
        manager.serialize();

      //  JsonManipulations jsonManipulations = new JsonManipulations();
        //jsonManipulations.isFileExists(file);

       Staff staff2 = manager.deserialize();
        for (int i = 0; i < staff2.collectionStaffPeople.size(); i++) {
            Log.i("Log_person", staff2.collectionStaffPeople.get(i).toString());

        }

        List<Student> st=manager.topThreeStudents();
        if(st!=null){
            for (Student s: st) {
                Log.i("Log_student", s.toString());
            }
        }
    }
}
