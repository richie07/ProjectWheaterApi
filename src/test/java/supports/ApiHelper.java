package supports;

import io.restassured.http.ContentType;
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

    public Response postApiRegresIn(String url, String name, String job){
        Response response = given()
                .body("{\n" +
                        "    \"name\": \""+name+"\",\n" +
                        "    \"job\": \""+job+"\"\n" +
                        "}")
                .when()
                .post(url);

        return response;
    }

    public Response putApiRegrein(String url, String name, String job){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \""+name+"\",\n" +
                        "    \"job\": \""+job+"\"\n" +
                        "}")
                .when()
                .put(url);

        return response;
    }


}
