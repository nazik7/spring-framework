package com.cydeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java {
    //@Autowired   //field Injection
    OfficeHours officeHours;
   // @Autowired //Constructor Injection
    public Java(OfficeHours officeHours){
        this.officeHours = officeHours;
    }
    public void getTeachingHours(){
        System.out.println("Weekly Teaching hourse: " +(20 + officeHours.getHours()));
    }
}
