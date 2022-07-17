Feature: bla
#  ##Payment Gateway Scenario
#####	•	Scenario
#  Before you order the toy, you should create a scenario to verify Header
#  Here is the expected text “Mother Elephant With Babies Soft Toy”
#  You should use parametrization in this scenario
#####	•	Scenario
#  In order page you need to verify that the toy price is 20$
#  Create a scenario verify that the toy price is 20$

#####	•	Scenario
#  Create a scenario that the URL should contain “payment-gateway”
#####	•	Scenario
#  The quantity must be 5
#  You may need to fake enter card information (Card number will be 16 digit)
#  Once you order, you should be able to verify “Payment successfull!” text.


#####	•	Scenario outline
#  The quantity must be 5,8,9,2,4
#  You may need to fake enter card information (Card number will be 16 digit)
#  Once you order, you should be able to verify “Payment successfull!” text.
  Background:
    Given user wants to be on Getaway home page
  Scenario: Toy order
    Given Verify that header match with expected text  "Mother Elephant With Babies Soft Toy"
  Scenario:
    Given Verify that toy price match with expected price  "$20"
  Scenario:
    Given  Verify that Url contains "payment-gateway"
  Scenario:
      Given user wants select quantity as "5" and click buy now
      When user wants to enter cc info as following and order
        |card number|1234567890123456|
        |month      |03              |
        |year       |2023            |
        |cvv        |211             |
      Then Verify that "Payment successfull!" text matches
  Scenario Outline:
    Given user wants select quantity as "<quantity>" and click buy now
    When user wants to enter cc info as following and order
      |card number|1234567890123456|
      |month      |03              |
      |year       |2023            |
      |cvv        |211             |
    Then Verify that "Payment successfull!" text matches

    Examples:
      |quantity|
      |     5  |
      |     8  |
      |     9  |
      |     2  |
      |     4  |
