package com.generali.burritoorderingservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Enumerated(EnumType.STRING)
    private Tortilla tortilla;

    @Enumerated(EnumType.STRING)
    private Protein protein;

    @Enumerated(EnumType.STRING)
    private Salsa salsa;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade ={CascadeType.PERSIST, CascadeType.ALL},
            orphanRemoval = true
    )
    private Set<Vegetable> vegetables = new HashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade ={CascadeType.PERSIST, CascadeType.ALL},
            orphanRemoval = true
    )
    private Set<Extras> extras = new HashSet<>();

    @CreationTimestamp
    private Date creationDate;

    @CreationTimestamp
    private Date lastUpdateDate;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", tortilla=" + tortilla +
                ", protein=" + protein +
                ", salsa=" + salsa +
                ", vegetables=" + vegetables +
                ", extras=" + extras +
                '}';
    }
}

