package com.example.mobile_programming.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`column`")
    private Long column;

    private  String start;

    private  String end;

}
