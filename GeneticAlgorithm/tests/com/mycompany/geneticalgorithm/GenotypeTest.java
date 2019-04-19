package com.mycompany.geneticalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class GenotypeTest {

    /**
     * superGeneGeneratorTest
     * This function tests the crossover functionality
     * Since we are setting the rank of individual to 0 no perfect human is found across different generations
     */

    @Test
    public void superGeneGeneratorTest() {
        List<Person> genotypePopulation = new ArrayList<Person>();
        Genotype genotype = new Genotype();


        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(r.nextBoolean());
            p.setRank(0);
            p.setGeneration(1);

            genotypePopulation.add(p);
        }

        Genotype g = new Genotype();


        ArrayList<Person> temp = new ArrayList<Person>();
        CompletableFuture<List<Person>> firstHalf = genotype.superGeneGenerator(genotypePopulation, 0, 5, 5);
        CompletableFuture<List<Person>> secondHalf = genotype.superGeneGenerator(genotypePopulation, 5, 10, 5);
        CompletableFuture<List<Person>> parsort = firstHalf.thenCombine(secondHalf, (s1, s2) -> {

            List<Person> p = new ArrayList<>();
            for (Person pe : s1) {
                temp.add(pe);
                assertFalse(pe.getRank()>0);
                p.add(pe);
            }
            for (Person pe : s2) {
                temp.add(pe);
                assertFalse(pe.getRank()>0);
                p.add(pe);
            }

            return p;
        });



        }

    /**
     * superGeneGeneratorTestFertile
     * This function tests the crossover functionality based on Fertility property
     * Since we are setting the fertile property of individual to false no mutations happens i.e further generations are not reproduced
     */
    @Test
    public void superGeneGeneratorTestFertile() {
        List<Person> genotypePopulation = new ArrayList<Person>();
        Genotype genotype = new Genotype();


        String str = "MF";
        char[] genderArray = str.toCharArray();
        int len = genderArray.length;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            char sex = genderArray[r.nextInt(len)];
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(false);
            p.setRank((r.nextInt(800) / 3) + 1);
            p.setGeneration(1);

            genotypePopulation.add(p);
        }

        Genotype g = new Genotype();


        ArrayList<Person> temp = new ArrayList<Person>();
        CompletableFuture<List<Person>> firstHalf = genotype.superGeneGenerator(genotypePopulation, 0, 5, 5);
        CompletableFuture<List<Person>> secondHalf = genotype.superGeneGenerator(genotypePopulation, 5, 10, 5);
        CompletableFuture<List<Person>> parsort = firstHalf.thenCombine(secondHalf, (s1, s2) -> {

            List<Person> p = new ArrayList<>();

            assertFalse(s1.size()>0);
            assertFalse(s2.size()>0);
            return p;
        });



    }

    /**
     * superGeneGeneratorCheckSex
     * This function tests the crossover functionality based on sex
     * Since we are mating with people of same sex no reproduction happens and no further generations are generated
     */

    @Test
    public void superGeneGeneratorCheckSex() {
        List<Person> genotypePopulation = new ArrayList<Person>();
        Genotype genotype = new Genotype();



        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            char sex = 'M';
            p.setPersonID("P" + i + sex);
            p.setSex(sex);
            p.setFertile(true);
            p.setRank((r.nextInt(800) / 3) + 1);
            p.setGeneration(1);

            genotypePopulation.add(p);
        }

        Genotype g = new Genotype();


        ArrayList<Person> temp = new ArrayList<Person>();
        CompletableFuture<List<Person>> firstHalf = genotype.superGeneGenerator(genotypePopulation, 0, 5, 5);
        CompletableFuture<List<Person>> secondHalf = genotype.superGeneGenerator(genotypePopulation, 5, 10, 5);
        CompletableFuture<List<Person>> parsort = firstHalf.thenCombine(secondHalf, (s1, s2) -> {

            List<Person> p = new ArrayList<>();

            assertFalse(s1.size()>0);
            assertFalse(s2.size()>0);
            return p;
        });



    }

}

