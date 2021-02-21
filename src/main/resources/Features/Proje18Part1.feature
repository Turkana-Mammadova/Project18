Feature: Adding a user and logging in by using the user we have created on the

  Background:
    Given I Navigate to "http://thedemosite.co.uk/"
    Then Navigate to Add user menu


  Scenario Outline: User cannot be created with short credentials
    Given I enter "<username>" and "<password>" for new user
    And I click save button
    Then I should get the <result>

    Examples:
      | username | password | result                      |
      | Ece      | 56784@   | username must longer than 4 |
      | Turkana  | 123      | password must longer than 4 |
      | Ali      | @l       | username must longer than 4 |



  Scenario: User can be created with a username and a password whose lengths are more than 3 characters

    Given I enter username:Turkana and password "TechnoSt"
    And I click save button
    Then I should create new account



  Scenario: User can login by using the credentials that have just been created
    And Navigate to log in page
    Given I enter username:Turkana and password "TechnoSt"
    When I click login button
    Then I should get success message


  Scenario Outline: User cannot login with invalid credentials
    And Navigate to log in page
    Given I enter "<username>" and "<password>" for new user
    And I click login button
    Then I should get the fail message

    Examples:
      | username | password |
      | 458q     | TechnoSt |
      | Turkana  | sdtyt    |
      | kana     | abcd     |


  Scenario Outline: User cannot login if at least one of the credentials is less than 4 characters
    And Navigate to log in page
    Given I enter "<username>" and "<password>" for new user
    And I click login button
    Then I should get the <result>

    Examples:
      | username | password | result                      |
      | T        | TechnoSt | username must longer than 4 |
      | Turkana  | Tec      | password must longer than 4 |
      | Tur      | Tec      | username must longer than 4 |
