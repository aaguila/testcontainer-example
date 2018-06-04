package com.qajungle.testcontainer.testcontainerexample.controllers;

import com.qajungle.testcontainer.testcontainerexample.persistence.entity.Project;
import com.qajungle.testcontainer.testcontainerexample.domain.dto.ProjectDto;
import com.qajungle.testcontainer.testcontainerexample.services.ProjectManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectManagerController {

    @Autowired
    private ModelMapper modelMapper;

    private final ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/project/{name}")
    @ResponseBody
    public ProjectDto getProject(@PathVariable("name") String name) {
        return convertToDto(projectManagerService.getProjectByName(name));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/project")
    @ResponseBody
    public ProjectDto setProject(@RequestBody ProjectDto projectDto) {
        return convertToDto(projectManagerService.addNewProject(convertFromDto(projectDto)));
    }

    private ProjectDto convertToDto(final Project project){
        return modelMapper.map(project, ProjectDto.class);
    }

    private Project convertFromDto(final ProjectDto projectDto){
        return modelMapper.map(projectDto, Project.class);
    }
}
