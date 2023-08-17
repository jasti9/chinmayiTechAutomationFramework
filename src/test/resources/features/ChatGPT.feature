Feature: Integrate with ChatGPT

  @chatGPT
  Scenario: Connect to ChatGPT and capture response
    Given I establish connection with ChatGPT
    When I request for "How is weather today"
    Then I save the chatGPT response in file "Weather"
