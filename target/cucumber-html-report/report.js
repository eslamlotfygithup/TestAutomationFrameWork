$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E2E_Test.feature");
formatter.feature({
  "line": 1,
  "name": "automated E2E tests",
  "description": "",
  "id": "automated-e2e-tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Customer place an order by purchaing an  item from search",
  "description": "",
  "id": "automated-e2e-tests;customer-place-an-order-by-purchaing-an--item-from-search",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "he can search for \"\u003cproductName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "move to checkout cart and enter personal details on checkout page and place order",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "he can view order and download the invoice",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "automated-e2e-tests;customer-place-an-order-by-purchaing-an--item-from-search;",
  "rows": [
    {
      "cells": [
        "productName"
      ],
      "line": 12,
      "id": "automated-e2e-tests;customer-place-an-order-by-purchaing-an--item-from-search;;1"
    },
    {
      "cells": [
        "Apple MacBook Pro 13-inch"
      ],
      "line": 13,
      "id": "automated-e2e-tests;customer-place-an-order-by-purchaing-an--item-from-search;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Customer place an order by purchaing an  item from search",
  "description": "",
  "id": "automated-e2e-tests;customer-place-an-order-by-purchaing-an--item-from-search;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "he can search for \"Apple MacBook Pro 13-inch\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "move to checkout cart and enter personal details on checkout page and place order",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "he can view order and download the invoice",
  "keyword": "Then "
});
formatter.match({
  "location": "E2ETests.user_is_on_Home_page()"
});
formatter.result({
  "duration": 318389549,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Apple MacBook Pro 13-inch",
      "offset": 19
    }
  ],
  "location": "E2ETests.he_can_search_for(String)"
});
formatter.result({
  "duration": 5908710569,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.choose_to_buy_Two_items()"
});
formatter.result({
  "duration": 4193881636,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_order()"
});
formatter.result({
  "duration": 23966482416,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.he_can_view_order_and_download_the_invoice()"
});
formatter.result({
  "duration": 9501363546,
  "status": "passed"
});
formatter.uri("UserRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "UserRegistration",
  "description": "I want to check that user can register in our e-commerce website.",
  "id": "userregistration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User Registration",
  "description": "",
  "id": "userregistration;user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"\u003cfirstname\u003e\" , \"\u003clastname\u003e\" , \"\u003cemail\u003e\" , \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "userregistration;user-registration;",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "email",
        "password"
      ],
      "line": 11,
      "id": "userregistration;user-registration;;1"
    },
    {
      "cells": [
        "eslam25251",
        "lotfy25251",
        "eslam252510@test.com",
        "123456789"
      ],
      "line": 12,
      "id": "userregistration;user-registration;;2"
    },
    {
      "cells": [
        "eslam252551",
        "lotfy252551",
        "eslam2525510@test.com",
        "123456789"
      ],
      "line": 13,
      "id": "userregistration;user-registration;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "User Registration",
  "description": "",
  "id": "userregistration;user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"eslam25251\" , \"lotfy25251\" , \"eslam252510@test.com\" , \"123456789\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 5321538902,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_click_on_register_link()"
});
formatter.result({
  "duration": 183581285692,
  "error_message": "java.lang.AssertionError: did not expect to find [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:969)\r\n\tat org.testng.Assert.assertTrue(Assert.java:43)\r\n\tat org.testng.Assert.assertTrue(Assert.java:53)\r\n\tat steps.UserRegistration.i_click_on_register_link(UserRegistration.java:24)\r\n\tat ✽.When I click on register link(UserRegistration.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "eslam25251",
      "offset": 11
    },
    {
      "val": "lotfy25251",
      "offset": 26
    },
    {
      "val": "eslam252510@test.com",
      "offset": 41
    },
    {
      "val": "123456789",
      "offset": 66
    }
  ],
  "location": "UserRegistration.i_entered(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 13,
  "name": "User Registration",
  "description": "",
  "id": "userregistration;user-registration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"eslam252551\" , \"lotfy252551\" , \"eslam2525510@test.com\" , \"123456789\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 1167873088,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_click_on_register_link()"
});
formatter.result({
  "duration": 11318902,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "eslam252551",
      "offset": 11
    },
    {
      "val": "lotfy252551",
      "offset": 27
    },
    {
      "val": "eslam2525510@test.com",
      "offset": 43
    },
    {
      "val": "123456789",
      "offset": 69
    }
  ],
  "location": "UserRegistration.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 2991237382,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 3532404753,
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using css selector\u003da.ico-logout\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-OJH2399\u0027, ip: \u0027192.168.1.3\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByCssSelector(RemoteWebDriver.java:420)\r\n\tat org.openqa.selenium.By$ByCssSelector.findElement(By.java:431)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy23.click(Unknown Source)\r\n\tat pages.Pagebase.ClickButton(Pagebase.java:26)\r\n\tat pages.UserRegisterationPage.userLogout(UserRegisterationPage.java:63)\r\n\tat steps.UserRegistration.the_registration_page_displayed_successfully(UserRegistration.java:42)\r\n\tat ✽.Then the registration page displayed successfully(UserRegistration.feature:8)\r\n",
  "status": "failed"
});
});