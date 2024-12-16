Feature: Dropdown and DragAndDrop

  Scenario: User selects Dropdown and Drag and Drop
    Given User is on Dropdown page
    When I select India from the dropdown
    Then India should be selected
    When I drag the item from Source Image to Trash
    Then the item should be dropped successfully
    
    