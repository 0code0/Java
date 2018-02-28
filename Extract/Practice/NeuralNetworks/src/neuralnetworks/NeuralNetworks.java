

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetworks;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * @author singhj1
 */
public class NeuralNetworks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        
        PrintWriter printWriter = new PrintWriter("NeuralNetWeights.txt");
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        double[][] InputValues = new double[][]{
            {0.4, -0.7},
            {0.3, -0.5},
            {0.6, 0.1},
            {0.2, 0.4},
            {0.1, -0.2}};
        double[] Target = new double[]{0.1, 0.05, 0.3, 0.25, 0.12};
        double[][] Weights = new double[][]{
            {0.1, 0.4},
            {-0.2, 0.2}};
        double[][] Veights = new double[][]{{0.2, -0.5}};
        double[] HiddenActivationMatrix = new double[Weights[0].length];
        double[] Output = new double[1];
        double[] Y = new double[2];
        double[] e = new double[2];
        double[] dStar = new double[2];
        double[][] X = new double[2][2];
        double[][] DeltaWeight = new double[2][2];
        double[] DeltaVeight = new double[2];
        double n = 0.6;
        for (int t = 0; t < 5; t++) {

            while (Output[0] != Target[t]) {

                for (int i = 0; i < 1; i++) {

                    for (int j = 0; j < InputValues[0].length; j++) {

                        for (int k = 0; k < Weights[0].length; k++) {

                            HiddenActivationMatrix[j] = HiddenActivationMatrix[j] + (InputValues[i][k] * Weights[k][j]);
                        }
                    }

                }
                // Sigmoid function on hidden Neuron
                for (int j = 0; j < HiddenActivationMatrix.length; j++) {
                    HiddenActivationMatrix[j] = Sigmoid(HiddenActivationMatrix[j]);
                }

                for (int i = 0; i < 1; i++) {

                    for (int j = 0; j < HiddenActivationMatrix.length; j++) {

                        for (int k = 0; k < Veights.length; k++) {

                            Output[i] = Output[i] + (HiddenActivationMatrix[j] * Veights[k][j]);

                        }
                    }

                }

                Output[0] = Double.parseDouble(decimalFormat.format(Sigmoid(Output[0])));

                if (Output[0] != Target[t]) {
                    double Error = Math.pow(Target[t] - Output[0], 2);

                    double d = (Target[t] - Output[0]) * Output[0] * (1 - Output[0]);

                    for (int hidden = 0; hidden < HiddenActivationMatrix.length; hidden++) {

                        Y[hidden] = HiddenActivationMatrix[hidden] * d;

                    }

                    for (int hidden = 0; hidden < e.length; hidden++) {

                        e[hidden] = Veights[0][hidden] * d;

                    }

                    for (int hidden = 0; hidden < dStar.length; hidden++) {

                        dStar[hidden] = e[hidden] * HiddenActivationMatrix[hidden] * (1 - HiddenActivationMatrix[hidden]);

                    }

                    for (int j = 0; j < InputValues[0].length; j++) {

                        for (int k = 0; k < dStar.length; k++) {

                            X[j][k] = InputValues[0][j] * dStar[k];
                        }
                    }

                    for (int j = 0; j < X[0].length; j++) {

                        for (int k = 0; k < X.length; k++) {

                            DeltaWeight[j][k] = n * X[j][k];
                        }
                    }

                    // Weight Updates
                    for (int j = 0; j < X[0].length; j++) {

                        for (int k = 0; k < X.length; k++) {

                            Weights[j][k] = Weights[j][k] + DeltaWeight[j][k];
                        }
                    }

                    // Veigths Updates
                    for (int j = 0; j < DeltaVeight.length; j++) {

                        DeltaVeight[j] = n * Y[j];
                    }

                    for (int k = 0; k < X.length; k++) {

                        Veights[0][k] = Veights[0][k] + DeltaVeight[k];
                    }

                } else {
                    break;
                }

            }
            
            //printWriter.append(String.valueOf(InputValues[t][0]+","+InputValues[t][1]+","+Weights[0][0]+","+Weights[0][1]+","+Weights[1][0]+","+Weights[1][1]+","+Veights[0][0]+","+Veights[0][1]));
            System.out.println(InputValues[t][0]+","+InputValues[t][1]+","+Weights[0][0]+","+Weights[0][1]+","+Weights[1][0]+","+Weights[1][1]+","+Veights[0][0]+","+Veights[0][1]);
           
        }
        
        printWriter.close();
    }

    
    public static double Sigmoid(double z) {

        return (1.0 / (1.0 + Math.exp(-z)));

    }

}


