package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import supports.requestWeather;
import supports.requestWeatherXY;

public class ServicioWheater {
    requestWeather weather;
    requestWeatherXY weatherXY;

    public ServicioWheater() {
        weather = new requestWeather();
        weatherXY = new requestWeatherXY();
    }

    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int statuscode) {
        Assert.assertEquals(statuscode,weather.getStatus() );

    }


    @Given("get place en el service {string} , {string}")
    public void getPlaceEnElService(String ciudad, String appid) {
        weather.getCiudad(ciudad,appid);
    }

    @And("response body as {string}")
    public void responseBodyAs(String ciudad) {

         Assert.assertEquals(ciudad,weather.getRequestCiudad());
    }

    @And("response body show humidity as integer")
    public void responseBodyShowHumidityAsInteger() {
        Assert.assertTrue(weather.getRequestHumedad() > 0);
        Assert.assertTrue(weather.getRequestHumedad() < 100);
        Assert.assertTrue((weather.getRequestHumedad().toString().matches("[0-9]+")));
    }

    @And("response body show weather as description")
    public void responseBodyShowWeatherAsDescription() {
        Assert.assertTrue(weather.getRequestWeather().matches("[a-zA-Z]+"));
    }

    @When("user calls http request")
    public void userCallsHttpRequest() {

    }

    @And("response body show {string} like the previos query")
    public void responseBodyShowCiudadLikeThePreviosQuery(String ciudad) {
        Assert.assertEquals(ciudad, weatherXY.getRequestCiudad());

    }

    @And("response body show humidity like the previos query")
    public void responseBodyShowHumidityLikeThePreviosQuery() {
        Assert.assertEquals(weather.getRequestHumedad(), weatherXY.getRequestHumedad());
    }

    @And("response body show weather like the previos query")
    public void responseBodyShowWeatherLikeThePreviosQuery() {
        Assert.assertEquals(weather.getRequestWeather(), weatherXY.getRequestWeather());

    }

    @Given("enter coordinates of {string} de {string}")
    public void enterCoordinatesOfDe(String ciudad, String appid) {
        weatherXY.getXY(weather.getRequestLatitud(),weather.getRequestLongitud(),appid);
    }

    @Then("the API call geographic coordinates got success with status code {int}")
    public void theAPICallGeographicCoordinatesGotSuccessWithStatusCode(int statuscode) {
        Assert.assertEquals(statuscode,weatherXY.getStatus());
    }
}
