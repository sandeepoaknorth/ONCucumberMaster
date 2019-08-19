Feature: Static testing for Index Setup
  https://acornlab.atlassian.net/browse/ACBPD-2261
  
  Background:
  Given User is in Index Rate Setup screen

  Scenario: Check UI elements - Index Setup
    Then User should see all UI elements of Index Rate Setup screen
    And User should see all the supported currencies
    And User should see all the supported frequencies
  # Elements to be validated are,
  # Interest Rate Index header
  # Name
  # Currency
  # Value
  # Frequency
  # Tenor
  # Filter by currency
  # Filter by name
  # Table column headers: Name, Currency, Tenor Value, Tenor Frequency
  # Delete button
  # Refresh button
  # Update & Cancel Button
  
  Scenario: Check Reset button
    When User provides valid Index Rate Setup inputs
    And Clicks on Reset button
    Then Provided inputs should be cleaned
