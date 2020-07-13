# new feature
# Tags: optional

Feature: Validate Service Wheater

  Scenario Outline: Verify if place is being succesfully
    Given get place en el service "<Ciudad>" , "<Appid>"
    When user calls http request
    Then the API call got success with status code 200
    And response body as "<Ciudad>"
    And response body show humidity as integer
    And response body show weather as description

    Examples:
    |Ciudad|Appid                           |
    |Lima  |439d4b804bc8187953eb36d2a8c26a02|