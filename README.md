Assumptions:
1) User 1 has only one post
2) Comments can be viewed for a particular post

Tools Used:
1) RestAssured
2) AssertJ
3) Google Gson
4) Cucumber-JVM

Tests Performed:
1) There is only one post associated to user id 1
2) When requesting for comments for post id 1 results should only contain comments pertinent to that post

Actual Results:
1) User Id has only one post -- Test Passed
2) When requesting for comments for a post the results contain comments from other posts

The overall result is fail because comments end point returns all comments from all posts when it should return comment for
particular post requested for.


To Run the test:
1) Via IntelliJ: Right click on TestRunner and click Run
2) Via Command Line: run the command mvn test





