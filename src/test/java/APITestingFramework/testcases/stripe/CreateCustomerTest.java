package APITestingFramework.testcases.stripe;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APITestingFramework.APIs.stripe.CreateCustomerAPI;
import APITestingFramework.listeners.ExtentListeners;
import APITestingFramework.setUp.BaseTest;
import APITestingFramework.utilities.DataUtil;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {
	
	
	// Code
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data)
	{
//		Response response = given().auth().basic("sk_test_JRVyUCpnnXAp7cPBRfmxsrFF000wOZZAxp", "")
//		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
//				.formParam("email", "sharookh@gmail.com")
//				.formParam("description", "Coustomer user")
////				.post("https://api.stripe.com/v1/customers");
//				.post(config.getProperty("customerAPIEndPoint"));
		
//		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
//				.formParam("email", data.get("email")).formParam("description", data.get("description"))
//				.post(config.getProperty("customerAPIEndPoint"));
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		
		ExtentListeners.testReport.get().info(data.toString());
			///ExtentListeners.testReport.get().log(Status.INFO, data.toString());
		
		response.prettyPrint();		
		System.out.println(response.statusCode());		
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data)
	{
//		Response response = given().auth().basic(config.getProperty("inValidSecretKey"), "")
//				.formParam("email", "sharookh@gmail.com")
//				.formParam("description", "Coustomer user")
////				.post("https://api.stripe.com/v1/customers");
//				.post(config.getProperty("customerAPIEndPoint"));
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		
		response.prettyPrint();		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);
	}

}
