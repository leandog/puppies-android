Feature: Displaying the details of a puppy

  Scenario: Learning more about a puppy I am interested in
    Given I am looking at the available puppies
    When I want to learn more information about "Sparky"
    Then I will be able to see "Sparky"s details
