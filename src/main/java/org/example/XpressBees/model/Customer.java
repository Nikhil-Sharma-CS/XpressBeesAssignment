package org.example.XpressBees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {private String name;
    private String address;
    private String address2;
    private String city;
    private String pincode;
    private String state;
    private String country;
    private String email;
    private String phone;

}
