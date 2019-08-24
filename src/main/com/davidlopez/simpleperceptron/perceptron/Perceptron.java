package main.com.davidlopez.simpleperceptron.perceptron;

import main.com.davidlopez.simpleperceptron.utilities.Entry;
import main.com.davidlopez.simpleperceptron.utilities.Threshold;

import java.util.ArrayList;

public class Perceptron {
    private ArrayList<ArrayList<Integer>> trainingValues = new ArrayList<ArrayList<Integer>>();
    private Entry entry1;
    private Entry entry2;
    private Threshold threshold;
    private int iterations;

    public Perceptron(){
        //used for perceptron training
        trainingValues.add(new ArrayList<Integer>());
        trainingValues.add(new ArrayList<Integer>());
        trainingValues.add(new ArrayList<Integer>());
        trainingValues.add(new ArrayList<Integer>());

        // 0 - 1 = 0
        trainingValues.get(0).add(0);
        trainingValues.get(0).add(1);
        trainingValues.get(0).add(0);
        // 1 - 0 = 0
        trainingValues.get(1).add(1);
        trainingValues.get(1).add(0);
        trainingValues.get(1).add(0);
        // 0 - 0 = 0
        trainingValues.get(2).add(0);
        trainingValues.get(2).add(0);
        trainingValues.get(2).add(0);
        // 1 - 1 = 1
        trainingValues.get(3).add(1);
        trainingValues.get(3).add(1);
        trainingValues.get(3).add(1);

        entry1 = new Entry();
        entry2 = new Entry();

        threshold = new Threshold();

        iterations = 0;

        this.learn();
    }

    public void learn(){
        int hits = 0;

        while(hits != 4) {
            for (ArrayList<Integer> trainingValue : trainingValues) {
                entry1.setValue(trainingValue.get(0));
                entry2.setValue(trainingValue.get(1));

                double outputFormula = formula(entry1.getValue(), entry2.getValue());
                double outputActivation = activation(outputFormula);

                if (outputActivation != trainingValue.get(2)) {
                    double error = trainingValue.get(2) - outputFormula;

                    entry1.setHeight(error);
                    entry2.setHeight(error);
                    threshold.setHeight(error);
                    hits = 0;
                    break;
                } else {
                    hits++;
                }
            }

            iterations++;
        }
    }

    public double formula(double value1, double value2){
        return (value1 * entry1.getHeight() + value2 * entry2.getHeight() + threshold.getValue() * threshold.getHeight());
    }

    public double activation(double x){
        //easy way, enaugh for a simple perceptron but usseles for more complex neuronal networks
        if(x > 0){
            return 1;
        }else{
            return 0;
        }
    }

    public int getIterations(){
        return iterations;
    }
}
