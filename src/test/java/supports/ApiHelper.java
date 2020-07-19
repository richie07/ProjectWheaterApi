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

    public Response getWeatherXY(String url,Float latitud,Float longitud,String key){
        Response response = given()
                .param("lat",latitud)
                .param("lon",longitud)
                .param("appid",key)
                .when()
                .get(url);

        return response;

    }


}
