
Feature: Ebay home page
@P1
Scenario: Advanced search link

Given Ebay home page
When i click the advanced link
Then I navigate to Advanced Search page

@P2
Scenario: Search item count

Given Ebay home page
When I search for "Iphone 11"
Then I validate atleast 1000 items

@P3
Scenario: Search item count

Given Ebay home page
When I search for "Toy cars"
Then I validate atleast 100 items

@P4
Scenario: Search in a category

Given Ebay home page
When I search for 'soap' in 'Baby' category


@P5
Scenario Outline: Home Page Links

Given Ebay home page
When I click on the "<link>"
Then I validate that the page navigates to "<url>" and title contains "<title>"

Examples:
  | link    | url                                                                | title       |
  | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors |
  | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing    |
  | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys        |

