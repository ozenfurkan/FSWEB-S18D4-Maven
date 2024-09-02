package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Burger", schema = "s18-4")
public class Burger {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private double id;

        @Column(name = "name")
        private String name;

        @Column(name = "price")
        private double price;

        @Column(name = "is_vegan")
        private boolean IsVegan;

        @Column(name = "contents")
        private String contents;

        @Column(name = "bread_type")
        private BreadType breadType;
}
