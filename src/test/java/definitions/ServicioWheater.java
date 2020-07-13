package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ServicioWheater {
    Response resp;

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
        String requestCiudad = resp.then()
                .extract()
                .path("name");

         Assert.assertEquals(ciudad,requestCiudad);
    }

    @And("response body show humidity as integer")
    public void responseBodyShowHumidityAsInteger() {
        Integer resquestHumidity = resp.then()
                .extract()
                .path("main.humidity");

        Assert.assertTrue(resquestHumidity > 0);
        Assert.assertTrue(resquestHumidity < 100);
        Assert.assertTrue((resquestHumidity.toString().matches("[0-9]+")));
    }

    @And("response body show weather as description")
    public void responseBodyShowWeatherAsDescription() {
        String resquestWeather = resp.then()
                .extract()
                .path("weather[0].main");
        Assert.assertTrue(resquestWeather.matches("[a-zA-Z]+"));
    }

    @When("user calls http request")
    public void userCallsHttpRequest() {
    }
}
