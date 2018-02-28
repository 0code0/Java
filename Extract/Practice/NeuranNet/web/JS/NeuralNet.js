
var InputOne;
var InputTwo;
var Target;
var Error;
var DeltaOutputSum;
var DeltaWeight = [];
var DeltaWeight2 = [];
var HiddenToOutputNewWeight = [];
var DeltaOutSums = [];



function OutputValueTwo(value) {

    Target = value;

}

function ActivationFunction(xValue) {

    return  1 / (1 + Math.exp(-xValue));

}

function DerivativeActivationfunction(xValue) {

    return Math.exp(-xValue) / Math.pow(1 + Math.exp(-xValue), 2);
}



function InputValueOne(val) {
    InputOne = val;
    document.getElementById("InputOnePushValue").innerHTML = val;

}

function InputValueTwo(val) {
    InputTwo = val;
    document.getElementById("InputTwoPushValue").innerHTML = val;
}

function calculateMatrix() {
    var randomNumber = [];
    var randomNumber2 = [];
    
    var HelprandomNumber = [];
    var HelprandomNumber2 = [];
    
    var neuronThreeValue;
    var neuronFourValue;
    var neuronFiveValue;

    var neuronSixValue;
    var ExpNeuronSixValue;

    var ExpNeuronThreeValue;
    var ExpNeuronFourValue;
    var ExpNeuronFiveValue;



    for (var i = 0; i < 6; i++) {

        randomNumber.push(Math.random().toFixed(2));

    }

 //   while (Target !== Error) {
        
        neuronThreeValue = InputOne * randomNumber[0] + InputTwo * randomNumber[3];
        neuronFourValue = InputOne * randomNumber[1] + InputTwo * randomNumber[4];
        neuronFiveValue = InputOne * randomNumber[2] + InputTwo * randomNumber[5];

        var NeuronHiddenValue = [neuronThreeValue, neuronFourValue, neuronFiveValue];

        ExpNeuronThreeValue = ActivationFunction(neuronThreeValue);
        ExpNeuronFourValue = ActivationFunction(neuronFourValue);
        ExpNeuronFiveValue = ActivationFunction(neuronFiveValue);


        document.getElementById("FirstNeuronWeightOne").innerHTML = randomNumber[0];
        document.getElementById("FirstNeuronWeightTwo").innerHTML = randomNumber[1];
        document.getElementById("FirstNeuronWeightThree").innerHTML = randomNumber[2];

        document.getElementById("SecondNeuronWeightOne").innerHTML = randomNumber[3];
        document.getElementById("SecondNeuronWeightTwo").innerHTML = randomNumber[4];
        document.getElementById("SecondNeuronWeightThree").innerHTML = randomNumber[5];


        document.getElementById("ExpThirdNeuron").innerHTML = ExpNeuronThreeValue.toFixed(2);
        document.getElementById("ExpFourthNeuron").innerHTML = ExpNeuronFourValue.toFixed(2);
        document.getElementById("ExpFifthNeuron").innerHTML = ExpNeuronFiveValue.toFixed(2);


        for (var a = 0; a < 3; a++) {

            randomNumber2.push(Math.random().toFixed(2));
        }

        neuronSixValue = ExpNeuronThreeValue * randomNumber2[0] + ExpNeuronFourValue * randomNumber2[1] + ExpNeuronFiveValue * randomNumber2[2];

        ExpNeuronSixValue = 1 / (1 + Math.exp(-neuronSixValue));

        document.getElementById("ThirdNeuronWeight").innerHTML = randomNumber2[0];
        document.getElementById("FourthNeuronWeight").innerHTML = randomNumber2[1];
        document.getElementById("FifthNeuronWeight").innerHTML = randomNumber2[2];

        document.getElementById("SixthNeuronWeight").innerHTML = ExpNeuronSixValue.toFixed(2);


        Error = Target - ExpNeuronSixValue.toFixed(2);




        DeltaOutputSum = (DerivativeActivationfunction(neuronSixValue) * Error);

        for (var i = 0; i < randomNumber2.length; i++) {

            DeltaWeight[i] = DeltaOutputSum / randomNumber2[i];

        }

        
        for (var j = 0; j < DeltaWeight.length; j++) {

            HiddenToOutputNewWeight[j] = (DeltaWeight[j] * randomNumber2[j]); // new hidden to output weight
            
            alert("Delta=>" + DeltaWeight[j] +"   "+ "Random ->" + randomNumber2[j]);
            
            alert(HiddenToOutputNewWeight);
    }


       
        for (k = 0; k < randomNumber2.length; k++) {

            DeltaOutSums[k] = DeltaOutputSum / randomNumber2[k] * DerivativeActivationfunction(NeuronHiddenValue[k]);
        }

        var OldWeightValue1 = [];
        var OldWeightValue2 = [];
        var OldWeightValue = [];
        
        for (var i = 0; i < DeltaOutSums.length; i++) {

            OldWeightValue1[i] = DeltaOutSums[i] / InputOne;

        }
        
         
        
        for (var i = 0; i < DeltaOutSums.length; i++) {

            OldWeightValue2[i] = DeltaOutSums[i] / InputTwo;

        }

        OldWeightValue = OldWeightValue1.concat(OldWeightValue2);

 
        for (var i = 0; i < randomNumber.length; i++) {
    
            HelprandomNumber[i] = randomNumber[i] + (OldWeightValue[i]);
    
        }
        
        for(var i=0; i< HiddenToOutputNewWeight.length; i++) {
            
            randomNumber2[i] = HiddenToOutputNewWeight[i];
            
        }
        
     //   alert(randomNumber2);
        
      
    //}


}
    