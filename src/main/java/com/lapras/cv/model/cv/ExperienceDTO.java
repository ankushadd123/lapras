package com.lapras.cv.model.cv;

public class ExperienceDTO {

    private String company;
    private String startDate;
    private String endDate;
    private String city;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String company, String startDate, String endDate, String city) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
