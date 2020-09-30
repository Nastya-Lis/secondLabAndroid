package com.example.secondlabandroid.units;

public class Student extends Person {
    String institution;
    Person person;
    Integer mark;

    public Student(){

    }
    public Student(String institution) {
        this.institution = institution;
    }

    public Student(/*String name, String surName, Integer age, String curse ,
                   University university, */Person person,String institution,int mark) {
       // super(name, surName, age, curse,university);
        this.person = person;
        this.institution = institution;
        this.mark = mark;
    }
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        if(checkName(institution) == true)
        this.institution = institution;
        else
            this.institution = null;
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
}
