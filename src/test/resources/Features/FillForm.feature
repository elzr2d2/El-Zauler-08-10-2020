@FunctionalityTesting
Feature: Fill Form

  Scenario Outline: Fill a footer form
    Given user goes to the landing page
    When user inserts <name>, <email>, and <phone> in a <form> form
    And  user clicks on the <form> Form send button
    Then user gets into the thank-you page

    Examples:
      | name | email            | phone      | form   |
      | El   | elr2d2@gmail.com | 0548048202 | footer |

  Scenario Outline: Fill a section form
    Given user goes to the landing page
    And scrolls down
    When user inserts <name>, <email>, <phone>, and <company> in the section form
    And  user clicks on the <form> Form send button
    Then user gets into the thank-you page

    Examples:
      | name | email            | phone      | company         | form    |
      | El   | elr2d2@gmail.com | 0548048202 | Galactic Empire | section |

  Scenario Outline: Fill a pop up form
    Given user goes to the landing page
    And the popup form appears
    When user inserts <name>, <email>, and <phone> in a <form> form
    And  user clicks on the <form> Form send button
    Then user gets into the thank-you page

    Examples:
      | name | email            | phone      | form   |
      | El   | elr2d2@gmail.com | 0548048202 | popup  |
