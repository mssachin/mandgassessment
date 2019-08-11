Feature: Validate comments are only viewed for the posts requested for
  As a user to social platform
  I should be not be able to view the comments associated to posts that I have requested for
  So that there security and privacy is enforced


  Scenario: Validate user can only see comments on the posts requested for
    Given Eddie requests for comments for John's post
    Then Eddie can see only the comments for that post

