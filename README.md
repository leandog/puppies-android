## The Happy Puppy Android Application
This is the result of the live-coding session that was done at the [Test Driven Android](http://m3conf.com/home/schedule#Test_Driven_Android) talk for M3 2012.

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

5 scenarios (5 passed)
12 steps (12 passed)
0m25.578s

```

## Screenshots
Here are the screens that were finished.

![Puppies](https://raw.github.com/leandog/puppies-android/m3conf/screenshots/puppies.png)
![Puppies](https://raw.github.com/leandog/puppies-android/m3conf/screenshots/puppy_tale.png)

## Getting Started
### Installing Brazenhead
```
gem install -l gems/brazenhead-0.4.4.gem
```

### Installing Gametel
```
gem install -l gems/gametel-0.5.3.gem
```
