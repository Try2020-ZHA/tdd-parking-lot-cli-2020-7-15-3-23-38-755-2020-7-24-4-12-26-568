package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {
    public ParkingBoy(){

    }

    public String parkCar(Car car) {
        return "ticket";
    }

    public Car fetchCar(Ticket ticket){
        if(ticket!=null){
            if(ticket.getToken().equals("001"))
                return new Car("car001");
        }
        return null;
    }
}
