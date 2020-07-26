package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
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

    @Test
    void should_provide_error_message_when_parking_car_given_no_position(){
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.setPosition(10);
        //when
        Ticket ticket=parkingBoy.parkCar(new Car("car001"),"001");
        Customer customer=new Customer(ticket,parkingBoy);
        //then
        Assertions.assertEquals("Not enough position.",customer.getMessage());
    }

    @Test
    void should_return_first_parking_lot_when_park_a_car_given_stupid_parking_boy(){
        //given
        StupidParkingBoy stupidParkingBoy=new StupidParkingBoy();
        Car car=new Car("car001");
        stupidParkingBoy.addParkingLots("lot002",5);
        stupidParkingBoy.addParkingLots("lot001",3);
        //when
        String parkingLotsId=stupidParkingBoy.parkTheCar(car,"001").getParkingLotId();
        //then
        Assertions.assertEquals("lot002",parkingLotsId);
    }

    @Test
    void should_return_fewer_contain_parking_lot_when_park_a_car_given_clever_parking_boy(){
        //given
        CleverParkingBoy cleverParkingBoy=new CleverParkingBoy();
        Car car=new Car("car001");
        cleverParkingBoy.addParkingLots("lot002",5);
        cleverParkingBoy.addParkingLots("lot001",3);
        cleverParkingBoy.addParkingLots("lot003",1);
        //when
        String parkingLotsId=cleverParkingBoy.parkTheCar(car,"001").getParkingLotId();
        //then
        Assertions.assertEquals("lot003",parkingLotsId);
    }

    @Test
    void should_return_large_available_rate_parking_lot_when_park_a_car_given_super_parking_boy(){
        //given
        SuperParkingBoy superParkingBoy=new SuperParkingBoy();
        Car car=new Car("car001");
        superParkingBoy.addParkingLots("lot002",5);
        superParkingBoy.addParkingLots("lot001",3);
        superParkingBoy.addParkingLots("lot003",1);
        //when
        String parkingLotsId=superParkingBoy.parkTheCar(car,"001").getParkingLotId();
        //then
        Assertions.assertEquals("lot003",parkingLotsId);
    }

}
