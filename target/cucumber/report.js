$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("target/parallel/features/ComplexRepayment_scenario004_run001_IT.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: en"
    }
  ],
  "line": 3,
  "name": "Static testing for Advanced Repayment Page",
  "description": "",
  "id": "static-testing-for-advanced-repayment-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11063415900,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Validate Advance Repayment Page objects post selecting Date",
  "description": "",
  "id": "static-testing-for-advanced-repayment-page;validate-advance-repayment-page-objects-post-selecting-date",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "The user is on Repayment Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "He clicks on Advance Payment button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Clicks on Repayment Dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Selects any Repayment Method",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Selects any date",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Check for Show Dues and Submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactUsSteps.the_user_is_on_RepaymentPage()"
});
formatter.result({
  "duration": 8057647900,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.he_clicks_on_AdvancePaymentbutton()"
});
formatter.result({
  "duration": 197969500,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.clicks_on_Repayment_Dropdown()"
});
formatter.result({
  "duration": 341568200,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.selects_any_Repayment_Method()"
});
formatter.result({
  "duration": 992028200,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.selects_any_date()"
});
formatter.result({
  "duration": 360223400,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.check_for_Show_Dues_and_Submit_button()"
});
formatter.result({
  "duration": 128783500,
  "status": "passed"
});
formatter.after({
  "duration": 680438700,
  "status": "passed"
});
});