package com.lapras.cv.model.cv;

public class ProjectDTO {

    private String project;
    private String description;
    private String startDate;
    private String endDate;
    private String tools;
    private String technologies;

    public ProjectDTO() {
    }

    public ProjectDTO(String project, String description, String startDate, String endDate, String tools, String technologies) {
        this.project = project;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tools = tools;
        this.technologies = technologies;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
}
