package com.kcl.nushhack.potassiumchloride;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy5 on 24/8/2018.
 */

public class teacher extends user {
    private List<String> lessonTeach = new ArrayList<>();
    private String name;
    public teacher(){

    }
    public teacher(String name){

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLessonTeach(){
        return this.lessonTeach;
    }
    public void addLessonTeach(String e){
        lessonTeach.add(e);
    }
}
