package com.example.assignment_1;

public class Motivation {
    private String text;

    public Motivation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text ;
    }
}
