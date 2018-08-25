package com.kcl.nushhack.potassiumchloride;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student {
    //lesson ID
    private List<String> lessons = new ArrayList<>();
    private long m_group, stu_id, year;

    public List<String> getLessons() {
        return lessons;
    }

    public void addLessons(String ls) {
        this.lessons.add(ls);
    }

    public long getM_group() {
        return m_group;
    }

    public void setM_group(long m_group) {
        this.m_group = m_group;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getStu_id() {
        return stu_id;
    }

    public void setStu_id(long stu_id) {
        this.stu_id = stu_id;
    }

    public student(){}

    public student(long stu_id,long m_group, long year){
        this.stu_id=stu_id;
        this.m_group=m_group;
        this.year=year;
    }


}
