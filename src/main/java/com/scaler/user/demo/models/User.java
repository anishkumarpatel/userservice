package com.scaler.user.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String number;
    private String zipcode;
    private String latitude;
    private String longitude;
    private String phone;
}
