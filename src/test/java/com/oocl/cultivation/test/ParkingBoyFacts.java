package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Customer;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_boy_park_the_car_given_a_car() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Car car=new Car();
        //when
        String ticket=parkingBoy.parkCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_a_ticket(){
        //given

    }
}
