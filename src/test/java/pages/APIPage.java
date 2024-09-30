package pages;

import helper.Endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.Objects;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class APIPage {
    String setURL, global_id;
    Response res;

    public void prepareUrl (String url){

        if (Objects.equals(url, "GET_USER")){
            setURL = Endpoint.GET_USER;
        }
        else if (Objects.equals(url, "POST_USER")) {
            setURL = Endpoint.POST_USER;
        }
        else if (Objects.equals(url, "GET_TAGS")){
            setURL = Endpoint.GET_TAGS;
        }
        else {
            System.out.println("Wrong URL" + url);
        }
    }
    public void hitApiGetRequest(){
        res = getListUsers(setURL);
        //System.out.println(res.getBody().asString());
    }
    public void hitApiPostRequest(){
        res = postListUsers(setURL);
        //System.out.println(res.getBody().asString());
    }
    public void hitApiGetRequestSpecificID(String userID){
        res = getListUsers(setURL+"/"+userID);
        //System.out.println(res.getBody().asString());
    }
    public void assertResponseCode(int status_Code){
        assertThat(res.statusCode()).isEqualTo(status_Code);
    }
    public void validateJsonSchema(String jsonSchema){
        File jsonfile = new File("src/test/java/helper/JSONSchemas/"+jsonSchema);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonfile));
    }

    public void validationResponseBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String title = jsonPathEvaluator.get("title");
        String picture = jsonPathEvaluator.get("picture");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(title).isIn("mr", "ms", "mrs", "miss", "dr");
        assertThat(picture).isNotNull();

        global_id = id;
    }

    public void hitApiDeleteRequest(){
        res = deleteUser(setURL, global_id);
    }

    public void hitApiPutEmailRequest(){
        res = updateUserEmail(global_id);
        //System.out.println(res.getBody().asString());
    }
}