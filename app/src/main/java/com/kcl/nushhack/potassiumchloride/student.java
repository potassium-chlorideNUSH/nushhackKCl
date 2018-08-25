package com.kcl.nushhack.potassiumchloride;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student extends user {
    List<lesson> lessons;
    int m_group,year;

    public student(int id,int m_group,int year,String name,String email,List<lesson> lessons){
        super(email,name);
        this.m_group=m_group;
        this.year=year;
        this.lessons=lessons;
        FirebaseMessaging.getInstance().subscribeToTopic(Integer.toString(year));
        FirebaseMessaging.getInstance().subscribeToTopic(Integer.toString(m_group));
        for (lesson l: lessons) {
            FirebaseMessaging.getInstance().subscribeToTopic(l.getName());
        }
    }
    public void addLesson(lesson lesson){
        lessons.add(lesson);
    }

}
