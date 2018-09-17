package com.example.skuniv.fleamarket2.model.locatonModel;

public class SectionModel {
    String section;
    String sectionNum;

    public SectionModel(String section, String sectionNum){
        this.section = section;
        this.sectionNum = sectionNum;
    }

    public String getSection() {
        return section;
    }

    public String getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(String sectionNum) {
        this.sectionNum = sectionNum;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
