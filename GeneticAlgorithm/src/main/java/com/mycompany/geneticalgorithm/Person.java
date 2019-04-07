/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geneticalgorithm;

/**
 *
 * @author Welcome
 */
public class Person {
    private String personID;
    private char sex;
    private boolean fertile;
    private long rank;

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

    public boolean isFertile() {
        return fertile;
    }

    public void setFertile(boolean fertile) {
        this.fertile = fertile;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
    
}
