package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingBoy {
    private int position;
    private HashMap<String,Car> ticketAndCar;
    private List<Customer> customers ;
    private List<Ticket> tickets ;
    public ParkingBoy(){
        ticketAndCar=new HashMap<>();
        customers=new ArrayList<Customer>();
        tickets= new ArrayList<Ticket>();
        position=0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Ticket parkCar(Car car,String token) {
        Ticket ticket=new Ticket(token,car.getCarId());
        if(position<10&&car!=null&&!isAParkedCar(car)){
            ticketAndCar.put(token,car);
            tickets.add(ticket);
            return ticket;
        }
        ticket=null;
        notifyTheCustomer(ticket,"Not enough position.");
        return ticket;
    }

    public Car fetchCar(Ticket ticket){
        if(ticket!=null&&!ticket.isUsed()){
            if(ticketAndCar.containsKey(ticket.getToken())){
                ticket.setUsed();
                return ticketAndCar.get(ticket.getToken());
            }
        }
        if(ticket!=null&&(ticket.isUsed()||!isExistTicket(ticket))){
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
            if(customer!=null&&(ticket==null||ticket.getToken().equals(customer.getTicket().getToken()))){
                customer.setMessage(message);
                return;
            }
        }
    }

    public void notifyTheCustomer(Customer customer,String message){
        customer.setMessage(message);
    }

    public boolean isAParkedCar(Car car){
        return ticketAndCar.containsValue(car);
    }

    public boolean isExistTicket(Ticket ticket){
        return tickets.contains(ticket);
    }
}
