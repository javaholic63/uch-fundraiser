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
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Donation> donations = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bidder_id", referencedColumnName = "bidderId")
    private Bidder bidder;


    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal bidPrice;

    @Column(nullable = false)
    private BigDecimal cost;

    @CreationTimestamp
    @Column(name="timestamp", nullable = false, updatable = true, insertable = true)
    private Timestamp timestamp;


}
