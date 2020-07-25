package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingBoy {
    private int position;
    private HashMap<String,Car> ticketAndCar;
    private List<Customer> customers = new ArrayList<Customer>();
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
        if(ticket!=null&&ticket.isUsed()){
            notifyTheCustomer(ticket,"Unrecognized parking ticket.");
        }
        if(ticket==null){
            notifyTheCustomer(ticket,"Please provide your parking ticket.");
        }
        return null;
    }

    public void attach(Customer customer){
        customers.add(customer);
    }

    public void notifyTheCustomer(Ticket ticket,String message){
        for (Customer customer : customers) {
            if(customer.getTicket().getToken().equals(ticket.getToken())){
                customer.setMessage(message);
            }
        }
    }

    public boolean isAParkedCar(Car car){
        return ticketAndCar.containsValue(car);
    }
}
