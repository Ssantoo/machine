package com.example.draw;

public enum Grade {
    A("A"), B("B");

    private final String grade;

    Grade(final String grade) { this.grade = grade;}

    public String getGrade() { return grade;}

}
