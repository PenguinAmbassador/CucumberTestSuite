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

