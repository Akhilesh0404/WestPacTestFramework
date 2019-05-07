Feature: To Calculate Projected balances at retirement for All Users

Scenario: Projected balances for Employed at retirement
Given User is on the KiwiSaver Retirement Calculator Page
And User "Current age" is "30"
And User select "Employed" from dropdown "Employment status"
And User "Salary" is "82000"
And User choose "4%" from radio "KiwiSaver member contribution"
And User select "17.5" from dropdown "PIR"
And User choose "High" from radio "Risk profile"
And User click on button "View your KiwiSaver retirement projections"
And User can see their  Projected  balance


Scenario: Projected balances for Self Employed at retirement
Given User is on the KiwiSaver Retirement Calculator Page
And User "Current age" is "45"
And User select "Self-employed" from dropdown "Employment status"
And User select "10.5" from dropdown "PIR"
And User "Current KiwiSaver balance" is "100000"
And User "Voluntary contributions" is "90" and select "Fortnightly"
And User choose "Medium" from radio "Risk profile"
And User "Savings goal at retirement" is "290000"
And User click on button "View your KiwiSaver retirement projections"
And User can see their  Projected  balance


Scenario: Projected balances for Not Employed at retirement
Given User is on the KiwiSaver Retirement Calculator Page
And User "Current age" is "55"
And User select "Not employed" from dropdown "Employment status"
And User select "10.5" from dropdown "PIR"
And User "Current KiwiSaver balance" is "140000"
And User "Voluntary contributions" is "10" and select "Annually"
And User choose "Medium" from radio "Risk profile"
And User "Savings goal at retirement" is "200000"
And User click on button "View your KiwiSaver retirement projections"
And User can see their  Projected  balance









