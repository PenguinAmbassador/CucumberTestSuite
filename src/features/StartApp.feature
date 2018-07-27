Feature: Start App
This feature verifies the functionality of Appium and automation of starting and updating the Frigidaire app

Scenario: Start and update the app
Given Appium server is running
And Phone or emulator are ready
Then This code opens the app
And this code updates the app

Scenario: Sign In Button
Given App is updated
And Welcome page is open
Then Sign in button is pressed

Scenario: Type Username and Password
Given The login page is open
Then Email text box is clicked
And Email is typed
And Password text box is clicked
And Password is typed
And Sign in button is pressed again

Scenario: feature Dehumidifier Humidity Control - function UP
Given Dehumidifier control screen is open
When Plus button is pressed
Then If the humidity is not 85 or CONT it will increase by 5%
But If the humidity is 85% it will become CONT
And If the humidity is CONT it will become 35%