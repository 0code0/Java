<%-- 
    Document   : index
    Created on : Jan 9, 2017, 12:29:51 PM
    Author     : singhj1    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/Neural.css" rel="stylesheet" type="text/css"/>
        <script src="JS/NeuralNet.js" type="text/javascript"></script>
    </head>
    <body>

        <div id="Container">

            <div style="height: 100px;"></div>
            <div id="arrowOne">
                <img src="arrow.png" />
            </div>

            <div class="FirstNeuronOutput" id="FirstNeuronOutputArrowOne">
                <span class="Weight" id="FirstNeuronWeightOne">

                </span>
                <img src="arrow.png"  width="130"  />
            </div>
            <div class="FirstNeuronOutput" id="FirstNeuronOutputArrowTwo">
                <span class="Weight" id="FirstNeuronWeightTwo">

                </span>
                <img src="arrow.png" width="230" />
            </div>
            <div class="FirstNeuronOutput" id="FirstNeuronOutputArrowThree">
                <span class="Weight" id="FirstNeuronWeightThree">

                </span>
                <img src="arrow.png" width="130" />
            </div>

            <div id="InputOne">
                <select onchange="InputValueOne(this.value)">
                    <option value=""> Sel </option>
                    <option value="0.0"> 0 </option>
                    <option value="1.0"> 1 </option>
                </select>
            </div>
            <div class="circle">
                <span id="InputOnePushValue">

                </span>
            </div>

            <div style="height: 100px;"></div>

            <div class="circle">
                <span id="InputTwoPushValue">

                </span>
            </div>
            <div id="InputTwo">
                <select onchange="InputValueTwo(this.value)">
                    <option value=""> Sel </option>
                    <option value="0.0"> 0 </option>
                    <option value="1.0"> 1 </option>
                </select>
            </div>
            <div Id="arrowTwo">
                <img src="arrow.png" />
            </div>

            <div class="SecondNeuronOutput" id="SecondNeuronOutputArrowOne">
                <span class="Weight" id="SecondNeuronWeightOne">

                </span>
                <img src="arrow.png"  width="150"  />
            </div>
            <div class="SecondNeuronOutput" id="SecondNeuronOutputArrowTwo">
                <span class="Weight" id="SecondNeuronWeightTwo"> 

                </span>
                <img src="arrow.png" width="230" />
            </div>
            <div class="SecondNeuronOutput" id="SecondNeuronOutputArrowThree">
                <span class="Weight" id="SecondNeuronWeightThree">

                </span>
                <img src="arrow.png" width="140" />
            </div>

            <div class="circle" id="ThirdNeuron">
                <span id="ExpThirdNeuron">

                </span>
            </div> 
            <div class="HiddenLayer" id="ThirdNeuronOutputArrow">
                <span class="Weight" id="ThirdNeuronWeight">

                </span>
                <img src="arrow.png" width="170" />
            </div>
            <div class="circle" id="FourthNeuron">
                <span id="ExpFourthNeuron">

                </span>
            </div>
            <div class="HiddenLayer" id="FourthNeuronOutputArrow">
                <span class="Weight" id="FourthNeuronWeight"  >

                </span>
                <img src="arrow.png" width="120" />
            </div>
            <div class="circle" id="FifthNeuron">
                <span id="ExpFifthNeuron">

                </span>
            </div>

            <div class="HiddenLayer" id="FifthNeuronOutputArrow">
                <span class="Weight" id="FifthNeuronWeight">

                </span>
                <img src="arrow.png" width="180" />
            </div>
            <div class="circle" id="SixthNeuron">
                <span>

                </span>
            </div>
            <div id="SixthNeuronOutputArrow">
                <span class="Weight" id="SixthNeuronWeight">

                </span>
                <img src="arrow.png" />
            </div>
            <div id="OutPut">
                <select onchange="OutputValueTwo(this.value)">
                    <option value=""> Sel </option>
                    <option value="0.0"> 0 </option>
                    <option value="1.0"> 1 </option>
                </select>
            </div>
        </div>

        <div id="button">
            <button type="button" onclick="calculateMatrix()" >Iteration</button>
        </div>
    </body>

</html>
