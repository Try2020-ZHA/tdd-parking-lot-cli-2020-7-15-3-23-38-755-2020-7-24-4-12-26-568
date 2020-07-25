package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Customer;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_boy_park_the_car_given_a_car() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Car car=new Car("car001");
        //when
        Ticket ticket=parkingBoy.parkCar(car,"001");
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_a_ticket(){
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.parkCar(new Car("car001"),"001");
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
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.parkCar(new Car("car001"),"001");
        //when
        Car car=parkingBoy.fetchCar(ticket);
        car=parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_return_null_when_parking_car_and_no_position_given_a_car(){
        //given
        Car car=new Car("car001");
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        parkingBoy.setPosition(10);
        Ticket ticket=parkingBoy.parkCar(car,"001");
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_null_when_parking_a_car_given_a_parked_car(){
        //given
        Car car=new Car("car001");
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Ticket ticket=parkingBoy.parkCar(car,"001");
        Car car1=new Car("car001");
        Ticket ticket1=parkingBoy.parkCar(car1,"002");
        //then
        Assertions.assertNull(ticket1);
    }

    @Test
    void should_provide_error_message_when_fetch_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.parkCar(new Car("car001"),"001");
        Ticket ticket1=new Ticket("002","car002");
        Customer customer=new Customer(ticket,parkingBoy);
        Customer customer1=new Customer(ticket1,parkingBoy);
        //when
        Car car=parkingBoy.fetchCar(ticket);
        car=parkingBoy.fetchCar(ticket);
        Car car1=parkingBoy.fetchCar(ticket1);
        //then
        Assertions.assertEquals("Unrecognized parking ticket.",customer.getMessage());
        Assertions.assertEquals("Unrecognized parking ticket.",customer1.getMessage());
    }

    @Test
    void should_provide_error_message_when_fetch_car_given_no_ticket(){
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=null;
        Customer customer=new Customer(ticket,parkingBoy);
        //when
        Car car=parkingBoy.fetchCar(ticket);
        car=parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertEquals("Please provide your parking ticket.",customer.getMessage());
    }

}
