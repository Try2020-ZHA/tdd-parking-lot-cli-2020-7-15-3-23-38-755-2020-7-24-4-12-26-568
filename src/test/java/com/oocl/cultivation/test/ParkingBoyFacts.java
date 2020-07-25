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
}
