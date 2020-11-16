package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GetAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	int statusCode;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		//https://reqres.in/api/users
		
		url = serviceUrl + apiUrl;
		
	}
	
	
	
	@Test(priority=1)
	@Given("^As a user I established connection with the serviceURL$")
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException{
		restClient = new RestClient();

		
		//a. Status Code:
	}
	@And ("^I hit url with request parameters$")
	public void hitURL() throws ClientProtocolException, IOException {
		closebaleHttpResponse = restClient.get(url);
	}
	@When ("^I get the response $")
		public void getResponse() throws ParseException, IOException
		{
		statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		}
	@Then("^ I validate the response $")
		public void validateResponse()
		{
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
		}

		//b. Json String:
		//String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		//JSONObject responseJson = new JSONObject(responseString);
		//System.out.println("Response JSON from API---> " +responseJson);
		
		//single value assertion:
	
//
//		//get the value from JSON ARRAY:
//		ing firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
//
//		
//		System.out.println(firstName);
		
		
		//c. All Headers
		Header[] headersArray =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();	
		
		for(Header header : headersArray){
			allHeaders.put(header.getName(), header.getValue());
		}	
		System.out.println("Headers Array-->"+allHeaders);
		
		
		
	

	
	
		
		
		
		//c. All Headers
		Header[] headersArray2 =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders1 = new HashMap<String, String>();	
		for(Header header1 : headersArray){
			allHeaders.put(header.getName(), header.getValue());
		}	
		System.out.println("-----Headers Array-->"+allHeaders);
		
		
		
	}
	
	
}
	
	
	
	
	
	

	


