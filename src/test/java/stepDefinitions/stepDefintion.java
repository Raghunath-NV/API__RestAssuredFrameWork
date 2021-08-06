package stepDefinitions;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;

import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefintion extends Utils {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	JsonPath jsonPath;
	
	
	@Given("^Add place Payload$")
	public void add_place_payload() throws Throwable {

		requestSpecification = given().spec(requestSpecification()).body(data.addPlacePayload());
	}

	@Given("Add place Payload with {string} , {string} , {string} and {string}")
	public void add_place_payload_with_something_something_something_and_something(String name, String language,
			String address, String phone) throws Throwable {

		requestSpecification = given().spec(requestSpecification())
				.body(data.addPlacePayload(name, language, address, phone));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_something_with_something_http_request(String resource, String httpMethod) throws Throwable {

		// constructor will be called with the value of resouce we pass
		APIResources apiResources = APIResources.valueOf(resource);

		// res = requestSpecification.when().post("/maps/api/place/add/json");

		if (httpMethod.equalsIgnoreCase("POST"))
			response = requestSpecification.when().post(apiResources.getResouce());
		else if (httpMethod.equalsIgnoreCase("GET"))
			response = requestSpecification.when().post(apiResources.getResouce());

	}

	@Then("the API call is success with status code is 200")
	public void the_api_call_is_success_with_status_code_is_200() throws Throwable {

		assertEquals(response.getStatusCode(), 200);

	}

	@And("{string} in response body is {string}")
	public void something_in_response_body_is_something(String key, String value) throws Throwable {
		assertEquals(getJsonPath(response, key), value);

	}

	@And("verify place_Id created maps to {string} using {string}")
	public void verify_placeid_created_maps_to_something_using_something(String expectedName, String resource)
			throws Throwable {
		requestSpecification = given().spec(requestSpecification()).queryParam("place_id",
				getJsonPath(response, "place_id"));

		place_id = getJsonPath(response, "place_id");
		user_calls_something_with_something_http_request(resource, "GET");

		assertEquals(getJsonPath(response, "name"), expectedName); // getting name in response and comparing with the passed
																// value
	}

	@Given("Delete place Payload")
    public void delete_place_payload() throws Throwable {
		requestSpecification = given().spec(requestSpecification()).body(data.deletePlaceLoad(place_id));
        
    }
}