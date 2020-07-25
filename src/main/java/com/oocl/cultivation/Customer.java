package com.oocl.cultivation;

public class Customer {
    private String message;
    private Ticket ticket;
    private ParkingBoy parkingBoy;
    public Customer(Ticket ticket,ParkingBoy parkingBoy){
        this.ticket=ticket;
        this.parkingBoy=parkingBoy;
        this.parkingBoy.attach(this);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
