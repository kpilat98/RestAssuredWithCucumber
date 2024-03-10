import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class TestScenario {
private Response response;
private final String BASE_URL = "https://petstore.swagger.io/v2";
PetBaseTestStrategy petBaseTestStrategy = new PetBaseTestStrategy(BASE_URL);            

@When("^User add new pet to the store with a custom (.+)$")
public void addPetToStore(String id){
    String body = String.format("""
        {
            "id": %s,
            "category": {
              "id": 0,
              "name": "string"
            },
            "name": "doggie",
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
            """,id);
            System.out.println(body);
response = petBaseTestStrategy.addNewPetToStore(body,"/pet",ContentType.JSON);
}
@Then("Check if the response code is 200 after post")
public void statusPPostValidation(){
  System.out.println(response.statusCode());
statusValidation(response);
}
@And("Check if the response body is same as request body")
public void responseBodyValidation(){

};


@When("^User calls created pet with (.+)$")
public void getPetWithId(String id){
  response=petBaseTestStrategy.getPetByID("/pet/"+id);
}


@Then("Resposne code is 200 after get")
public void statusGetValidation(){
statusValidation(response);
}
@And("^Pet attributes are the same as created one (.+)$")
public void getPetAttributesById(String id){
  response = petBaseTestStrategy.getPetByID("/pet/"+id);
  String resposnseBody = response.getBody().asString();
  JsonObject jsonObject = JsonParser.parseString(resposnseBody).getAsJsonObject();
  petBaseTestStrategy.getPetByStatus("/pet/" , Status.sold);
  //GET id Under Category ID
  //JsonObject categoryObject = jsonObject.getAsJsonObject("category");



        // Extract the value of the "name" key
        String nameValue = jsonObject.get("id").getAsString();
        System.out.println(nameValue);
}
public void statusValidation(Response response){
    Assert.isTrue(response.statusCode()==200,"Status not 200, something wrong");

}
}
