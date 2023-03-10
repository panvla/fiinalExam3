package com.vladimirpandurov.finalExam3B.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList();
}
