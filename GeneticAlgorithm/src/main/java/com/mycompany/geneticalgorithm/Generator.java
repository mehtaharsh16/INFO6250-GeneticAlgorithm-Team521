package com.mycompany.geneticalgorithm;

import java.text.DecimalFormat;
import java.util.Random;

/*
    @param = fitValue is the fitness value to be compared with each person's fit value
*/


public class Generator {

    
    private final double fitValue = 200;
    public char checkSex(Person p){

        return p.getSex();
    }


    public boolean checkFertilty(Person p){
        if (p.getFertile()){
            return true;
        }else
            return false;
    }


    public double generatePhenotype(Person p1, Person p2){

            double rankValue;
            Random r = new Random();
            double male = r.nextInt((p1.getPersonID().length())) * 0.33;
            double female = r.nextInt((p2.getPersonID().length())) * 1.35;
            rankValue = (Math.log(1.5) * (p1.getRank()*female + p2.getRank() * male) * 0.2) ;
            
        return rankValue;
    }


    public boolean isFit(double rank){
      boolean compare = (rank < fitValue) ? false : true;  
       return  compare;
    }



}
