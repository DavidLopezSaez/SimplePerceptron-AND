import main.com.davidlopez.simpleperceptron.perceptron.Perceptron;

import java.util.Scanner;

public class Main {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();

        System.out.println("Learned in " + perceptron.getIterations() + " iterations!");
        System.out.println("*******************************");

        int value1;
        int value2;

        while(true){
            System.out.print("Enter first value: ");
            value1 = reader.nextInt();

            System.out.print("Enter second value: ");
            value2 = reader.nextInt();

            double output = perceptron.activation(perceptron.formula(value1, value2));

            if(output == 1){
                System.out.println("True");
                System.out.println("---------------------------");
            }else{
                System.out.println("False");
                System.out.println("---------------------------");
            }
        }
    }
}
