package com.edu.ijse.print_shop.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String customer_ID;
    private String name;
    private String address;
    private String email;
    private String contact;
}
