package com.edu.ijse.print_shop.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTm {
    private String customer_ID;
    private String name;
    private String address;
    private String email;
    private String contact;
}
