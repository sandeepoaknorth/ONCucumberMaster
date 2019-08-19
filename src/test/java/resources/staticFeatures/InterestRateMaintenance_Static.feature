Feature: Static testing for Interest Rate Maintenance page
https://acornlab.atlassian.net/browse/ACBPD-1836

  #Scenario: Check UI elements - Rate Maintenance
    #Given User is in Interest Rate Maintenance screen
     #Then User should see all UI elements of Interest Rate Maintenance page
      #And User should see all the supported currencies
  
  #Scenario: Selecting Future date or Holiday
    #Given User is in Interest Rate Maintenance screen
     #When User enters future date and provides other valuews
      #And Clicks on Update button
     #Then System should throw a notification error for "interestRateMaintenance_futureDate"
  
  Scenario: Selecting Invalid value
    Given User is in Interest Rate Maintenance screen
     When User provides an invalid value
     Then System should throw an error "interestRate_invalidValue"


    