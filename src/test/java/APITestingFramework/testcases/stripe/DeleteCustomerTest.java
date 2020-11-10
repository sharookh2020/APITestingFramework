package APITestingFramework.testcases.stripe;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;


import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import APITestingFramework.APIs.stripe.DeleteCustomerAPI;
import APITestingFramework.listeners.ExtentListeners;
import APITestingFramework.setUp.BaseTest;
import APITestingFramework.utilities.DataUtil;
import APITestingFramework.utilities.TestUtil;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class DeleteCustomerTest extends BaseTest{
  
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
  public void deleteCustomer(Hashtable<String, String> data) {
	  

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		
		System.out.println(response.statusCode());
		
	/*	String actual_id = response.jsonPath().get("id").toString();
		
		System.out.println("Getting id from Json path : "+actual_id);
		
		
		Assert.assertEquals(actual_id, data.get("id"),"ID not matching");
		
		*/
		
		
		/*JSONObject jsonObject = new JSONObject(response.asString());
		System.out.println(jsonObject.has("id"));
		Assert.assertTrue(jsonObject.has("id"),"ID key is not present in the JSON response");
	*/	
		
		
		System.out.println("Presence check for Object Key : "+TestUtil.jsonHasKey(response.asString(), "object"));
		System.out.println("Presence check for Deleted Key : "+TestUtil.jsonHasKey(response.asString(), "deleted"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID key is not present in the JSON response");
		
		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
		System.out.println(actual_id);
		Assert.assertEquals(actual_id, data.get("id"),"ID not matching");
		
		System.out.println("Object key value is : "+TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted key value is : "+TestUtil.getJsonKeyValue(response.asString(), "deleted"));
		
		
		Assert.assertEquals(response.statusCode(), 200);
	  
  }
}
