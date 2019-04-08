package com.mycompany.geneticalgorithm;

import java.util.Random;

public class Genotype {

    private static Random r = new Random();


    static Person[] genotypePopulation = new Person[2001];


    public static void main(String[] args) {
        Generator generator = new Generator();
        Person[] temp = new Person[2001];
        int j = 0;
        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        //Random r = new Random();
        for (int i = 0; i <2000; i++) {
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(r.nextBoolean());
            p.setRank(r.nextInt(800) / 3);
            p.setGeneration(1);
            genotypePopulation[i] = p;
        }
        int totalvisits = (int) (0.5 * genotypePopulation.length * Math.log(genotypePopulation.length));
        for (int i = 0; i < totalvisits; i++) {
            int randomperson1 = r.nextInt((genotypePopulation.length ));
            if (!genotypePopulation[randomperson1].getFertile()) {
                continue;
            } else {
                int randomperson2 = r.nextInt(genotypePopulation.length );
                if (genotypePopulation[randomperson1].getSex() == 'M') {
                    while ((genotypePopulation[randomperson2].getSex() != 'F' ) || !(genotypePopulation[randomperson2].getFertile())) {

                        randomperson2 = r.nextInt(genotypePopulation.length );
                        if(genotypePopulation[randomperson2].getFertile()&&genotypePopulation[randomperson2].getSex()=='F')
                            break;
                        continue;

                    }
                    long rankvalue = generator.generatePhenotype(genotypePopulation[randomperson1], genotypePopulation[randomperson2]);
                    if (generator.isFit(rankvalue)) {
                        String child = genotypePopulation[randomperson1].getPersonID() + genotypePopulation[randomperson2].getPersonID();
                        System.out.println(child);
                        return;
                    } else {
                        Person person = new Person();
                        person.setPersonID(genotypePopulation[randomperson1].getPersonID() + genotypePopulation[randomperson2].getPersonID());
                        person.setGeneration(2);
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
                        temp[j++] = person;

                    }
                } else if (genotypePopulation[randomperson1].getSex() == 'F') {
                    while ((genotypePopulation[randomperson2].getSex() != 'M' ) || !(genotypePopulation[randomperson2].getFertile())) {
                        randomperson2 = r.nextInt(genotypePopulation.length );
                        if(genotypePopulation[randomperson2].getFertile()&&genotypePopulation[randomperson2].getSex()=='M')
                            break;
                        continue;

                    }
                    long rankvalue = generator.generatePhenotype(genotypePopulation[randomperson1], genotypePopulation[randomperson2]);
                    if (generator.isFit(rankvalue)) {
                        String child = genotypePopulation[randomperson1].getPersonID() + genotypePopulation[randomperson2].getPersonID();
                        System.out.println(child);
                        return;
                    } else {
                        Person person = new Person();
                        person.setPersonID(genotypePopulation[randomperson1].getPersonID() + genotypePopulation[randomperson2].getPersonID());
                        person.setGeneration(2);
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
                        temp[j++] = person;

                    }
                }
            }
        }
        genotypePopulation = temp;
        for(Person p:genotypePopulation)
        {
            System.out.println(p);
        }
    }
}
