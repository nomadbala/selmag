package com.nmb.manager.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;

    private String title;

    private String details;
}
