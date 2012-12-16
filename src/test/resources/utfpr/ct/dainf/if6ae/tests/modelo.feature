Feature: Servlet should run
  In order to create a servlet template
  As a web developer
  I want to be able to run a simple servlet

  Scenario: Open the home page
    Given I am on the home page
    Then I should see "Olá, mundo!"
