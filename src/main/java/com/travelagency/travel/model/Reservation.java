package com.travelagency.travel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"reservation\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id_reservation;

    @Column(nullable = false)
    private int nbr_person;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name="id_travel")
    private Travel travel;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name="id_user")
    private User user;

    @ManyToMany
    @JoinTable( name = "subscribe",
            joinColumns = @JoinColumn( name = "id_reservation" ),
            inverseJoinColumns = @JoinColumn( name = "id_activity" ) )
    private Set<Activity> activities = new HashSet<>();
}
