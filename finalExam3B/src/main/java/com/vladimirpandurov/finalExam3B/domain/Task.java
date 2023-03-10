package com.vladimirpandurov.finalExam3B.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subscribers;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
