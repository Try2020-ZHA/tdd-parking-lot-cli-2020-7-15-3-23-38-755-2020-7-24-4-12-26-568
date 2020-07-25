package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_boy_park_the_car_given_a_car() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Car car=new Car("001");
        //when
        String ticket=parkingBoy.parkCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_a_ticket(){
        //given
        Ticket ticket=new Ticket("001","car001");
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Car car=parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertEquals(new Car("car001"),car);
    }

    @Test
    void should_return_null_when_fetch_car_given_a_wrong_ticket_or_given_no_ticket(){
        //given
        Ticket ticket=new Ticket("002","car002");
        Ticket ticket1=new Ticket(null,null);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Car car=parkingBoy.fetchCar(ticket);
        Car car1=parkingBoy.fetchCar(ticket1);
        //then
        Assertions.assertNull(car);
        Assertions.assertNull(car1);
    }

    @Test
    void should_return_null_when_fetch_car_given_a_used_ticket(){
        //given
        Ticket ticket=new Ticket("001","car001");
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.setUsedTicket(ticket);
        //when
        Car car=parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertNull(car);
    }
}
