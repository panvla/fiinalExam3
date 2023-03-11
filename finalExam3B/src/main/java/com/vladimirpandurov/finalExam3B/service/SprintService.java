package com.vladimirpandurov.finalExam3B.service;

import com.vladimirpandurov.finalExam3B.domain.Sprint;
import com.vladimirpandurov.finalExam3B.repository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintService {

    private final SprintRepository sprintRepository;

    public Sprint findOne(Long id){
        return this.sprintRepository.getById(id);
    }

    public List<Sprint> findAll(){
        return this.sprintRepository.findAll();
    }

    public Sprint save(Sprint sprint){
        return this.sprintRepository.save(sprint);
    }

    public Sprint  delete(Long id){
        Sprint sprint = this.findOne(id);
        if(sprint != null){
            this.sprintRepository.delete(sprint);
        }
        return sprint;
    }

}
