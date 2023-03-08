package com.example.demobean.model;

import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("user")
public class User {
    private String name;
    private Vehicle vehicle;

    public User() {
//        vehicle = new Motorbike();
        this.name = "hien";
    }

    public User(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void goToSchool() {
        vehicle.run();
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Motorbike();
        Vehicle vehicle2 = new Bus();

        User user = new User(vehicle1);
        user.setVehicle(vehicle2);
    }
}
