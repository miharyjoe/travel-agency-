package com.travelagency.travel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"activity\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id_activity;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int nbr_place;

    @ManyToMany
    @JoinTable( name = "subscribe",
            joinColumns = @JoinColumn( name = "id_activity" ),
            inverseJoinColumns = @JoinColumn( name = "id_reservation" ) )
    private Set<Reservation> reservation = new HashSet<>();


}
