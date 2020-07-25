package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {
    private int position;
    private HashMap<String,String> ticketAndCar;
    public ParkingBoy(){
        ticketAndCar=new HashMap<>();
        position=0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Ticket parkCar(Car car,String token) {
        if(position<10&&car!=null&&!isAParkedCar(token)){
            ticketAndCar.put(token,car.getCarId());
            return new Ticket(token,car.getCarId());
        }
        return null;
    }

    public Car fetchCar(Ticket ticket){
        if(ticket!=null&&!ticket.isUsed()){
            if(ticketAndCar.containsKey(ticket.getToken())){
                ticket.setUsed();
                return new Car(ticketAndCar.get(ticket.getToken()));
            }
        }
        return null;
    }

    public boolean isAParkedCar(String token){
        return ticketAndCar.containsKey(token);
    }
}
