package com.oocl.cultivation;

import java.util.Objects;

public class Car {
    private String carId;
    public Car(String carId){
        this.carId=carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carId, car.carId);
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }
}
