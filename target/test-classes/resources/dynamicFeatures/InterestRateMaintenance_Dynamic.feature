Feature: Static testing for Interest Rate Maintenance page
  https://acornlab.atlassian.net/browse/ACBPD-1836

  Scenario Outline: Add interest rate
    Given User is in Interest Rate Maintenance screen
    When User provides all mandatory details like <Business Date>, <Currency>, <Reference Rate>, <Value>, <Test Scenario>
    And Clicks on Update
    Then Provided interest details <Business Date>, <Reference Rate>, <Value> should be added and visible under Historic Dates table

    Examples: 
      | Business Date | Currency                  | Reference Rate   | Value   | Test Scenario            |
      | Past          | Great British Pound - GBP | LIBOR1 12 MONTHS |     4.1 | Past dated Rate addition |
      #| Today         | EUR - Euro                | fff              | 6.55555 | Decimal Rate addition    |
      #| Today         | USD - Us Dollars          | LIBOR 1 Years    |       0 | Zero Rate addition       |
