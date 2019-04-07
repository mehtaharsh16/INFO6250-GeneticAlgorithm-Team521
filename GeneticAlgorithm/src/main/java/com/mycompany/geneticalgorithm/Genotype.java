package com.mycompany.geneticalgorithm;

import java.util.Random;

public class Genotype {


    static Person[] genotypePopulation = new Person[2001];


    public static void main(String[] args){

        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        Random r = new Random();
        for(int i = 1; i<=2000; i++){
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P"+i+sex);
            p.setSex(sex);
            p.setFertile(r.nextBoolean());
            p.setRank(r.nextInt(800)/3) ;
            p.setGeneration(1);
            genotypePopulation[i] = p;
        }



        for(Person k : genotypePopulation){
            System.out.println(k);
        }
    }
}
