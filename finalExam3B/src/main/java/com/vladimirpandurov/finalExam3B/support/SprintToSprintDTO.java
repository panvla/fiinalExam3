package com.vladimirpandurov.finalExam3B.support;

import com.vladimirpandurov.finalExam3B.domain.Sprint;
import com.vladimirpandurov.finalExam3B.dto.SprintDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SprintToSprintDTO implements Converter<Sprint, SprintDTO> {

    @Override
    public SprintDTO convert(Sprint sprint) {
        if(sprint == null){
            return null;
        }

        SprintDTO dto = new SprintDTO();
        dto.setId(sprint.getId());
        dto.setName(sprint.getName());
        dto.setTotalPoints(sprint.getTotalPoints());

        return dto;
    }

    public List<SprintDTO> convert(List<Sprint> sprintList){
        List<SprintDTO> dtoList = new ArrayList<>();
        for(Sprint sprint : sprintList){
            dtoList.add(convert(sprint));
        }
        return dtoList;
    }
}
