package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.SoftAssertions;
import responseobjects.SingleCommentDetails;
import responseobjects.SinglePostDetails;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatePostsStepDefinitions {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private int scenarioPostId;


    @Given("Eddie requests for comments for John's post")
    public void eddie_Requests_for_comments_for_John_s_post() {
        SinglePostDetails singlePostDetails = given().with()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .when()
                .get(BASE_URL + "posts/1")
                .then()
                .statusCode(200)
                .extract().as(SinglePostDetails.class);
        scenarioPostId = singlePostDetails.getId();
        assertThat(singlePostDetails.getUserId(), equalTo(1));
    }

    @Then("Eddie can see only the comments for that post")
    public void eddie_can_see_only_the_comments_for_that_post() {
        SingleCommentDetails[] singleCommentDetailsArr = given().with()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .when()
                .get(BASE_URL + "posts/" + scenarioPostId + "/comments")
                .then()
                .statusCode(200)
                .extract().as(SingleCommentDetails[].class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (SingleCommentDetails singleCommentDetails : singleCommentDetailsArr) {
            int postId = singleCommentDetails.getPostId();
            softAssertions.assertThat(postId).isEqualTo(scenarioPostId);
        }
        softAssertions.assertAll();
    }


}
