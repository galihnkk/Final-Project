package helper;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Models {
    private static RequestSpecification request;
    static JSONObject bodyObj = new JSONObject();
    static Faker faker = new Faker();

    public static void setupHeaders(){
        request = RestAssured.given()
                .header("app-id", "65ba064fdeb37cb465f62836");
    }
    public static Response getListUsers(String setURL) {
        setupHeaders();
        return request.when().get(setURL);
    }

    public static Response postListUsers(String setURL){
        setupHeaders();

        String valueFirstName = faker.name().firstName();
        String valueLastName = faker.name().lastName();
        String valueEmail = valueFirstName + "_" + valueLastName + "@dummyapitest.com";
        String valueTitle = Utility.shuffleTitle();
        String valuePicture = Utility.generateRandomPictureLink();
        bodyObj.put("firstName", valueFirstName);
        bodyObj.put("lastName", valueLastName);
        bodyObj.put("email", valueEmail);
        bodyObj.put("title", valueTitle);
        bodyObj.put("picture", valuePicture);

        return request.contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(bodyObj.toString())
                .when().post(setURL);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = Endpoint.GET_USER + "/" + user_id;
        //System.out.println(finalEndpoint);
        return request.when().delete(finalEndpoint);
    }
    public static Response updateUserEmail(String user_id){
        String finalPutEndpoint = Endpoint.GET_USER + "/" + user_id;
        //System.out.println("final url: " + finalPutEndpoint);

        bodyObj = new JSONObject();

        String valueUpdatedEmail = "updateUserEmaill@dummyapitest.com";
        bodyObj.put("email", valueUpdatedEmail);

        setupHeaders();
        return request.contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(bodyObj.toString()).when().put(finalPutEndpoint);
    }
}