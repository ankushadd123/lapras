package com.lapras.cv.model.cv;

import java.util.Arrays;
import java.util.List;

public class ResumeFormDTO {

    private AddressDTO address;
    private List<EducationDTO> educations;
    private IntroductionDTO introduction;
    private ExperienceDTO experience;
    private List<ProjectDTO> projects;

    public ResumeFormDTO() {
        this.address = new AddressDTO("John Doe", "Beverly hills, CA", "9898989898", "JohnDoe@email.com");
        this.educations = Arrays.asList(
                new EducationDTO("Stanford University","B.E.","2013","2017","70 %"),
                new EducationDTO("Stanford University","B.E.","2013","2017","70 %"));
        this.introduction = new IntroductionDTO("Sr. John Doe","Tech, Cricket","31-Oct","9999999999","Beverly hills");
        this.projects = Arrays.asList(
                new ProjectDTO("Demo project","Project demo is a project for demo","31-Oct","31-Oct","Docker,Eclipse,IntelliJ","Java,Spring,Mysql"),
                new ProjectDTO("Demo project","Project demo is a project for demo","31-Oct","31-Oct","Docker,Eclipse,IntelliJ","Java,Spring,Mysql"));
        this.experience = new ExperienceDTO("Friends Inc.","31-Oct","31-Oct","Boston");
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }



    public IntroductionDTO getIntroduction() {
        return introduction;
    }

    public void setIntroduction(IntroductionDTO introduction) {
        this.introduction = introduction;
    }

    public ExperienceDTO getExperience() {
        return experience;
    }

    public void setExperience(ExperienceDTO experience) {
        this.experience = experience;
    }

    public List<EducationDTO> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationDTO> educations) {
        this.educations = educations;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
