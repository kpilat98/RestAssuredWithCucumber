
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class CommonRequests {


    public Response sendGETandRecieveResponse(String url){
        RequestSpecification request = new RestAssured().given();
        Response resposne = request.get(url);
        return resposne;
    }
    public Response sendGETWithQueryParamandRecieveResponse(String url, String queryParamName,String queryParamValue){
        RequestSpecification request = new RestAssured().given().queryParam(queryParamName,queryParamValue);
        Response resposne = request.get(url);
        return resposne;
    }
    public Response sendGETWithMultipleQueryandRecieveResponse(String url, Map<String,String> queryParams){
        RequestSpecification request = new RestAssured().given().queryParams(queryParams);
        Response resposne = request.get(url);
        return resposne;
    }
    public Response sendPOSTandRecieveResponse(String url, ContentType contentType, String reequestBody){
        RequestSpecification request = new RestAssured().given().body(reequestBody).contentType(contentType);
        Response resposne = request.post(url);
       return resposne;
    }
    public Response sendDELETEandRecieveResponse(String url){
        RequestSpecification request = new RestAssured().given();
        Response response = request.delete(url);
        return response;
    }
    public Response sendPUTandRecieveResponse(String url, String requestBody, ContentType contentType){
        RequestSpecification request = new RestAssured().given().body(requestBody).contentType(contentType);
        Response resposne = request.put(url);
        return resposne;
    }

    }
