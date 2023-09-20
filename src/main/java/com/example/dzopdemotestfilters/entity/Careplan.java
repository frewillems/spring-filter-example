package com.example.dzopdemotestfilters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Careplan {

    enum  CareplanStatus {
        ACTIVE,
        PENDING,
        CLOSED,
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private CareplanStatus status;

    @OneToOne
    private User user;
}
