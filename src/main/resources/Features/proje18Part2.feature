Feature: Login Functionality tests for Campus website

  Background:
    Given Navigate to "https://test.campus.techno.study/"

  Scenario: User can login with valid credentials
    Given I login using username daulet2030@gmail.com and password "TechnoStudy123@"
    When Click to the login button
    Then I sould login

  Scenario Outline: User cannot login with invalid credentials
    Given I enter "<username>" and "<password>"
    When Click to the login button
    Then I should get failure message

    Examples:
      | username             | password        |
      | daulet@gmail.com     | TechnoStudy123@ |
      | daulet2030@gmail.com | TStudy@         |
      | daulet123@gmail.com  | technostudy     |


  Scenario Outline: User cannot login if at least one of the credentials is left blank (is not entered)

    Given I enter "<username>" and "<password>"
    When Click to the login button
    Then I should get <message>

    Examples:
      | username             | password        | message                     |
      | daulet2030@gmail.com |                 | Password required           |
      |                      | TechnoStudy123@ | Email required              |
      |                      |                 | Password and Email required |