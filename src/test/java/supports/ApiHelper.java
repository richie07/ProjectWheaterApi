package supports;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiHelper {
    public Response getWeather(String url,String ciudad,String key){
        Response response = given()
                .param("q",ciudad)
                .param("appid",key)
                .when()
                .get(url);

        return response;

    }


}
