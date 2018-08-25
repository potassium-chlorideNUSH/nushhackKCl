package com.kcl.nushhack.potassiumchloride;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student {
    private List<lesson> lessons;
    private String m_group, student_id;
    private int year;

    public List<lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<lesson> lessons) {
        this.lessons = lessons;
    }

    public String getM_group() {
        return m_group;
    }

    public void setM_group(String m_group) {
        this.m_group = m_group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public student(){}

    public student(String student_id,String m_group){
        this.student_id=student_id;
        this.m_group=m_group;
        this.year=m_group.charAt(0)-'0';
    }

}
