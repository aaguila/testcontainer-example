package com.qajungle.testcontainer.testcontainerexample.services;

import com.qajungle.testcontainer.testcontainerexample.persistence.entity.Project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.rnorth.visibleassertions.VisibleAssertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerServiceTest {

    @Autowired
    ProjectManagerService projectManagerService;

    @Test
    public void should_save_a_new_project() {
        //Having
        final Project project = new Project("testProject", 2018);

        //When
        projectManagerService.addNewProject(project);

        final Project savedProject = projectManagerService.getProjectByName(project.getName());

        //Then
        assertEquals("project name is set", project.getName(), savedProject.getName());
        assertEquals("project year is set", project.getYear(), savedProject.getYear());
    }

    @Test
    public void should_get_an_existing_project() {
        //Having
        final String projectName = "project1";
        final int projectYear = 2016;

        //When
        final Project project = projectManagerService.getProjectByName(projectName);

        //Then
        assertEquals("project name is get", project.getName(), projectName);
        assertEquals("project year is get", project.getYear(), projectYear);
    }

}
