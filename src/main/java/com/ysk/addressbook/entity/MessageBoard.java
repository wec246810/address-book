package com.ysk.addressbook.entity;

import java.time.LocalTime;

public class MessageBoard {
    private String content;
    private User receiver;
    private LocalTime createTime;
    private User sender;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }


    @Override
    public String toString() {
        return "MessageBoard{" +
                "content='" + content + '\'' +
                ", receiver=" + receiver +
                ", createTime=" + createTime +
                ", sender=" + sender +
                '}';
    }
}
