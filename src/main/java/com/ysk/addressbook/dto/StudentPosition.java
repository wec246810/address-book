package com.ysk.addressbook.dto;

public class StudentPosition {
    private String perStudentSid;
    private String nextStudentSid;
    private int position;

    public String getPerStudentSid() {
        return perStudentSid;
    }

    public void setPerStudentSid(String perStudentSid) {
        this.perStudentSid = perStudentSid;
    }

    public String getNextStudentSid() {
        return nextStudentSid;
    }

    public void setNextStudentSid(String nextStudentSid) {
        this.nextStudentSid = nextStudentSid;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
