Feature: UserRegistration
 I want to check that user can register in our e-commerce website. 
 
 Scenario Outline: User Registration
 Given the user in the home page
 When I click on register link
 And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
 Then the registration page displayed successfully 
 
 Examples:
 | firstname | lastname | email | password |
 | eslam25251 | lotfy25251 | eslam252510@test.com | 123456789 |
 | eslam252551 | lotfy252551 | eslam2525510@test.com | 123456789 |