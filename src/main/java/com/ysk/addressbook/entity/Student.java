package com.ysk.addressbook.entity;

public class Student {
    private String name;
    private String sid;
    private String sex;
    private Integer age;
    private String hobby;
    private String address;
    private String classesNum;
    private String favoritePeople;
    private String favoriteFood;
    private String favoriteFruit;
    private String favoriteWords;
    private String qq;
    private String tel;
    private String email;
    private String headerURI;


    public String getHeaderURI() {
        return headerURI;
    }

    public void setHeaderURI(String headerURI) {
        this.headerURI = headerURI;
    }

    public String getFavoritePeople() {
        return favoritePeople;
    }

    public void setFavoritePeople(String favoritePeople) {
        this.favoritePeople = favoritePeople;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getClassesNum() {
        return classesNum;
    }

    public void setClassesNum(String classesNum) {
        this.classesNum = classesNum;
    }


    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public String getFavoriteWords() {
        return favoriteWords;
    }

    public void setFavoriteWords(String favoriteWords) {
        this.favoriteWords = favoriteWords;
    }


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                ", classesNum='" + classesNum + '\'' +
                ", favoritePeople='" + favoritePeople + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                ", favoriteWords='" + favoriteWords + '\'' +
                ", qq='" + qq + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", headerURI='" + headerURI + '\'' +
                '}';
    }
}
