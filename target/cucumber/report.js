$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("target/parallel/features/InterestRateMaintenance_Static_scenario003_run001_IT.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: en"
    }
  ],
  "line": 3,
  "name": "Static testing for Interest Rate Maintenance page",
  "description": "https://acornlab.atlassian.net/browse/ACBPD-1836",
  "id": "static-testing-for-interest-rate-maintenance-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 12760801100,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Selecting Invalid value",
  "description": "",
  "id": "static-testing-for-interest-rate-maintenance-page;selecting-invalid-value",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User is in Interest Rate Maintenance screen",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User provides an invalid value",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "System should throw an error \"interestRate_invalidValue\"",
  "keyword": "Then "
});
formatter.match({
  "location": "InterestRateMaintenance.user_is_in_interest_rate_maintenance_screen()"
});
formatter.result({
  "duration": 1783193000,
  "status": "passed"
});
formatter.match({
  "location": "InterestRateMaintenance.user_provides_an_invalid_value()"
});
formatter.result({
  "duration": 538636600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "interestRate_invalidValue",
      "offset": 30
    }
  ],
  "location": "InterestRateMaintenance.system_should_throw_an_error_something(String)"
});
formatter.result({
  "duration": 136388700,
  "status": "passed"
});
formatter.after({
  "duration": 766834400,
  "status": "passed"
});
});