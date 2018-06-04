package com.qajungle.testcontainer.testcontainerexample.persistence;

import com.qajungle.testcontainer.testcontainerexample.persistence.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findProjectByName(String name);

}

