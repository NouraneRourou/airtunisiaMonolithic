package com.example.airtunisia.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column( name = "price")
    private String price;

    @Column( name = "classType")
    private String classType;

    @Column( name = "date")
    private String date;

    @Column( name = "passengerFirstName")
    private String passengerFirstName;

    @Column( name = "passengerLastName")
    private String passengerLastName;

    @Column( name = "cin")
    private long cin;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = true)
    private Flight flight;


}
