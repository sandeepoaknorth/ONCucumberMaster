Feature: Static testing for Advanced Repayment Page2

@Sanity
Scenario: Validate Advance Repayment Page objects post selecting Repayment method
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	And Selects any Repayment Method
	Then Check for all common fields
	
@Regression @Sanity
Scenario: Validate Advance Repayment Page objects post selecting Date
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	And Selects any Repayment Method
	Then Selects any date
	Then Check for Show Dues and Submit button