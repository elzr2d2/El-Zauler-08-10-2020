@FunctionalityTesting
Feature: Image Movement

  Scenario Outline: check images movement by clicking arrows
    Given user goes to the landing page
    When user scrolls to the 'first' image section
    And clicks on the <arrow> arrow
    Then the 'first' section images should be swapped
    Examples:
      | arrow |
      | left  |
      | right |

  Scenario Outline: check images movement by clicking dots
    Given user goes to the landing page
    When user scrolls to the 'first' image section
    And clicks on the dots
    Then the 'first' section images should be swapped

    When user scrolls to the 'second' image section
    And clicks on the dots
    Then the 'second' section images should be swapped
    Examples:
      | section |
      | first   |
      | second  |

  Scenario Outline: check images movement by dragging
    Given user goes to the landing page
    When user scrolls to the <section> image section
    And dragging an image <side>
    Then the <section> section images should be swapped
    Examples:
      | section | side |
      | first   | left |
      | first  | right |
      | second   | left |
      | second   | right |


  Scenario Outline: check images movement by timing
    Given user goes to the landing page
    When user scrolls to the <section> image section
    And wait
    Then the <section> section images should be swapped
    Examples:
      | section |
      | first   |
      | second  |