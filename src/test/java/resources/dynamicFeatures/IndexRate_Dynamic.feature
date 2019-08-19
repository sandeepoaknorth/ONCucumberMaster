Feature: Dynamic testing for Index Setup
  https://acornlab.atlassian.net/browse/ACBPD-2261

  Background: 
    Given User is in Index Rate Setup screen

  Scenario Outline: Adding a Fixed Index
    When User provides valid Index Rate Setup inputs <Index Type>, <Name>, <Currency>, <Tenor Value>, <Tenor Frequency>, <Test Scenario>
    And Clicks on Update button
    Then Index details <Index Type>, <Name>, <Currency>, <Tenor Value>, <Tenor Frequency> appears under Interest Rate Index List table

    Examples: 
      | Index Type | Name  | Currency                  | Tenor Value | Tenor Frequency | Test Scenario           |
      | Fixed      | Ts1r7 | Great British Pound - GBP |          12 | Months          | Fixed Index Addition    |
      | Variable   | Ts6r1 | Great British Pound - GBP |          12 | Days            | Variable Index Addition |
      | Fixed      | Ts1   | Great British Pound - GBP |          12 | Months          | Fixed Index Addition    |

  Scenario Outline: Searching an existing index
    When User provides <Currency> or <Name>
    Then Indexes should be filtered out based <Currency> or <Name>

    Examples: 
      | Currency | Name  |
      | USD      | null  |
      | null     | T     |
      | inr      | check |
