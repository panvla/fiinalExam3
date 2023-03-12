package com.vladimirpandurov.finalExam3B.service;

import com.vladimirpandurov.finalExam3B.domain.Sprint;
import com.vladimirpandurov.finalExam3B.domain.State;
import com.vladimirpandurov.finalExam3B.domain.Task;
import com.vladimirpandurov.finalExam3B.dto.TaskDTO;
import com.vladimirpandurov.finalExam3B.repository.SprintRepository;
import com.vladimirpandurov.finalExam3B.repository.StateRepository;
import com.vladimirpandurov.finalExam3B.repository.TaskRepository;
import com.vladimirpandurov.finalExam3B.support.TaskDTOToTask;
import com.vladimirpandurov.finalExam3B.support.TaskToTaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final SprintRepository sprintRepository;
    private final StateRepository stateRepository;
    private final TaskToTaskDTO taskToTaskDTO;
    private final TaskDTOToTask taskDTOToTask;

    public TaskDTO findOne(Long id){
        Task task = this.taskRepository.getById(id);
        return this.taskToTaskDTO.convert(task);
    }

    public TaskDTO update(TaskDTO dto){

        Task task = this.taskRepository.getById(dto.getId());
        Task convertedTask = this.taskDTOToTask.convert(dto);
        task.setName(convertedTask.getName());
        task.setSubscribers(convertedTask.getSubscribers());
        Sprint sprint = this.sprintRepository.getById(convertedTask.getSprint().getId());
        if(!sprint.getId().equals(task.getSprint().getId())){
            task.getSprint().deleteTask(task);
            sprint.addTask(task);
        }
        if(task.getPoints() != convertedTask.getPoints()){
            Integer totalPoints = task.getSprint().getTotalPoints();
            totalPoints = totalPoints - task.getPoints() + convertedTask.getPoints();
            task.getSprint().setTotalPoints(totalPoints);
        }
        State state = this.stateRepository.getById(task.getState().getId());
        if(!state.getId().equals(convertedTask.getState().getId())){
            state.deleteTask(task);
            State newState = this.stateRepository.getById(convertedTask.getState().getId());
            newState.addTask(task);
        }
        this.sprintRepository.save(sprint);


    }

    public TaskDTO save(TaskDto dto){

    }

}
