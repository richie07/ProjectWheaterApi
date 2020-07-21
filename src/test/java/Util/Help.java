package Util;

import supports.requestRegresIn;
import supports.requestWeather;

import java.util.stream.Stream;

public class Help {

    //HelpWeather

    public String getRequest(String requestName){
        return requestWeather.responseUser.then()
                .extract()
                .path(requestName);
    }

    public Integer getRequestInt(String requestName){
        return requestWeather.responseUser.then()
                .extract()
                .path(requestName);
    }

    public Float getRequestFloat(String requestName){
        return requestWeather.responseUser.then()
                .extract()
                .path(requestName);
    }


    //Help RegresIn
    public String getRequestRegresIn(String requestName){
        return requestRegresIn.responseUser.then()
                .extract()
                .path(requestName);
    }

    public String getExtractFormatTime(String date){
        return Stream.of(date)
                .map(x -> x.substring(0,16))
                .findFirst()
                .toString();
    }

}
