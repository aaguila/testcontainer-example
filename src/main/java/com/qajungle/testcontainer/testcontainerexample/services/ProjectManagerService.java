package com.qajungle.testcontainer.testcontainerexample.services;

import com.qajungle.testcontainer.testcontainerexample.persistence.ProjectRepository;
import com.qajungle.testcontainer.testcontainerexample.persistence.entity.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagerService {

    private final ProjectRepository projectRepository;

    public ProjectManagerService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Method for get a project
     *
     * @param name
     * @return project
     */
    public Project getProjectByName(final String name) {
        return projectRepository.findProjectByName(name);
    }

    /**
     * Method for add new project
     *
     * @param project
     * @return project
     */
    public Project addNewProject(final Project project) {
        return projectRepository.save(project);
    }

}
