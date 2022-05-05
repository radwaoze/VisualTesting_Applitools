Feature: Save Linkedin CV as PDF
  I want to save CV as PDF in Linkedin


  Scenario: Go through steps to save CV as PDF from Linkedin
    Given The user in Linkedin website
    When User clicks on Sign in button
    And User login with  email and password
    And User clicks on account picture
    And User clicks on More button from account page
    And User clicks on Save to Pdf from dropdown list
    Then File is downloaded successfully