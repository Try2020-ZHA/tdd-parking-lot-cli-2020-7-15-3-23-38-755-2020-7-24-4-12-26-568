package com.oocl.cultivation;

public class Ticket {
    private String token;
    private String carId;

    public Ticket(String token,String carId){
        this.carId=carId;
        this.token=token;
    }

    public String getCarId() {
        return carId;
    }
}
