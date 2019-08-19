Feature: Static testing for Advanced Repayment Page "https://acornlab.atlassian.net/browse/ACBPD-2261"

@ignore
Scenario: Validate Advance Repayment Page objects
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	Then Check for Name_Account ID_Approved Amount_Cancel-Button_Remarks
	
@ignore
Scenario: Validate Advance Repayment DropDown values
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	Then Check for Advance Repayment DropDown values
	
@ignore
Scenario: Validate Advance Repayment Page objects post selecting Repayment method
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	And Selects any Repayment Method
	Then Check for all common fields
	
@ignore
Scenario: Validate Advance Repayment Page objects post selecting Date
	Given The user is on Repayment Page
	When He clicks on Advance Payment button
	And Clicks on Repayment Dropdown
	And Selects any Repayment Method
	Then Selects any date
	Then Check for Show Dues and Submit button