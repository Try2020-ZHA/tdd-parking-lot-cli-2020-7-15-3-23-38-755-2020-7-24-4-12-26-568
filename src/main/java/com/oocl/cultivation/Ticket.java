package com.oocl.cultivation;

public class Ticket {
    private String token;
    private String carId;
    private boolean isUsed;

    public Ticket(String token,String carId){
        this.carId=carId;
        this.token=token;
        isUsed=false;
    }

    public String getCarId() {
        return carId;
    }

    public String getToken(){
        return token;
    }

    public void setUsed(){
        this.isUsed=true;
    }

    public boolean isUsed() {
        return isUsed;
    }
}
