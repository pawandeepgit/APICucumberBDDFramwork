
Feature: Bike Location Functionality Testing
   
    @regression
    Scenario: As a user I want to verify that City frankfurt is in Germany and return its Longitude and latitude
    Given As a user I established connection with the serviceURL
    And I hit url with request parameters
    When I get the response 
    Then I validate the response
   


  
