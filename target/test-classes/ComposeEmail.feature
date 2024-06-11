Feature: Compose and Send Email in Gmail

  Scenario: Send an email successfully
    Given I am logged into Gmail
    When I click on "Compose"
    And I enter the recipient email
    And I enter the subject "Incubyte"
    And I enter the email body "Automation QA test for Incubyte"
    And I click on "Send"
    Then the email should be sent successfully
    And the email should appear in the "Sent" folder with subject "Incubyte"

  Scenario: Verify email appears in Sent folder
    Given an email was sent with subject "Incubyte"
    When I navigate to the "Sent" folder
    Then I should see an email with the subject "Incubyte"

  Scenario: Error when sending email without recipient
    Given I am logged into Gmail
    When I click on "Compose"
    And I leave the recipient email blank
    And I enter the subject "Incubyte"
    And I enter the email body "Automation QA test for Incubyte"
    And I click on "Send"
    Then I should see an error message indicating recipient is required

  Scenario: Warning when sending email without subject
    Given I am logged into Gmail
    When I click on "Compose"
    And I enter the recipient email
    And I leave the subject blank
    And I enter the email body "Automation QA test for Incubyte"
    And I click on "Send"
    Then I should see a warning prompt asking to confirm sending without subject

  Scenario: Send email with empty body successfully
    Given I am logged into Gmail
    When I click on "Compose"
    And I enter the recipient email
    And I enter the subject "Incubyte"
    And I leave the email body blank
    And I click on "Send"
    Then the email should be sent successfully
    And the email should appear in the "Sent" folder with subject "Incubyte"
