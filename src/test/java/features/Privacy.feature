
Feature: Gdpr
    As a user
    I want to control my privacy within the app


    Scenario: Back from personalised goes to intro
        Given I open the app
        When I agree to metoffice privacy policy
        Then I see GDPR personalised advertising screen
        When I click the back button
        Then I see the GDPR privacy policy screen


    Scenario: Back from non-personalised goes to intro
        Given I open the app
        When I agree to metoffice privacy policy
        Then I see GDPR personalised advertising screen
        When I click the back button
        Then I see the GDPR privacy policy screen