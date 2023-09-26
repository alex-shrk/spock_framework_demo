Feature: Book Store UI
  Tests for Book Store

  Scenario: Open book info
    Given Exists book with isbn "9781449325862" and name "Git Pocket Guide"
    When Find Book by href link with book name and open it
    Then Page URL contains book's ISBN

