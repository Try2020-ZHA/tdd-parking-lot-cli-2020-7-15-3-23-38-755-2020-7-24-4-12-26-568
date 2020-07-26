package com.oocl.cultivation;

public class TicketAndParkingLotId {
    private String parkingLotId;
    private Ticket ticket;

    public TicketAndParkingLotId(String id,Ticket ticket){
        this.parkingLotId=id;
        this.ticket=ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }
}
