Feature: Choose Clothing Item
  I want to choose clothing item in E-Commerce


Scenario: Go through steps to choose item from clothing
  Given The user in the Home page
  When User clicks on Apparel in Home page
  And User clicks on Clothing from Categories
  And User chooses a clothing item
  Then Clothing Item's details displayed
