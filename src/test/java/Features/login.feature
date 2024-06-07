@Dinesh
Feature: Login Test

	Scenario: Login Test
		Given I am on the login page
	    When I enter username "student" password "Password123"
		And I click on the login button 
		Then I should see the welcome message