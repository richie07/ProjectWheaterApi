package Util;

import supports.requestWeather;

public class Help {

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
}
