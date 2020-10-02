package com.example.secondlabandroid.units;

import com.example.secondlabandroid.organization.University;

public class Student extends Person {
    University university;
    //Person person;
    Integer mark;

    public Student(){

    }
    public Student(/*String name, String surName, Integer age, String curse ,
                   University university, *//*Person person,*/University university,int mark) {
       // super(name, surName, age, curse,university);
        //this.person = person;
        this.university = university;
        this.mark = mark;
    }
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if(mark >=0 && mark <= 10)
        this.mark = mark;
        else
            this.mark = null;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "university=" + university +
                ", mark=" + mark +
                '}';
    }
}
