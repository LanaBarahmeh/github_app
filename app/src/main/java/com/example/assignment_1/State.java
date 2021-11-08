package com.example.assignment_1;

public class State {
    private String lastex;
    private String advice;

    public State(String lastex){
        this.lastex = lastex;
            }

    public String getLastex() {
        return lastex;
    }

    public void setLastex(String lastex) {
        this.lastex = lastex;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "last exercise is" + lastex + '\'' +
                ", we advise you to " + advice + '\'' +
                '}';
    }
}
