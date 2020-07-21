package supports;

import Util.Help;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Stream;

public class requestRegresIn {
    ApiHelper apiHelper;
    Help help;
    public static Response responseUser;

    public requestRegresIn() {
        apiHelper = new ApiHelper();
        help = new Help();
    }

    public void addUser(String name, String job){
        String url = "https://reqres.in/api/users";
        responseUser = apiHelper.postApiRegresIn(url,name,job);
    }

    public void updateUser(String name, String job){
        String url = "https://reqres.in/api/users";
        responseUser = apiHelper.putApiRegrein(url,name,job);
    }

    public void walkUser(DataTable data){
        Map<String,String> lista = data.asMap(String.class,String.class);
        lista.forEach((n,j)-> addUser(n,j));

    }

    public int getStatus(){
        return responseUser.getStatusCode();
    }

    public String getResponseBodyName(){
        return help.getRequestRegresIn("name");

    }

    public String getResponseBodyJob(){
        return help.getRequestRegresIn("job");

    }

    public String getResponseBodyDate(){
        return  help.getExtractFormatTime(help.getRequestRegresIn("updatedAt"));

    }

    public String getSystemDateAzores(){
        ZoneId zoneAzores = ZoneId.of("Atlantic/Azores");
        ZonedDateTime nowAzores = ZonedDateTime.now ( zoneAzores );
        return  help.getExtractFormatTime(nowAzores.toString());
    }

}
