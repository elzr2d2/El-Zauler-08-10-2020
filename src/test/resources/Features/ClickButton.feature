@FunctionalityTesting
Feature: Click Button

  Scenario Outline: check the scroll up button functionality
    Given user goes to the landing page
    And scrolls 'down'
    When click the <button> button
    Then user gets into the top of the page
    Examples:
      | button    |
      | scroll_up |

  Scenario Outline: click wrapper whatsapp link button
    Given user goes to the landing page
    When click the <link_button> button
    Then user gets into a <link_name> page

    Examples:
      | link_button      | link_name |
      | wrapper_whatsapp | whatsapp  |

  Scenario Outline: click <link_button> link button
    Given user goes to the landing page
    And scrolls 'down'
    When click the <link_button> button
    Then user gets into a <link_button> page

    Examples:
      | link_button  |
      | linkedin     |
      | whatsapp     |
      | facebook     |
      | herolo.co.il |



