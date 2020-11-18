@emailJourney
Feature: Oracle Test

  @email
  Scenario: As a user i want to verify if the email can be sent
    Given I launch the url in the browser
    When I login to the url with poleary and ac0n3x72
    And I navigate to blank mail option from mail nav bar
    When I enter the necessary fields and send the mail
    Then I verify the email is sent successfully