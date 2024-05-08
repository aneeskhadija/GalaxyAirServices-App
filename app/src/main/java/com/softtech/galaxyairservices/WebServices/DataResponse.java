package com.softtech.galaxyairservices.WebServices;

import com.softtech.galaxyairservices.Models.GetterSetter;

import java.util.List;

public class DataResponse {

    private String message;
    private List<GetterSetter>hotels;

    public DataResponse(String message, List<GetterSetter> hotels) {
        this.message = message;
        this.hotels = hotels;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetterSetter> getHotels() {
        return hotels;
    }

    public void setHotels(List<GetterSetter> hotels) {
        this.hotels = hotels;
    }
}
