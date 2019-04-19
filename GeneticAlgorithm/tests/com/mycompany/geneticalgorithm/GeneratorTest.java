package com.mycompany.geneticalgorithm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GeneratorTest {

    /**
     * checkSex() method is used to check sex of individual
     */
    @Test
    public void checkSex() {
        Person p = new Person();
        p.setPersonID("P1M");
        p.setSex('M');
        p.setFertile(true);
        p.setRank(45);
        p.setGeneration(1);
        assertEquals(p.getSex(),'M');
    }

    /**
     * checkFertilty() method is used to check fertility of individual
     */
    @Test
    public void checkFertilty() {
        Person p = new Person();
        p.setPersonID("P1M");
        p.setSex('M');
        p.setFertile(true);
        p.setRank(45);
        p.setGeneration(1);
        assertEquals(p.getFertile(),true);
    }


    /**
     * generatePhenotype() method is used to check the generation of Phenotype
     */
    @Test
    public void generatePhenotype() {
        Person p = new Person();
        p.setPersonID("P1M");
        p.setSex('M');
        p.setFertile(true);
        p.setRank(45);
        p.setGeneration(1);
        assertEquals(p.getSex(),'M');

        Person p1 = new Person();
        p1.setPersonID("P7F");
        p1.setSex('F');
        p1.setFertile(true);
        p1.setRank(70);
        p1.setGeneration(1);
        assertEquals(p1.getFertile(),true);


        double rankValue;
        double male = (p.getPersonID().length()) * 0.33;
        double female = (p1.getPersonID().length()) * 1.35;
        rankValue = (Math.log(1.5) * (p.getRank() * female + p1.getRank() * male) * 0.2);

        assertTrue(rankValue == 20.398949588921752);
    }

    /**
     * isFit() method is used to test fitness of individual
     */
    @Test
    public void isFit() {
        final double fitValue = 200;

        Person p1 = new Person();
        p1.setPersonID("P7F");
        p1.setSex('F');
        p1.setFertile(true);
        p1.setRank(70);
        p1.setGeneration(1);
        assertEquals(p1.getFertile(),true);


        assertTrue(p1.getRank() != fitValue);
    }

    /**
     * chekSuperGene() method is used to test chekSuperGene generation
     */
    @Test
    public void chekSuperGene() {
        final double fitValue = 100;

        Person p = new Person();
        p.setPersonID("P3F");
        p.setSex('F');
        p.setFertile(true);
        p.setRank(50);
        p.setGeneration(1);
        assertEquals(p.getSex(),'F');

        Person p1 = new Person();
        p1.setPersonID("P21M");
        p1.setSex('M');
        p1.setFertile(true);
        p1.setRank(100);
        p1.setGeneration(1);
        assertEquals(p1.getFertile(),true);


        double rankValue;
        double male = (p.getPersonID().length()) * 0.33;
        double female = (p1.getPersonID().length()) * 1.35;
        rankValue = (Math.log(1.5) * (p.getRank() * female + p1.getRank() * male) * 0.2);

        assertTrue(rankValue == 29.923324978382535);
        assertTrue(rankValue != fitValue);

    }
}