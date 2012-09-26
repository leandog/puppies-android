Feature: Displaying the details of a puppy

  @notready
  Scenario: Learning more about a puppy I am interested in
    Given I am looking at the available puppies
    When I want to learn more information about "Sparky"
    Then I will be able to see "Sparky"s details

  @notready
  Scenario: Seeing the name and breed of my puppy
    When I am learning more information about "Sparky"
    Then I know that "Sparky" is a "Austrailian Cattle Dog (Blue Heeler)"

  @notready
  Scenario: Learning more about the life of my puppy
    When I am learning more information about "Spud"
    Then I can see that my puppy "is playful and friendly and would make a great addition to your family"

  @notready
  Scenario: Knowing what my puppy will set me back
    When I am learning more information about "Tipsy"
    Then I know that "Tipsy" can be adopted for "$42.00"

  @notready
  Scenario: Looking into the eyes of my puppy one last time
    When I am learning more information about "Hanna"
    Then I can look into the eyes of my puppy before I make my decision
