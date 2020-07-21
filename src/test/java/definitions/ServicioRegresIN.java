package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import supports.requestRegresIn;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ServicioRegresIN {
    requestRegresIn regresIn;

    public ServicioRegresIN() {
        regresIn = new requestRegresIn();
    }

    @Given("add to the service")
    public void addToTheService(DataTable data) {
        regresIn.walkUser(data);

    }

    @Then("the API regresIN call got success with status code {int}")
    public void theAPIRegresINCallGotSuccessWithStatusCode(int codeStatus) {
        Assert.assertEquals(codeStatus,regresIn.getStatus());
    }

    @Given("add to the service {string} , {string}")
    public void addToTheService(String name, String job) {
        regresIn.updateUser(name,job);
    }

    @And("response body show {string} , {string}")
    public void responseBodyShow(String name, String job) {
        Assert.assertEquals(name,regresIn.getResponseBodyName());
        Assert.assertEquals(job,regresIn.getResponseBodyJob());
//        ResponseBody body = regresIn.responseUser.getBody();
//        System.out.print(body.asString());

    }

    @And("response body show created date")
    public void responseBodyShowCreatedDate() {
        Assert.assertEquals(regresIn.getSystemDateAzores(),regresIn.getResponseBodyDate());
        System.out.println(regresIn.getResponseBodyDate());
    }
}
