package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {
    public ParkingBoy(){

    }

    public String parkCar(Car car) {
        return "ticket";
    }

    public Car fetchCar(Ticket ticket){
        if(ticket!=null&&!ticket.isUsed()){
            if("001".equals(ticket.getToken())){
                ticket.setUsed();
                return new Car("car001");
            }
        }
        return null;
    }
}
