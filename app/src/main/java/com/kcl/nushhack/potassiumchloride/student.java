package com.kcl.nushhack.potassiumchloride;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student {
    private List<lesson> lessons;
    private int m_group,year,student_id;

    public List<lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<lesson> lessons) {
        this.lessons = lessons;
    }

    public int getM_group() {
        return m_group;
    }

    public void setM_group(int m_group) {
        this.m_group = m_group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public student(){}

    public student(int student_id,int m_group,int year){
        this.student_id=student_id;
        this.m_group=m_group;
        this.year=year;
    }

}
