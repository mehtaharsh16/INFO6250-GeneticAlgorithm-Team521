package com.mycompany.geneticalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Below is the implementation of Genotype class
 */
public class Genotype {

    static int sampleLength = 10;
    private static Random r = new Random();
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    Generator generator = new Generator();

    private static ForkJoinPool forkJoinPool = new ForkJoinPool(2);

    /**
     * Below is the driver code for running the application
     * @param args
     */
    public static void main(String[] args) {
        List<Person> genotypePopulation = new ArrayList<Person>();
        Genotype genotype = new Genotype();


        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        for (int i = 0; i < sampleLength; i++) {
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(r.nextBoolean());
            p.setRank((r.nextInt(800) / 3) + 1);
            p.setGeneration(1);

            genotypePopulation.add(p);
        }
        long startTime = System.nanoTime();
        int totalvisits = (int) (0.5 * genotypePopulation.size() * Math.log(genotypePopulation.size()));

        for (int k = 2; k <= 10; k++) {
            ArrayList<Person> temp = new ArrayList<Person>();
            int start = 0;
            int end = totalvisits;


            CompletableFuture<List<Person>> firstHalf = genotype.superGeneGenerator(genotypePopulation, start, start + (end - start) / 2, k);
            CompletableFuture<List<Person>> secondHalf = genotype.superGeneGenerator(genotypePopulation, start + (end - start) / 2, end, k);
            CompletableFuture<List<Person>> parsort = firstHalf.thenCombine(secondHalf, (s1, s2) -> {

                List<Person> p = new ArrayList<>();
                for (Person pe : s1) {
                    temp.add(pe);
                    p.add(pe);
                }
                for (Person pe : s2) {
                    temp.add(pe);
                    p.add(pe);
                }
                return p;
            });

            genotypePopulation = new ArrayList<>(temp);
            for (Person p : genotypePopulation) {
                if (p != null)
                    System.out.println(p);
            }
            temp.clear();

        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for find the super human genome is " + (endTime - startTime));
    }

    /**
     *
     * CompletableFuture implementation for parallel processing
     * @param genotypePopulation
     * @param start
     * @param end
     * @param k
     * @return
     */

    public CompletableFuture<List<Person>> superGeneGenerator(List<Person> genotypePopulation, int start, int end, int k) {
        return CompletableFuture.supplyAsync(
                () -> {
                    List<Person> temp = new ArrayList<Person>();
                    int j = 0;
                    for (int i = start; i < end; i++) {
                        if (j >= sampleLength) break;

                        int randomperson1 = r.nextInt((genotypePopulation.size()));


                        if (!genotypePopulation.get(randomperson1).getFertile()) {
                            continue;
                        } else {
                            int randomperson2 = r.nextInt(genotypePopulation.size());

                            if (genotypePopulation.get(randomperson1).getSex() == 'M') {
                                while ((genotypePopulation.get(randomperson2).getSex() != 'F') || !(genotypePopulation.get(randomperson2).getFertile())) {

                                    randomperson2 = r.nextInt(genotypePopulation.size());
                                    if (genotypePopulation.get(randomperson2).getFertile() && genotypePopulation.get(randomperson2).getSex() == 'F')
                                        break;
                                    continue;

                                }
                                double rankvalue = generator.generatePhenotype(genotypePopulation.get(randomperson1), genotypePopulation.get(randomperson2));
                                if (generator.isFit(rankvalue)) {
                                    String child = genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID();
                                    System.out.println(child);
                                    break;
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
                                    j += 1;
                                }
                            } else if (genotypePopulation.get(randomperson1).getSex() == 'F') {
                                while ((genotypePopulation.get(randomperson2).getSex() != 'M') || !(genotypePopulation.get(randomperson2).getFertile())) {
                                    randomperson2 = r.nextInt(genotypePopulation.size());
                                    if (genotypePopulation.get(randomperson2).getFertile() && genotypePopulation.get(randomperson2).getSex() == 'M')
                                        break;
                                    continue;

                                }
                                double rankvalue = generator.generatePhenotype(genotypePopulation.get(randomperson1), genotypePopulation.get(randomperson2));
                                if (generator.isFit(rankvalue)) {
                                    String child = genotypePopulation.get(randomperson1).getPersonID() + genotypePopulation.get(randomperson2).getPersonID();
                                    System.out.println(child);
                                    break;
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
                                    j += 1;
                                }
                            }
                        }
                    }
                    return temp;
                }, forkJoinPool);

    }
}
