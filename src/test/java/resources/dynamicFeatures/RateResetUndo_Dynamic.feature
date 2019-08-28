Feature: Dynamic testing for Rate Reset Undo

  Scenario Outline: Undo rate reset event
    Given User is in Loan Wall screen for the Customer <Customer> and Account <Account Number>
    And User clicks on Transaction section
    When User clicks "Undo" button for Rate Reset event
    Then Even gets reversed

    Examples: 
      | Customer  | Account Number |
      | .0Lohitha | Fbb048         |

  Scenario Outline: Redo rate reset event
    Given User is in Loan Wall screen for the Customer <Customer> and Account <Account Number>
    And User clicks on Transaction section
    Then User clicks "Redo" button for Rate Reset event

    Examples: 
      | Customer  | Account Number |
      | .0Lohitha | Fbb048         |
