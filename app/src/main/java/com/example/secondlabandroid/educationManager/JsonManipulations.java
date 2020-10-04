package com.example.secondlabandroid.educationManager;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondlabandroid.MainActivity;
import com.example.secondlabandroid.staff.Staff;
import com.example.secondlabandroid.units.Listener;
import com.example.secondlabandroid.units.Person;
import com.example.secondlabandroid.units.Student;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManipulations {
    ObjectMapper objectMapper;

    public boolean isFileExists(File file) {
        if(file!=null) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    Log.i("Log_json", "File has been just created");
                    return true;
                } catch (IOException e) {
                    Log.i("Log_json", "File is not created. Lox");
                    return false;
                }
            }
            else {
                //file.delete();
                Log.i("Log_json", "File exists");
                return true;
            }
        }
        else{
            Log.i("Log_json","File == null");
            return false;
        }

    }

    public void serializationToJson(File file, Staff staffPerson){

      if(isFileExists(file)){
          objectMapper = new ObjectMapper();
          try {
              objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,staffPerson);
          }
          catch (IOException e) {
             Log.i("Log_json","Oops, your serialization doesn't work");
          }
      }

    }

    public Staff deserializationFromJson(File file){
        if(file!=null){
            try {
               objectMapper = new ObjectMapper();
                Staff staff = objectMapper.readValue(file,Staff.class);
                return staff;
            } catch (IOException e) {
                Log.i("Log_json","Couldn't read file");
                return null;
            }
           /* try {
                Student person = objectMapper.readValue(fromJson,Student.class);
                ArrayList<Person> list = new ArrayList<>();
                list.add(person);
                return list;
            }
            catch (IOException e) {
                try {
                    Listener pers  = objectMapper.readValue(fromJson,Listener.class);
                    ArrayList<Person> list2 = new ArrayList<>();
                    list2.add(pers);
                    return list2;
                } catch (IOException ex) {
                    Log.i("Log_json","Couldnt read michael ");
                    return new ArrayList<>();
                }
            }*/
        }
        else{
            return null;
        }
    }
}
