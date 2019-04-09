package com.mycompany.geneticalgorithm;

import java.util.Random;

public class Genotype {

    private static Random r = new Random();


     Person[] genotypePopulation = new Person[2000];


    public static void main(String[] args) {
        Genotype genotype= new Genotype();
        Generator generator = new Generator();
        Person[] temp = new Person[2000];
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
            genotype.genotypePopulation[i] = p;
        }
        int totalvisits = (int) (0.5 * genotype.genotypePopulation.length * Math.log(genotype.genotypePopulation.length));
        int k = 2;
       // int currGen = 1;

        while(k<10) {
            for (int i = 0; i < totalvisits; i++) {
                if (j >= 2000) break;
                int randomperson1 = r.nextInt((genotype.genotypePopulation.length));
                if (!genotype.genotypePopulation[randomperson1].getFertile()) {
                    continue;
                } else {
                    int randomperson2 = r.nextInt(genotype.genotypePopulation.length);
                    if (genotype.genotypePopulation[randomperson1].getSex() == 'M') {
                        while ((genotype.genotypePopulation[randomperson2].getSex() != 'F') || !(genotype.genotypePopulation[randomperson2].getFertile())) {

                            randomperson2 = r.nextInt(genotype.genotypePopulation.length);
                            if (genotype.genotypePopulation[randomperson2].getFertile() && genotype.genotypePopulation[randomperson2].getSex() == 'F')
                                break;
                            continue;

                        }
                        long rankvalue = generator.generatePhenotype(genotype.genotypePopulation[randomperson1], genotype.genotypePopulation[randomperson2]);
                        if (generator.isFit(rankvalue)) {
                            String child = genotype.genotypePopulation[randomperson1].getPersonID() + genotype.genotypePopulation[randomperson2].getPersonID();
                            System.out.println(child);
                            return;
                        } else {
                            Person person = new Person();
                            person.setPersonID(genotype.genotypePopulation[randomperson1].getPersonID() + genotype.genotypePopulation[randomperson2].getPersonID());
                            person.setGeneration(k);
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
                    } else if (genotype.genotypePopulation[randomperson1].getSex() == 'F') {
                        while ((genotype.genotypePopulation[randomperson2].getSex() != 'M') || !(genotype.genotypePopulation[randomperson2].getFertile())) {
                            randomperson2 = r.nextInt(genotype.genotypePopulation.length);
                            if (genotype.genotypePopulation[randomperson2].getFertile() && genotype.genotypePopulation[randomperson2].getSex() == 'M')
                                break;
                            continue;

                        }
                        long rankvalue = generator.generatePhenotype(genotype.genotypePopulation[randomperson1], genotype.genotypePopulation[randomperson2]);
                        if (generator.isFit(rankvalue)) {
                            String child = genotype.genotypePopulation[randomperson1].getPersonID() + genotype.genotypePopulation[randomperson2].getPersonID();
                            System.out.println(child);
                            return;
                        } else {
                            Person person = new Person();
                            person.setPersonID(genotype.genotypePopulation[randomperson1].getPersonID() + genotype.genotypePopulation[randomperson2].getPersonID());
                            person.setGeneration(k);
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
            k++;
            genotype.genotypePopulation = temp;
            for(Person p:genotype.genotypePopulation)
            {
                System.out.println(p);
            }
        }


    }
}
