Feature: Static testing for Advanced Repayment Page3

@Regression
Scenario: Validate Advance Repayment Page objects post selecting Date
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	And Selects any Repayment Method
	Then Selects any date
	Then Check for Show Dues and Submit button