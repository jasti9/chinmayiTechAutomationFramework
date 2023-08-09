Feature: Integrate with ChatGPT

  @chatGPT
  Scenario: Connect to ChatGPT and capture response
    Given I establish connection with ChatGPT
    When I request for "Login Test case for E-commerce website"
    Then I save the chatGPT response in file "E-Commerce_Scenarios"
