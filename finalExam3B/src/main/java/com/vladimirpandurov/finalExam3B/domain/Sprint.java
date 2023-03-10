package com.vladimirpandurov.finalExam3B.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer totalPoints;
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    public void deleteTask(Task task){
        this.substratePoints(task.getPoints());
        this.tasks.remove(task);
        task.setSprint(null);
    }

    public void addTask(Task task){
        this.tasks.add(task);
        task.setSprint(this);
        this.addPoints(task.getPoints());
    }

    public void addPoints(Integer points){
        this.totalPoints += points;
    }

    public void substratePoints(Integer points){
        this.totalPoints -= points;
    }
}
