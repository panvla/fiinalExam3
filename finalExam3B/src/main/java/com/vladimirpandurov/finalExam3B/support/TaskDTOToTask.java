package com.vladimirpandurov.finalExam3B.support;

import com.vladimirpandurov.finalExam3B.domain.Sprint;
import com.vladimirpandurov.finalExam3B.domain.State;
import com.vladimirpandurov.finalExam3B.domain.Task;
import com.vladimirpandurov.finalExam3B.dto.TaskDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDTOToTask implements Converter<TaskDTO, Task> {


    @Override
    public Task convert(TaskDTO taskDTO) {
        Task task = new Task();
        if(!(taskDTO.getId() == null)){
            task.setId(taskDTO.getId());
        }
        task.setName(taskDTO.getName());
        task.setSubscribers(taskDTO.getSubscribers());
        task.setPoints(taskDTO.getPoints());
        Sprint sprint = new Sprint();
        sprint.setId(taskDTO.getSprintId());
        sprint.setName(taskDTO.getSprintName());
        task.setSprint(sprint);
        State state = new State();
        state.setId(taskDTO.getStateId());
        state.setName(taskDTO.getStateName());
        task.setState(state);
        return task;
    }

    public List<Task> convert(List<TaskDTO> dtoList){
        List<Task> taskList = new ArrayList<>();
        for(TaskDTO dto : dtoList){
            taskList.add(convert(dto));
        }
        return taskList;
    }
}
