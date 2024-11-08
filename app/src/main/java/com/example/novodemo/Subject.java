package com.example.novodemo;

public class Subject {
    private String subject;
    private int imageId;
    public Subject(String subject, int imageId) {
        this.subject = subject;
        this.imageId = imageId;
    }
    public String getSubject() {
        return subject;
    }

    public int getImageId() {
        return imageId;
    }
}
