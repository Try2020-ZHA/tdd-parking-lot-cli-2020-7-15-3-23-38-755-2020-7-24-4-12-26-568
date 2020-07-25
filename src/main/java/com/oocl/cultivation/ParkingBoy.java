package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {
    private int position;
    private HashMap<String,Car> ticketAndCar;
    public ParkingBoy(){
        ticketAndCar=new HashMap<>();
        position=0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Ticket parkCar(Car car,String token) {
        if(position<10&&car!=null&&!isAParkedCar(car)){
            ticketAndCar.put(token,car);
            return new Ticket(token,car.getCarId());
        }
        return null;
    }

    public Car fetchCar(Ticket ticket){
        if(ticket!=null&&!ticket.isUsed()){
            if(ticketAndCar.containsKey(ticket.getToken())){
                ticket.setUsed();
                return ticketAndCar.get(ticket.getToken());
            }
        }
        return null;
    }

    public boolean isAParkedCar(Car car){
        return ticketAndCar.containsValue(car);
    }
}
