package com.vladimirpandurov.finalExam3B.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList();

    public void addTask(Task task){
        if(!tasks.contains(task)){
            tasks.add(task);
        }
        task.setState(this);
    }

    public void deleteTask(Task task){
        if(tasks.contains(task)){
            tasks.remove(task);
        }
        task.setState(null);
    }
}
