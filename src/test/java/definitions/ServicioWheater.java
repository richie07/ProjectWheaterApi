package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class ServicioWheater {
    Response resp,respCooord;
    String requestCiudad, requestCiudadXY;
    Integer requestHumidity,requestHumidityXY;
    String requestWeather,requestWeatherXY;
    Float latitud,longitud;

    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int statuscode) {
        Assert.assertEquals(resp.getStatusCode(), statuscode);

    }


    @Given("get place en el service {string} , {string}")
    public void getPlaceEnElService(String ciudad, String appid) {
        resp= given()
                .param("q", ciudad)
                .param("appid",appid)
                .when()
                .get("https://openweathermap.org/data/2.5/weather");
    }

    @And("status is response body is {string}")
    public void statusIsResponseBodyIs(String arg0) {
    }

    @And("response body as {string}")
    public void responseBodyAs(String ciudad) {
         requestCiudad = resp.then()
                .extract()
                .path("name");

         Assert.assertEquals(ciudad,requestCiudad);
    }

    @And("response body show humidity as integer")
    public void responseBodyShowHumidityAsInteger() {
        requestHumidity = resp.then()
                .extract()
                .path("main.humidity");

        Assert.assertTrue(requestHumidity > 0);
        Assert.assertTrue(requestHumidity < 100);
        Assert.assertTrue((requestHumidity.toString().matches("[0-9]+")));
    }

    @And("response body show weather as description")
    public void responseBodyShowWeatherAsDescription() {
        requestWeather = resp.then()
                .extract()
                .path("weather[0].main");
        Assert.assertTrue(requestWeather.matches("[a-zA-Z]+"));
    }

    @When("user calls http request")
    public void userCallsHttpRequest() {

    }

    @And("response body show {string} like the previos query")
    public void responseBodyShowCiudadLikeThePreviosQuery(String ciudad) {
        requestCiudadXY  = respCooord.then()
                .extract()
                .path("name");
        Assert.assertEquals(ciudad,requestCiudadXY);

    }

    @And("response body show humidity like the previos query")
    public void responseBodyShowHumidityLikeThePreviosQuery() {
        requestHumidityXY  = respCooord.then()
                .extract()
                .path("main.humidity");

        Assert.assertEquals(requestHumidityXY,requestHumidity);

    }

    @And("response body show weather like the previos query")
    public void responseBodyShowWeatherLikeThePreviosQuery() {
       String requestWeatherXY  = respCooord.then()
                .extract()
                .path("weather[0].main");
        Assert.assertEquals(requestWeatherXY,requestWeather);

    }

    @Given("enter coordinates of {string} de {string}")
    public void enterCoordinatesOfDe(String ciudad, String appid) {

        resp= given()
                .param("q", ciudad)
                .param("appid",appid)
                .when()
                .get("https://openweathermap.org/data/2.5/weather");

        latitud = resp.then()
                .extract()
                .path("coord.lat");

        longitud = resp.then()
                .extract()
                .path("coord.lon");

        requestCiudad = resp.then()
                .extract()
                .path("name");

        requestWeather = resp.then()
                .extract()
                .path("weather[0].main");

        requestHumidity = resp.then()
                .extract()
                .path("main.humidity");

        respCooord = given()
                .param("lat", latitud)
                .param("lon",longitud)
                .param("appid",appid)
                .when()
                .get("https://openweathermap.org/data/2.5/weather");

    }

    @Then("the API call geographic coordinates got success with status code {int}")
    public void theAPICallGeographicCoordinatesGotSuccessWithStatusCode(int statuscode) {
        Assert.assertEquals(respCooord.getStatusCode(), statuscode);
    }
}
