Feature: automated E2E tests

Scenario Outline: Customer place an order by purchaing an  item from search 
Given user is on Home page 
When he can search for "<productName>" 
And choose to buy Two items
And move to checkout cart and enter personal details on checkout page and place order
Then he can view order and download the invoice


Examples: 
|productName|
|Apple MacBook Pro 13-inch|






