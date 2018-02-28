package neural;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author singhj1
 */
public class Neural {

    //private static double[] Input = new double[]{1.0, 1.0};
    public Neural(int FirstLayer, int SecondLayer, int ThirdLayer) {

        double[][] Input = new double[1][FirstLayer];

        double[] WEIGHTS = new double[(FirstLayer * SecondLayer) + (SecondLayer * ThirdLayer)];
        double[] BIASES = new double[(SecondLayer + ThirdLayer)];
        double[] ActivationResult = new double[SecondLayer];
        double HiddenNeuronValueTemp = 0;
        double OUTPUT = new Double(ThirdLayer);

        List<String> ActivationHiddenNeuronValue = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < Input.length; i++) {

            for (int j = 0; j < FirstLayer; j++) {

                Input[i][j] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue();

            }
        }

        for (int i = 0; i < WEIGHTS.length; i++) {

            WEIGHTS[i] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue();

        }

        for (int i = 0; i < BIASES.length; i++) {

            BIASES[i] = BigDecimal.valueOf(random.nextFloat()).setScale(1, RoundingMode.HALF_UP).doubleValue();

        }
        int temp = 1;
        for (int i = 0; i < SecondLayer; i++) {

            for (int j = 0; j < FirstLayer; j++) {

                HiddenNeuronValueTemp += (Input[0][j] * WEIGHTS[temp + j]); // operate each input with Second Layer

            }
            temp += FirstLayer;

            HiddenNeuronValueTemp += BIASES[i];
            
            System.out.println(HiddenNeuronValueTemp);
            System.out.println(Sigmoid(BigDecimal.valueOf(HiddenNeuronValueTemp).setScale(1, RoundingMode.HALF_UP).doubleValue()));

           // ActivationHiddenNeuronValue.add(String.valueOf(Sigmoid(HiddenNeuronValueTemp)));
            
            HiddenNeuronValueTemp = 0;
            
        }
        //System.out.println(HiddenNeuronValue);

        for (int i = SecondLayer; i < BIASES.length; i++) {

            for (int j = 0; j < SecondLayer; j++) {

                //   OUTPUT[i] += (ActivationResult[j] * WEIGHTS[j + (FirstLayer * SecondLayer)]);
            }

        }
        //System.out.println(Sigmoid(195.32000000000033));
    }

    public static double Sigmoid(double z) {

       // return BigDecimal.valueOf(1.0 / (1.0 + Math.exp(-z))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return (1.0 / (1.0 + Math.exp(-z)));

    }

    public static void main(String[] args) {

        Neural neural = new Neural(784, 30, 10);

    }

    public static void SGD(String Training_Data, int Epochs, int Mini_Batch_Size, String ETA, String Test_Data) {
        int n_Test;

        if (Test_Data.isEmpty()) {
            n_Test = Test_Data.length();
        }
    }
    
}
