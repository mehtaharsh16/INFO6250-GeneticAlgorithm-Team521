/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geneticalgorithm;

/**
 * @author Welcome
 */

/**
 * Below is the person class
 */
public class Person {
    private String personID;
    private char sex;
    private boolean fertile;
    private double rank;
    private int generation;

    public int getGeneration() {
        return generation;
    }


    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean getFertile() {
        return fertile;
    }

    public void setFertile(boolean fertile) {
        this.fertile = fertile;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personID='" + personID + '\'' +
                ", sex=" + sex +
                ", fertile=" + fertile +
                ", rank=" + rank +
                ", generation=" + generation +
                '}';
    }
}
