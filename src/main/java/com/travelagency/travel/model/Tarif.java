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
@Table(name = "\"tarif\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tarif implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id_tarif;

    @Column(nullable = false)
    private double price;

    private double promo;

    @ManyToMany
    @JoinTable( name = "cost",
            joinColumns = @JoinColumn( name = "id_tarif" ),
            inverseJoinColumns = @JoinColumn( name = "id_travel" ) )
    private Set<Travel> travel = new HashSet<>();
}
