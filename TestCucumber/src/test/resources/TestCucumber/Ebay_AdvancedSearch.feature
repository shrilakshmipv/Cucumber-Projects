Feature: Ebay Advanced Serach Page

@P21
Scenario: Logo on Advanced Search Page

Given I am on Ebay Advanced Search Page
When I click on Ebay logo
Then I navigate to Ebay HOme page


@P22
Scenario: Advance Search on an item
Given I am on Ebay Advanced Search Page
When I advance searced an item
    | Keyword   | Exclude     | min | max|
    | iphone 11 | refurbished | 300 | 900|