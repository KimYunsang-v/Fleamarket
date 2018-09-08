package com.example.skuniv.fleamarket2.model;

public class SectionModel {
    String section;
    int sectionNum;

    public SectionModel(String section, int sectionNum){
        this.section = section;
        this.sectionNum = sectionNum;
    }

    public String getSection() {
        return section;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
