Feature:  Displaying information about puppies that are available for adoption

  Scenario: Knowing the names of the available puppies
    When I am looking at the available puppies
    Then I can see that "Sparky" is available for adoption

  @notready
  Scenario: Knowing the breed and genders of the available puppies
    When I am looking at the available puppies
    Then I can see that "Ruby Sue" is a "Female"
    And I can see that "Ruby Sue" is a "Pit Bull Terrier"

  @notready
  Scenario: Being overwhelmed by the cuteness of the available puppies
    When I am looking at the available puppies
    Then I will be moved when I look into "Maggie Mae"s eyes

  @notready
  Scenario: Getting to know the available puppies
    When I am looking at the available puppies
    Then I can see the "Brook"s description starts with  "This young lady is trying"
