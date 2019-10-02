# SimplePerceptron-AND
This perceptron is able to learn the logical AND gate: 




![AND Gate](https://raw.githubusercontent.com/DavidLopezSaez/SimplePerceptron-AND/master/AND-Gate.png)

## How it works?
Inside the code we have an arrayList called `trainingValues`, it stores the input values and the output of the AND gate.
During the training phase, all the input values are introduced 1 by 1 in the perceptron using entries. The perceptron calculates the output and it is verified with the expected result stored in `trainingValues`. If the verification (is the obtained result equals to the expected result?)of one of the cases is wrong (obatined result isn´t equal to expected result) we have to call the perceptron to readjust it self and repeat all the cases again till all of them are verified. The number of times that process is repeated is what we call `Iterations`. When all the cases are verified we can say that the perceptron has learned the AND gate.

Let´s talk a little more about the perceptron it self. The perceptron has 2 entries. Each one has a value and height. Heights are generated randomly for the first time and if the perceptron needs to change the height (because we didn´t verified one case) it will calculate a new height based on the difference between the expected result and the obtained result. This is the formula used to calculate new heights: `height = height + 0.3 * error * value`
- 0.3: learning rate
- error: expected result - obtained result
- value: entry value

The perceptron uses entries, its heights and its own threshold to calculate the output. Thresholds will always have a value of 1 and it will also has a designated height with the same rules of the entries heights. To calculate the output the perceptron use this formula:
`entry1_value * entry1_height + entry2_value * entry2_height + threshold_value * threshold_height`

An activation formula is required to understand the perceptron output. It will return values between the expected results (1 or 0) and the algorithm will use the returned value to verify if it is good or not.
This time we are using a simple conditional as the activation formula. It looks like this:
`if(x > 0){return 1;}else{return 0;}`. Take x as the output of the previous formula. If you want to make a neuronal network this method will not be as useful as in this case so you will need to use other methods like, for example, take a look into [hyperbolic tangents](https://en.wikipedia.org/wiki/Hyperbolic_function#Hyperbolic_tangent).
