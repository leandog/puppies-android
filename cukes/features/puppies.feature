Feature:  Displaying information about puppies that are available for adoption

  Scenario: Knowing the names of the available puppies
    When I am looking at the available puppies
    Then I can see that "Sparky" is available for adoption

  Scenario: Knows the breed and gender of available puppies
    When I am looking at the available puppies
    Then I can see that "Ruby Sue" is a "Pit Bull Terrier"
    And I can see that "Ruby Sue" is a "Female"

  Scenario: Being overwhelmed by the cuteness of the available puppies
    When I am looking at the available puppies
    Then I will be moved when I look into "Magie Mae"s eyes
