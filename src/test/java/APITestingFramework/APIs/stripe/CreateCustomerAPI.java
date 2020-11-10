package APITestingFramework.APIs.stripe;

import java.util.Hashtable;

import APITestingFramework.setUp.BaseTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateCustomerAPI extends BaseTest {
	
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {

		

		//sample comment 123
			Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
			.formParam("email", data.get("email")).formParam("description", data.get("description"))
			.post(config.getProperty("customerAPIEndPoint"));
			
			return response;
			
		}

		public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data) {

			
			Response response = given().auth().basic(config.getProperty("inValidSecretKey"), "")
					.formParam("email", data.get("email")).formParam("description", data.get("description"))
					.post(config.getProperty("customerAPIEndPoint"));
			
			return response;
		}


}
