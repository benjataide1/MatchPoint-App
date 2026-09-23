package com.app.matchpoint.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PadelCourt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_court;
    private String type_court;

    @OneToMany(mappedBy = "court")
    private List<Reservation> reservations;
}
