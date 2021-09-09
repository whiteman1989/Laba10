package com.company.data.models;

import java.io.Serializable;
import java.util.UUID;

public class Student implements Serializable {
    UUID id;
    String firstName;
    String lastName;
    int age;
    float scores;
    int scoreCount;

    public Student(String firstName, String lastname, int age) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastname;
        this.age = age;
        scores = 0;
        scoreCount = 0;
    }

    public String GetFirstName() {
        return firstName;
    }

    public String GetLastName() {
        return lastName;
    }

    public String GetFullName() {
        return firstName+" "+lastName;
    }

    public void AddScore(float score) {
        scores += score;
        scoreCount ++;
    }

    public UUID GetId() {
        return id;
    }

    public int GetAge() {
        return age;
    }

    public float GetAvgScore() {
        return scores/scoreCount;
    }

    @Override
    public String toString() {
        return "name: "+GetFirstName()+" | age: "+age+" | average score: "+GetAvgScore();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public Student clone() {
        return new Student(firstName, lastName, age);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Student s = (Student) obj;
            return s.toString() == this.toString();
        }
        catch (ClassCastException e) {
            return false;
        }
    }
}
