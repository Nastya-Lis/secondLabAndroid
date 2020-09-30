package com.example.secondlabandroid.organization;

public enum University {

    BSTU("Here you can die"),
    BNTU("Chill"),
    BGU("There are successful people"),
    OTHER("Noname");
    University(String shortDescribe){
        describing = shortDescribe;
    }
    String describing;
    int count;

    public int getCount(){return count;}
    public void setCount(){count++;}
}
