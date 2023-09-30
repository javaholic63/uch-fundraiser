package com.uch.fundraiser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bidders")
public class Bidder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidderId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bidder_id", referencedColumnName = "bidderId")
    private Set<Purchase> purchases = new HashSet<>();

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean arrived;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(name="timestamp", nullable = false, updatable = true, insertable = true)
    private Timestamp timestamp;
}
