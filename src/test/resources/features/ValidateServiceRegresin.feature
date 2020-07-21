Feature: Validate Service regresIN

  Scenario: Validate create usuario
    Given add to the service
      |Luis |Administrator |
      |Juan |Qa automation |
    When user calls http request
    Then the API regresIN call got success with status code 201

  Scenario Outline: Validate update usuario
    Given add to the service "<name>" , "<job>"
    When user calls http request
    Then the API regresIN call got success with status code 200
    And response body show "<name>" , "<job>"
    And response body show created date

    Examples:
      |name |job           |
      |Luis |Administrator |
      |Juan |Qa automation |