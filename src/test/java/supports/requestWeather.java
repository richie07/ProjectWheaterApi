package supports;

import Util.Help;
import io.restassured.response.Response;

public class requestWeather {
    ApiHelper apiHelper;
    Help help;
    public static Response responseUser;

    public requestWeather() {
        apiHelper = new ApiHelper();
        help = new Help();
    }

    public void getCiudad(String ciudad,String key){
        String url = "https://openweathermap.org/data/2.5/weather";
        responseUser = apiHelper.getWeather(url,ciudad,key);

    }

    public int getStatus(){
        return responseUser.getStatusCode();

    }

    public String getRequestCiudad(){
        return help.getRequest("name");
    }

    public Integer getRequestHumedad(){
        return help.getRequestInt("main.humidity");
    }

    public String getRequestWeather(){
        return help.getRequest("weather[0].main");
    }


}
