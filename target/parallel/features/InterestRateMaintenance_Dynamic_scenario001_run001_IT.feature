# language: en

Feature: Static testing for Interest Rate Maintenance page
  https://acornlab.atlassian.net/browse/ACBPD-1836

Scenario: Add interest rate
Given User is in Interest Rate Maintenance screen
When User provides all mandatory details like Past, GBP - Great British Pound, LIBOR1 12 MONTHS, 4.1, Past dated Rate addition
And Clicks on Update
Then Provided interest details Past, LIBOR1 12 MONTHS, 4.1 should be added and visible under Historic Dates table

# Source feature: src/test/java/resources/dynamicFeatures/InterestRateMaintenance_Dynamic.feature
# Generated by Cucable
