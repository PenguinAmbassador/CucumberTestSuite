Feature: RAC Fan Speed
Verify fan speed

Scenario: Tap right for High
Given App is updatedB
And RAC Control Panel is open
When Right Fan Speed button is pressed
Then Eventually RAC will be set to high 
And this works now