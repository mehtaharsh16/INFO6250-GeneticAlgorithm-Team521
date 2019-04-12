package com.mycompany.geneticalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Genotype {
    
    static int sampleLength = 10;
    private static Random r = new Random();
    
    
    public static void main(String[] args) {
        List<Person> genotypePopulation = new ArrayList<Person>();
        Genotype genotype= new Genotype();
        Generator generator = new Generator();
       
        int j = 0;
        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        //Random r = new Random();
        for (int i = 0; i <sampleLength; i++) {
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(r.nextBoolean());
            p.setRank((r.nextInt(800)/3)+1);
            p.setGeneration(1);
          
            genotypePopulation.add(p);
        }
        long startTime = System.nanoTime();
        int totalvisits = (int) (0.5 * genotypePopulation.size() * Math.log(genotypePopulation.size()));
       // int k = 1;
       // int currGen = 1;

        for (int k=2;k<=10;k++){
             List<Person> temp = new ArrayList<Person>();
            //System.out.println("Genotype population"+genotypePopulation.size());
            //System.out.println(k);
            for (int i = 0; i < totalvisits; i++) {
                if (j >= sampleLength) break;
                
                int randomperson1 = r.nextInt((genotypePopulation.size()));
             
               
                if (!genotypePopulation.get(randomperson1).getFertile()){
                    continue;
                } else {
                    int randomperson2 = r.nextInt(genotypePopulation.size());
                    
                    if (genotypePopulation.get(randomperson1).getSex() == 'M') {
                        while ((genotypePopulation.get(randomperson2).getSex() != 'F') || !(genotypePopulation.get(randomperson2).getFertile())) {

                            randomperson2 = r.nextInt(genotypePopulation.size());
                            if (genotypePopulation.get(randomperson2).getFertile() && genotypePopulation.get(randomperson2).getSex() == 'F' )
                                break;
                            continue;

                        }
                        double rankvalue = generator.generatePhenotype(genotypePopulation.get(randomperson1), genotypePopulation.get(randomperson2));
                        if (generator.isFit(rankvalue)) {
                            String child = genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID();
                            System.out.println(child);
                            return;
                        } else {
                            Person person = new Person();
                            person.setPersonID(genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID());
                            //k+=1;
                            person.setGeneration(k);
                            //System.out.println(k);
                            person.setRank(rankvalue);
                            if (r.nextInt(2) < 1) {
                                person.setFertile(true);
                            } else {
                                person.setFertile(false);
                            }
                            if (r.nextInt(2) < 1) {
                                person.setSex('M');
                            } else {
                                person.setSex('F');
                            }
                            temp.add(person);
                            j+=1;
                        }
                    } else if (genotypePopulation.get(randomperson1).getSex() == 'F') {
                        while ((genotypePopulation.get(randomperson2).getSex() != 'M') || !(genotypePopulation.get(randomperson2).getFertile())) {
                            randomperson2 = r.nextInt(genotypePopulation.size());
                            if (genotypePopulation.get(randomperson2).getFertile() && genotypePopulation.get(randomperson2).getSex() == 'M' )
                                break;
                            continue;

                        }
                        double rankvalue = generator.generatePhenotype(genotypePopulation.get(randomperson1), genotypePopulation.get(randomperson2));
                        if (generator.isFit(rankvalue)) {
                            String child = genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID();
                            System.out.println(child);
                            return;
                        } else {
                            Person person = new Person();
                            person.setPersonID(genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID());
                            //k+=1;
                            person.setGeneration(k);
                            //System.out.println(k);
                            person.setRank(rankvalue);
                            if (r.nextInt(2) < 1) {
                                person.setFertile(true);
                            } else {
                                person.setFertile(false);
                            }
                            if (r.nextInt(2) < 1) {
                                person.setSex('M');
                            } else {
                                person.setSex('F');
                            }
                            temp.add(person);
                            j+=1;
                        }
                    }
                }
            }
            
            genotypePopulation = temp;
           for(Person p:genotypePopulation)
           {   
               if(p!=null)
               System.out.println(p);
            }
            
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for find the super human genome is "+(endTime-startTime));
    }
}
