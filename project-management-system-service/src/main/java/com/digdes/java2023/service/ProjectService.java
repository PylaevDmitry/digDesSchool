package com.digdes.java2023.service;

import com.digdes.java2023.dto.project.EditProjectDto;
import com.digdes.java2023.dto.project.FindProjectDto;
import com.digdes.java2023.dto.project.ProjectDto;
import com.digdes.java2023.mapping.ProjectMapper;
import com.digdes.java2023.model.project.Project;
import com.digdes.java2023.model.project.ProjectStatus;
import com.digdes.java2023.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectDto create(EditProjectDto projectDto) {
        Project project = ProjectMapper.createEntity(projectDto);
        project.setProjectStatus(ProjectStatus.PREPARE);
        projectRepository.save(project);
        return ProjectMapper.mapFromEntity(project);
    }

    public ProjectDto edit(EditProjectDto projectDto) {
        Optional<Project> projectFromBase = projectRepository.findByCode(projectDto.getCode());
        if (projectFromBase.isPresent()) {
            Project project = ProjectMapper.editEntity(projectDto, projectFromBase.get());
            projectRepository.save(project);
            return ProjectMapper.mapFromEntity(project);
        }
        return new ProjectDto();
    }

    public List<ProjectDto> find(FindProjectDto findProjectDto) {
        List<Project> projectList = projectRepository.find(
                findProjectDto.getStatuses(),
                findProjectDto.getInput());
        List<ProjectDto> result = new ArrayList<>();

        projectList.forEach(o -> result.add(ProjectMapper.mapFromEntity(o)));

        return result;
    }

    public ProjectDto shiftStatus(String projectCode) {
        Optional<Project> projectFromBase = projectRepository.findByCode(projectCode);
        if (projectFromBase.isPresent()) {
            Project project = projectFromBase.get();
            switch (project.getProjectStatus()) {
                case PREPARE -> project.setProjectStatus(ProjectStatus.DEVELOP);
                case DEVELOP -> project.setProjectStatus(ProjectStatus.TEST);
                case TEST -> project.setProjectStatus(ProjectStatus.DONE);
            }
            projectRepository.save(project);
            return ProjectMapper.mapFromEntity(project);
        }
        return new ProjectDto();
    }
}
