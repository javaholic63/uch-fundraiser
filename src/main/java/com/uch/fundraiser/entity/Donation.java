package com.uch.fundraiser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donations")
    public class Donation {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long donationId;

        @Column(nullable = false)
        private String donor;

        @Column(nullable = false)
        private String description;

        @Column(nullable = false)
        private Integer quantity;

        @Column(nullable = false)
        private BigDecimal askPrice;

        @CreationTimestamp
        @Column(name="timestamp", nullable = false, updatable = true, insertable = true)
        private Timestamp timestamp;


}
