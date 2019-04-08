package com.mycompany.geneticalgorithm;

import java.util.Random;

/*
    @param = fitValue is the fitness value to be compared with each person's fit value
*/


public class Generator {

    
    private final long fitValue = 2000;
    public char checkSex(Person p){

        return p.getSex();
    }


    public boolean checkFertilty(Person p){
        if (p.getFertile()){
            return true;
        }else
            return false;
    }


    public long generatePhenotype(Person p1, Person p2){

            long rankValue = 0;
            Random r = new Random();
            long male = r.nextInt(p1.getPersonID().length()*10);
            long female = r.nextInt(p2.getPersonID().length()*12);
            rankValue = (long) Math.log(Math.exp(1.5)) * (p1.getRank()*female + p2.getRank() * male);
            
        return rankValue;
    }


    public boolean isFit(long rank){
      boolean compare = (rank < fitValue) ? false : true;  
       return  compare;
    }



}
