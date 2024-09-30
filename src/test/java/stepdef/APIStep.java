package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.APIPage;

public class APIStep {
    APIPage apiPage;
    public APIStep(){
        this.apiPage = new APIPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrl(String url){
        apiPage.prepareUrl(url);
    }

    @When("hit api get request")
    public void hitApiGetRequest() {
        apiPage.hitApiGetRequest();
    }

    @When("hit api get request for a specific id {string}")
    public void hitApiGetRequestForASpecificId(String userID) {
        apiPage.hitApiGetRequestSpecificID(userID);
    }

    @Then("response code will be {int}")
    public void responseCodeWillBe(int status_Code) {
        apiPage.assertResponseCode(status_Code);
    }

    @And("response body match with JSONSchema {string}")
    public void responseBodyMatchWithJsonSchema(String jsonSchema) {
        apiPage.validateJsonSchema(jsonSchema);
    }

    @When("hit api post request")
    public void hitApiPostRequest() {
        apiPage.hitApiPostRequest();
    }

    @Then("hit api put request to update the email")
    public void hitApiPutRequestToUpdateTheEmail() {
        apiPage.hitApiPutEmailRequest();
    }

    @Then("hit api delete request")
    public void hitApiDeleteRequest() {
        apiPage.hitApiDeleteRequest();
    }

    @And("validate create response body")
    public void validateCreateResponseBody() {
        apiPage.validationResponseBodyCreateUser();
    }
}