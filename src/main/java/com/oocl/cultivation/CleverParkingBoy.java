package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CleverParkingBoy extends ParkingBoy {private HashMap<String, Integer> parkingLots;
    public CleverParkingBoy(){
        parkingLots=new HashMap<>();
    }

    public void addParkingLots(String id,int num){
        parkingLots.put(id,num);
    }

    public TicketAndParkingLotId parkTheCar(Car car,String token) {
        Ticket ticket=new Ticket(token,car.getCarId());
        if(position<10&&car!=null&&!isAParkedCar(car)){
            ticketAndCar.put(token,car);
            tickets.add(ticket);
        }else {
            ticket=null;
            notifyTheCustomer(ticket,"Not enough position.");
        }
        String id="";
        Set<String> keys=parkingLots.keySet();
        Iterator<String> iterator1=keys.iterator();
        int maxLotcontain=10;
        while (iterator1.hasNext()){
            String temp=iterator1.next();
            if(parkingLots.get(temp)<maxLotcontain){
                id=temp;
            }
        }
        return new TicketAndParkingLotId(id,ticket);
    }
}
