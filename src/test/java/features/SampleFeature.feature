Feature: MassMutuals Excersize

Scenario: verify values from Excersize1 page
Given user is on home page
Then verify right count of values appear on screen
Then verify the values on the screen are greater than zero
Then verify the total balance is correct based on the values listed on the screen
Then verify the values are formatted as currency values
#Then verify the total balance matches sum of the values  #THIS LOOKS THE SAME AS ROW 7 .HOPEFULLY I DID NOT MISUNDERSTAND


