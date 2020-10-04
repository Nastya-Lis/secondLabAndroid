package com.example.secondlabandroid.units;

import com.example.secondlabandroid.organization.University;

import java.util.Optional;

public class Student extends Person {
    University university;
    Integer mark;

    public Student(){

    }
    public Student(University university,int mark) {
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

    static public Optional<University> giveSomeStaffs(Student stud)
    {return Optional.ofNullable(stud.getUniversity());}
}
