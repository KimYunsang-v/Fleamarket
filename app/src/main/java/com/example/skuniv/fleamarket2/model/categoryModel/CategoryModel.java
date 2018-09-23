package com.example.skuniv.fleamarket2.model.categoryModel;

import com.example.skuniv.fleamarket2.R;

import java.util.HashMap;

public class CategoryModel {


    static final int CLOTH = 1;
    static final int ETC = 2;
    static final int FANCY = 3;
    static final int BOOK = 4;
    static final int ACC = 5;
    static final int DIGITAL = 6;

    // middle category of cloth
    static final int SHOES = 11;
    static final int TOP = 12;
    static final int BOTTOM = 13;
    static final int CAP = 14;
    static final int GLOVES = 15;

    // middle category of digital
    static final int PC = 31;
    static final int MOBILE = 32;
    static final int APPLIANCES = 33;
    static final int CAR = 34;
    static final int GAME = 35;
    static final int OUDIO = 36;


    // middle category of acc
    static final int RING = 61;
    static final int EARRING = 63;
    static final int NECKLACE = 63;
    static final int BRACELET = 64;
    static final int CLOCK = 65;
    static final int WALLET = 66;
    static final int BAG = 67;

    // middle category of fancy
    static final int NOTE = 81;
    static final int PEN = 82;
    static final int ART = 83;
    static final int TOY = 84;

    // middle category of book
    static final int NOVEL = 101;
    static final int ESSSAY = 102;
    static final int COMIC = 103;
    static final int AUTOBIOGRPHY = 104;
    static final int MAGAZINE = 105;
    static final int POEM = 106;

    // middle category of etc
    static final int PERFUME = 121;
    static final int CANDLE = 122;
    static final int COSMETICS = 123;
    static final int NAIL = 124;
    static final int HAIR = 125;
    static final int INSTRUMENT = 126;

    public int mainCategory;
    public int  middleCategory;
    public int pageNum;
    public String mainCategoryStr;
    public String middleCategoryStr;

    public String getMainCategoryStr() {
        return mainCategoryStr;
    }

    public void setMainCategoryStr(String mainCategoryStr) {
        this.mainCategoryStr = mainCategoryStr;
    }

    public String getMiddleCategoryStr() {
        return middleCategoryStr;
    }

    public void setMiddleCategoryStr(String middleCategoryStr) {
        this.middleCategoryStr = middleCategoryStr;
    }

    public static final HashMap<String, Integer> mainMap = new HashMap<String, Integer>(){
        {
            put("cloth",1);
            put("etc",2);
            put("fancy",3);
            put("book",4);
            put("digital",6);
            put("acc",5);
        }
    };
    public static final HashMap<String, Integer> middleMap = new HashMap<String, Integer>() {
        {
            put("신발", SHOES);
            put("상의", TOP);
            put("하의", BOTTOM);
            put("모자", CAP);
            put("pc", PC);
            put("모바일", MOBILE);
            put("가전", APPLIANCES);
            put("차량용품", CAR);
            put("게임", GAME);
            put("오디오", OUDIO);
            put("반지", RING);
            put("귀걸이", EARRING);
            put("목걸이", NECKLACE);
            put("팔찌", BRACELET);
            put("시계", CLOCK);
            put("지갑", WALLET);
            put("가방", BAG);
            put("공책", NOTE);
            put("필기구", PEN);
            put("미술용품", ART);
            put("장난감", TOY);
            put("소설", NOVEL);
            put("수필", ESSSAY);
            put("만화", COMIC);
            put("자서전", AUTOBIOGRPHY);
            put("잡지", MAGAZINE);
            put("시집", POEM);
            put("향수", PERFUME);
            put("향초", CANDLE);
            put("화장품", COSMETICS);
            put("네일", NAIL);
            put("헤어", HAIR);
            put("악기", INSTRUMENT);
        }
    };

    public CategoryModel(String category, int pageNum){
        this.mainCategoryStr = category;
        this.mainCategory = mainMap.get(category);
        this.pageNum = pageNum;
        /*if(category.equals("cloth")){
            middleCategory = TOP;
        }else if(category.equals("digital")){
            middleCategory = PC;
        }else if(category.equals("fancy")){
            middleCategory = NOTE;
        }else if(category.equals("acc")){
            middleCategory = RING;
        }else if(category.equals("book")){
            middleCategory = NOVEL;
        }else if(category.equals("etc")){
            middleCategory = PERFUME;
        }*/
    }

    public int getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainMap.get(mainCategory);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getMiddleCategory() {
        return middleCategory;
    }

    public void setMiddleCategory(String middleCategory) {
        this.middleCategory = middleMap.get(middleCategory);
        setMiddleCategoryStr(middleCategory);
    }
}
