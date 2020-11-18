@attachmentJourney
Feature: Attachment journey

  @attachment1
  Scenario: As a user i want to upload a document
    Given I launch the url in the browser
    When I login to the url with nichol.kilback and iuy837lq2bi3a1
    And I navigate to upload Document option from Document bar
    When I enter all the necessary fields and upload the document
    Then I verify the document is uploaded
    When I search the document from document register
    And  I save the search
    Then I display the search text and document id
