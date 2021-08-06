package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//all reusable methods
public class Utils {
	public static RequestSpecification request; // to make only 1 object for all test cases

	public RequestSpecification requestSpecification() throws IOException {

		if (request == null) // only for first time need to set these, afterwards can use same object
		{
			PrintStream stream = new PrintStream(new FileOutputStream("my_logs.txt", true)); // file for saving logs and
																								// true is to not
																								// overwrite logs for
																								// every test case

			request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(stream)) // to print or
																			// save
																			// request
																			// logs
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)) // to print or save response logs
					.setContentType(ContentType.JSON).build();
		}

		return request;
	}

	public String getGlobalValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"/Users/Raghu/eclipse-workspace-2021/APIFramework/src/test/java/resources/global.properties"); // reading
																												// from
																												// file
																												// so
																												// input
																												// stream
		properties.load(fileInputStream);

		return properties.getProperty(key);
	}

	public String getJsonPath(Response response, String key) {
		JsonPath jsonPath = new JsonPath(response.asString());
		return jsonPath.get(key);
	}
}
