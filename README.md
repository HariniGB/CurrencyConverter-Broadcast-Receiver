# CurrencyConverter-Broadcast-Receiver

## Learning Objective

> Build two applications, first app is called *Currency Converter Request App*, used to request inout from users for currency conversion from USD to other currencies: British Pound, Euro and INR. Second app is called Currency Exchange Central App to do appropriate exchange rates and calculate the converted amount. 

**Step 1:** Create an App called *Currency Converter App* which has two input data: Dollar Amount and Convert To. Dollar amount is the amount of money in USD that need to be converted. Convert To allow user to pick one of the three currencies to exchange the dollar amount to. Design the UI with Edit Text for Dollar Amount input and Spinner for the Convert To input. The **CONVERT** button is used to get the input value from the user and send it to the backend function. The **CLOSE** button is used to close the App as shown in figure 1.1.

[![Figure 1.1](https://i.imgur.com/rMsQqPP.png)](https://i.imgur.com/rMsQqPP.png)

**Step 2:** Create another App called *Currency Conversion Exchange* as shown in figure 1.4. In this the user input values are shown on the screen as TextView. The **APPLY** button called the conversion method and calculates the converted currency value with the two input data. The method returns the converted currency value in Double datatype.                                            
        
[![Figure 1.1](https://i.imgur.com/GHxtHdH.png)](https://i.imgur.com/GHxtHdH.png)        
        
**Step 3:** Now when the user provides an integer amount value (for example: 1000), choose the desired currency to convert (for example: British Pound as shown in figure 1.3) and click the **CONVERT** button, then the input is saved in a parameter and put in an  intent and sent as a Broadcast message.                                                                       

[![Figure 1.1](https://i.imgur.com/cgtn76d.png)](https://i.imgur.com/cgtn76d.png)

**Step 4:** The broadcast message is sent to all the apps in the mobile phone in general. We have to specify in the receiver App’s Manifest file about the intent filter of the broadcast message from which application package must be received.  I specified the *Currency Converter App’s* package name inside the *Currency Converter App*. Create a Broadcast Receiver java class and get the Broadcasted message. The user can see the broadcast message on the screen as shown in the figure 1.4

[![Figure 1.1](https://i.imgur.com/FjmzLqm.png)](https://i.imgur.com/FjmzLqm.png)

**Step 5:** Similarly on click of the **APPLY** button, the calcualtion method is called with both dollar amount and conversion currency values as two parameters. I have sent the converted currency value from *Currency Conversion Exchange* (App 2) to the *Currency Converter App* (App 1) using Broadcast. The final amount is displayed at the bottom of the App 1.  

[![Figure 1.1](https://i.imgur.com/musMIPw.png)](https://i.imgur.com/musMIPw.png)


[![Figure 1.1](https://i.imgur.com/T3w9VXy.png)](https://i.imgur.com/T3w9VXy.png)

**Step 6:**  The **CLOSE** button is to close the android applicaiton. 

### Live Demo
[LINK](http://g.recordit.co/8bTvgGp8AC.gif)

### References
- https://developer.android.com/guide/components/broadcasts.html

- https://www.youtube.com/watch?v=lGwDARPSCkE

- https://www.youtube.com/watch?v=Iauww6F0y5o

- https://stackoverflow.com/questions/11770794
