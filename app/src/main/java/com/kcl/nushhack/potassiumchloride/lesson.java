package com.kcl.nushhack.potassiumchloride;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class lesson {
    private String name;
    private int m_group, year;
    private List<student> students;
    private teacher teacher;

    public lesson(String name, int m_group, int year, List<student> students, com.kcl.nushhack.potassiumchloride.teacher teacher) {
        this.name = name;
        this.m_group = m_group;
        this.year = year;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    public com.kcl.nushhack.potassiumchloride.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.kcl.nushhack.potassiumchloride.teacher teacher) {
        this.teacher = teacher;
    }
}





