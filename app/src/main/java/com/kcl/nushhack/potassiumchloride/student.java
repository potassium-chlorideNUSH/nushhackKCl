package com.kcl.nushhack.potassiumchloride;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student extends user {
    List<lesson> lessons;
    int m_group,year;

    public student(int id,int m_group,int year,String name,String email,List<lesson> lessons){
        this.id=id;
        this.m_group=m_group;
        this.year=year;
        this.name=name;
        this.email=email;
        this.lessons=lessons;
    }
    public void addLesson(lesson lesson){
        lessons.add(lesson);
    }

}
