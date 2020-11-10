package APITestingFramework.APIs.stripe;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.*;
import APITestingFramework.setUp.BaseTest;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String, String> data) {

		// Inside DeleteCustomer API
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerAPIEndPoint") + "/" + data.get("id"));

		return response;
	}
}
