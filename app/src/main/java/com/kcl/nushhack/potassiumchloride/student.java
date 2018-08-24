package com.kcl.nushhack.potassiumchloride;

import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class student extends user {
    List<module> modules;
    int m_group,year;
    public student(int id,int m_group,int year,String name,String email,List<module> modules){
        this.id=id;
        this.m_group=m_group;
        this.year=year;
        this.name=name;
        this.email=email;
        this.modules=modules;
    }
    public void addModule(module module){
        modules.
    }

}
