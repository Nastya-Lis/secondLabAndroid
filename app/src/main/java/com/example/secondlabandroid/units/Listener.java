package com.example.secondlabandroid.units;

import com.example.secondlabandroid.organization.University;

public class Listener extends Person {
   // Person person;
    String Organization;

    public Listener(){

    }

    public Listener(String organization) {
        Organization = organization;
    }


    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        if(checkName(organization))
            Organization = organization;
        else
            Organization = null;
    }

    @Override
    public String toString() {
        return "Listener{" + super.toString() +
                ", Organization='" + Organization + '\'' +
                '}';
    }
}
