package main.com.davidlopez.simpleperceptron.utilities;

import java.util.Random;

public class Utility {
    private int value = 1;
    private double height;

    public Utility(){
        Random rand = new Random();
        height = rand.nextDouble() - rand.nextDouble();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double error) {
        height = height + 0.3 * error * value;
    }
}
