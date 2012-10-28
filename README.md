## The Happy Puppy Android Application
This is the fully implemented application with all of the features and units passing.

## Getting Started
```
cd cukes
bundle
rake
```

## Completed Scenarios
```ruby
Feature: Displaying information about puppies that are available for adoption

  Scenario: Knowing the names of the available puppies
    When I am looking at the available puppies
    Then I can see that "Sparky" is available for adoption

  Scenario: Knows the breed and gender of available puppies
    When I am looking at the available puppies
    Then I can see that "Ruby Sue" is a "Pit Bull Terrier"
    And I can see that "Ruby Sue" is a "Female"

  Scenario: Being overwhelmed by the cuteness of the available puppies
    When I am looking at the available puppies
    Then I will be moved when I look into "Maggie Mae"s eyes

  Scenario: Getting to know the available puppy
    When I am looking at the available puppies
    Then I can see that "Brook"s description starts with "This young lady is trying"

Feature: Displaying the details of a puppy

  Scenario: Learning more about a puppy I am interested in
    Given I am looking at the available puppies
    When I want to learn more information about "Sparky"
    Then I will be able to see "Sparky"s details

  Scenario: Seeing the name and breed of my puppy
    Given I am looking at the available puppies
    When I want to learn more information about "Sparky"
    Then I know that they are a type of "Austrailian Cattle Dog (Blue Heeler)"
    And I know that they are a "Male"

  Scenario: Learning more about the life of my puppy
    Given I am looking at the available puppies
    When I want to learn more information about "Spud"
    Then I can see that my puppy "is playful and friendly and would make a great addition to your family"

  Scenario: Looking into the eyes of my puppy one last time
    Given I am looking at the available puppies
    When I want to learn more information about "Ruby Sue"
    Then I can look into the eyes of my puppy before I make my decision

  Scenario: Knowing what my puppy will set me back
    Given I am looking at the available puppies
    When I want to learn more information about "Tipsy"
    Then I know that the adoption fee is "$42.00"

9 scenarios (9 passed)
25 steps (25 passed)
0m46.257s
```

## Screenshots
Here are the screens that were finished.

![Puppies](https://raw.github.com/leandog/puppies-android/completed/screenshots/puppies.png)

![Puppies](https://raw.github.com/leandog/puppies-android/completed/screenshots/puppy_tale.png)
