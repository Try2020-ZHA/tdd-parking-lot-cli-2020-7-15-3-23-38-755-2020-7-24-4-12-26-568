package com.oocl.cultivation;

import java.util.*;

public class SuperParkingBoy extends ParkingBoy {
    private List<String> parkingLotsId;
    private List<Integer> howManyCarsNow;
    private List<Integer> maxContain;
    public SuperParkingBoy(){
        parkingLotsId=new ArrayList<>();
        howManyCarsNow=new ArrayList<>();
        maxContain=new ArrayList<>();
    }

    public void addParkingLots(String id,int num,int maxContain){
        parkingLotsId.add(id);
        howManyCarsNow.add(num);
        this.maxContain.add(maxContain);
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
        double maxLotContainRate=1.0;
        for(int i=0;i<parkingLotsId.size();i++){
            if((double)howManyCarsNow.get(i)/(double)maxContain.get(i)<maxLotContainRate){
                maxLotContainRate=(double)howManyCarsNow.get(i)/(double)maxContain.get(i);
                id=parkingLotsId.get(i);
            }
        }
        return new TicketAndParkingLotId(id,ticket);
    }
}
