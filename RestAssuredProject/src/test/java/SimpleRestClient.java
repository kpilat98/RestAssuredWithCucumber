
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleRestClient {

    // Base URL for the API
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static void main(String[] args) {
        // Initialize RestAssured
        RestAssured.baseURI = BASE_URL;

        // Simple GET request
        //getExample();
        getFindByStatus("available");
        getFindByStatus("sold");
        getFindByStatus("pending");

        // Simple POST request
        postExample();
        getExample();
    }

    private static void getExample() {
        // Prepare the request
        RequestSpecification request = RestAssured.given();

        // Send the request and get the response
        Response response = request.get("pet/333444555");

        // Extract and print the response body
        String responseBody = response.getBody().asString();
        System.out.println("GET Response: " + responseBody);
    }

    private static void postExample() {
        // Prepare the request body (in this case, it's a JSON payload)
        String rawJson = """
            {
              "id": 333444555,
              "category": {
                "id": 0,
                "name": "kot"
              },
              "name": "XDDDD pies",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "available"
            }
            """;        
        String requestBody = "{ \"id\": 21376925, \"category\": { \"id\": 0, \"name\": \"xD\" }, \"name\": \"xD\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\" }";
          


        // Prepare the request
        RequestSpecification request = RestAssured.given().body(rawJson).contentType("application/json");

        // Send the request and get the response
        Response response = request.post("/pet");

        // Extract and print the response body
        String responseBody = response.getBody().asString();
        System.out.println("POST Response: " + responseBody + response.getStatusCode());
    }

    private static void getFindByID(int id){
getRequest("pet/"+id);
    }

    private static void getFindByStatus(String status){
  getRequest("pet/findByStatus?status="+status);
    }

    private static void getRequest(String url){
      RequestSpecification request = RestAssured.given();
      Response response = request.get(url);
      String responseBody = response.getBody().asString();
      System.out.println("GET Response: " + responseBody); 
    }



}
