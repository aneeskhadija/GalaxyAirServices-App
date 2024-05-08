package com.softtech.galaxyairservices.WebServices;

import com.softtech.galaxyairservices.Models.GetterSetter;

import java.util.List;

public class InstallmentResponse {

   private String message;
    private List<GetterSetter> payment;

    public InstallmentResponse(String message, List<GetterSetter> payment) {
        this.message = message;
        this.payment = payment;
    }

    public String getMessage() {
        return message;
    }

    public List<GetterSetter> getPayment() {
        return payment;
    }
}
