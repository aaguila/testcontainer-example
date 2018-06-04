package com.qajungle.testcontainer.testcontainerexample.domain.dto;

public class ProjectDto {

    public ProjectDto() {
    }

    public ProjectDto(String name, int year) {
        this.name = name;
        this.year = year;
    }

    private int id;

    private String name;

    private int year;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
