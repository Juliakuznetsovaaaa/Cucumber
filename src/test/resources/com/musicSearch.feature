Feature: Music search
  Scenario Outline: Add a music
    Given user is on home page
    When User clicks on music toolbar
    And User clicks on search icon
    And User enter Author as "<author>"
    Then User author should be "<author>"

    Examples:
  | author       |
  | Thomas Mraz  |
  | Taylor Swift |
  | Selena Gomez |

