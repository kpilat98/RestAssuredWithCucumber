
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
enum Status{
    available,
    pending,
    sold
}


public class PetBaseTestStrategy extends CommonRequests{

    private  String BASE_URL;

    public PetBaseTestStrategy(String BASE_URL){
        this.BASE_URL = BASE_URL;
        RestAssured.baseURI = BASE_URL;
    }
    public Response getPetByID(String endPoint){
        return sendGETandRecieveResponse(endPoint);
    }
    public Response getPetByStatus(String endPoint,Status status){
        return sendGETandRecieveResponse(endPoint + "findByStatus?status=" + status);
    }
    public Response addNewPetToStore(String body, String url, ContentType contentType){
        return sendPOSTandRecieveResponse(url, contentType, body);
    }
    public Response deletePetFromStore(String endPoint){

        return sendDELETEandRecieveResponse(endPoint);
    }
    
}
