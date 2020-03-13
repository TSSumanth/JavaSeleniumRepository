package BasicTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredExamples { 
	
	public static void main(String[] args) 
	{

		  firstGet("http://indl125006.in.oracle.com:7011/fscmRestApi/resources/11.13.18.05/projects");
		
	}
	
	public static void firstGet(String URL)
	{
		Response res = RestAssured.get(URL);
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
	}

}
