package com.ysk.addressbook.entity;

public class Classes {
    private int classesId;
    private String classesNum;
    private String classesName;
    private  String headerURI;
    private  String classesURI;
    private  String monitorID;

    public String getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(String monitorID) {
        this.monitorID = monitorID;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getHeaderURI() {
        return headerURI;
    }

    public void setHeaderURI(String headerURI) {
        this.headerURI = headerURI;
    }

    public String getClassesNum() {
        return classesNum;
    }

    public void setClassesNum(String classesNum) {
        this.classesNum = classesNum;
    }

    public String getClassesURI() {
        return classesURI;
    }

    public void setClassesURI(String classesURI) {
        this.classesURI = classesURI;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classesId=" + classesId +
                ", classesNum='" + classesNum + '\'' +
                ", classesName='" + classesName + '\'' +
                ", headerURI='" + headerURI + '\'' +
                ", classesURI='" + classesURI + '\'' +
                ", monitorID='" + monitorID + '\'' +
                '}';
    }
}
