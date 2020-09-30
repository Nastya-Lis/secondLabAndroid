package com.example.secondlabandroid.units;

import com.example.secondlabandroid.organization.University;

public abstract class Person {
    String name;
    String surName;
    Integer age;
    String curse;
    University university;

    public Person(){

    }

    public Person(String name,String surName,Integer age,String curse,University university){
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.curse = curse;
        this.university = university;
    }

    protected Boolean checkName(String name){
        try{
            Integer.parseInt(name);
            return false;
        }
        catch(NumberFormatException e){
            return true;
        }
    }
    //Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(checkName(name) == true)
            this.name = name;
        else
            this.name = null;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=16 && age<=56)
        this.age = age;
        else
            this.age = null;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if(checkName(surName) == true)
        this.surName = surName;
        else
            this.surName = null;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        if(checkName(curse) == true)
        this.curse = curse;
        else
            this.curse = null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", curse='" + curse + '\'' +
                ", university=" + university +
                '}';
    }

    /* public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }*/
}
