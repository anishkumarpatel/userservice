package com.scaler.user.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private Long userId;
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
