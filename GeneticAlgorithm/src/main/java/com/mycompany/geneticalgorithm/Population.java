package com.mycompany.geneticalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Below is the population class
 */
public class Population {

    Map<String, Long> population;

    private Population() {
        if (this.population == null) {
            population = new HashMap<>();
        }

    }

    public Map<String, Long> getPopulation() {
        return population;
    }

    public void setPopulation(Map<String, Long> population) {
        this.population = population;
    }
}
