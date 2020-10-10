@FunctionalityTesting
Feature: Image Movement

  Scenario Outline: check images movement by clicking arrows
    Given user goes to the landing page
    When user scrolls to the <section> section
    And clicks on the <arrow> arrow of <section> section
    Then the <section> section images should be swapped
    Examples:
      | section | arrow |
      | first   | left  |
      | first   | right |

  Scenario Outline: check images movement by clicking dots
    Given user goes to the landing page
    When user scrolls to the <section> section
    And clicks on the dots of the <section> section
    Then the <section> section images should be swapped
    Examples:
      | section |
      | first   |
      | second  |

  Scenario Outline: check images movement by dragging
    Given user goes to the landing page
    When user scrolls to the <section> section
    And dragging an image <side> of the <section> section
    Then the <section> section images should be swapped
    Examples:
      | section | side  |
      | first   | left  |
      | first   | right |
      | second  | left  |
      | second  | right |