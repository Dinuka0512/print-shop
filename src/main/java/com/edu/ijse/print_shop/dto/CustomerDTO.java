package com.edu.ijse.print_shop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String customer_ID;
    private String name;
    private String address;
    private String email;
    private String contact;
}
