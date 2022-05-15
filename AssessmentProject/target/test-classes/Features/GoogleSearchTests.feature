Feature: Google search results feature testing 

Scenario: Search Spark network and verify it is present as first result 
	Given User Go to Google page 
	When user searches for Spark Networks 
	Then Spark networks homepage should be the first result
	
Scenario: Search funny car memems and take screenshot of result
	Given User Go to Google page
	When user searches for funny cat memes
	Then results should be displayed
	And screenshot should be taken 
