package com.vladimirpandurov.finalExam3B.dto;

import lombok.Data;

@Data
public class TaskDTO {

    private Long id;
    private String name;
    private String subscribers;
    private Integer points;
    private Long sprintId;
    private String sprintName;
    private Long stateId;
    private String stateName;
}
