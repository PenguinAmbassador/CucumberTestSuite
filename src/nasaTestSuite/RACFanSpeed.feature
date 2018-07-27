Feature: RAC Fan Speed
Verify fan speed

Background: Start and update the app
Given Appium server is running
And Phone or emulator are ready
Then This code opens the app
And this code updates the app

Scenario: Tap right for High
Given App is updatedB
And RAC Control Panel is open
When Right Fan Speed button is pressed
Then Eventually RAC will be set to high 
And this works now