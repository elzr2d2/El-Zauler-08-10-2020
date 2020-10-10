@FunctionalityTesting
Feature: Click Button

  Scenario Outline: check the scroll up button functionality
    Given user goes to the landing page
    And scrolls <section>
    When click the <button> button
    Then user gets into the top of the page
    Examples:
      | button    | section |
      | scroll_up | down    |

  Scenario Outline: click wrapper whatsapp link button
    Given user goes to the landing page
    When click the <link_button> button
    Then user gets into a <link_name> page

    Examples:
      | link_button      | link_name |
      | wrapper_whatsapp | whatsapp  |

  Scenario Outline: click <link_button> link button
    Given user goes to the landing page
    And scrolls <section>
    When click the <link_button> button
    Then user gets into a <link_button> page

    Examples:
      | link_button  | section |
      | linkedin     | down    |
      | whatsapp     | down    |
      | facebook     | down    |
      | herolo.co.il | down    |



