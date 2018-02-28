/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeyourownneuralnet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

/**
 *
 * @author singhj1
 */
public class MakeYourOwnNeuralNet {

    Random random = new Random();

    public MakeYourOwnNeuralNet(List<Integer> InputLayer, int HiddenLayer, int OutputLayer) {

        MatrixMul(HiddenLayer, InputLayer, OutputLayer);

    }

    private void MatrixMul(int HiddenLayerCount, List<Integer> InputLayerCount, int OutputLayerCount) {

        double[][] Weight = new double[HiddenLayerCount][InputLayerCount.size()];
        double[][] WeightHiddenToOutput = new double[OutputLayerCount][HiddenLayerCount];
        double[] Input = new double[InputLayerCount.size()];
        double[] Output = new double[OutputLayerCount];
        double[] TempStoreResult = new double[HiddenLayerCount];
        double[] TempStoreResultHTO = new double[OutputLayerCount];

        // Start Input to Hidden Layer
        for (int i = 0; i < HiddenLayerCount; i++) {

            for (int j = 0; j < InputLayerCount.size(); j++) {

                Weight[i][j] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue(); // Random Weights Assign
                // System.out.print(Weight[i][j] + " ");
            }
            // System.out.println(" ");

        }

        //   System.out.println(" ");
//        for (int i = 0; i < InputLayerCount.size(); i++) {
//
//            Input[i] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue(); //  random Input Value
//            //System.out.println(Input[i]);
//        }
        //  System.out.println("");

        // Matrix Multipication
        for (int i = 0; i < HiddenLayerCount; i++) {

            for (int j = 0; j < InputLayerCount.size(); j++) {

                TempStoreResult[i] += (Weight[i][j] * InputLayerCount.get(j));
            }

        }

        // Activation Function
        for (int i = 0; i < TempStoreResult.length; i++) {

            TempStoreResult[i] = Sigmoid(TempStoreResult[i]);

        }

        // End Input to Hidden Layer
        //Start hidden to output Layer
        for (int i = 0; i < OutputLayerCount; i++) {

            for (int j = 0; j < HiddenLayerCount; j++) {

                WeightHiddenToOutput[i][j] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue(); // Random Weights Assign Hidden to output layer
                // System.out.print(Weight[i][j] + " ");
            }
            // System.out.println(" ");

        }

        for (int i = 0; i < OutputLayerCount; i++) {

            for (int j = 0; j < HiddenLayerCount; j++) {

                TempStoreResultHTO[i] += (WeightHiddenToOutput[i][j] * TempStoreResult[j]);
            }
        }

        for (int i = 0; i < TempStoreResultHTO.length; i++) {

            TempStoreResultHTO[i] = Sigmoid(TempStoreResultHTO[i]);

            System.out.println(TempStoreResultHTO[i]);
        }

    }

    public static double Sigmoid(double z) {

        // return BigDecimal.valueOf(1.0 / (1.0 + Math.exp(-z))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return (1.0 / (1.0 + Math.exp(-z)));

    }

    public static void main(String[] args) {
        // TODO code application logic here

        MakeYourOwnNeuralNet makeYourOwnNeuralNet = new MakeYourOwnNeuralNet(ImageData.ImageData.ImageProcess("File.jpg"), 30, 10);
    }

}
