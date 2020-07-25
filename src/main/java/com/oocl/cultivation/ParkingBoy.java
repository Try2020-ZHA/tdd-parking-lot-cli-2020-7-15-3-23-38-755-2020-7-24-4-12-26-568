package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {
    private int position;
    public ParkingBoy(){
        position=0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Ticket parkCar(Car car) {
        if(position<10)
        return new Ticket("001",car.getCarId());
        return null;
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
