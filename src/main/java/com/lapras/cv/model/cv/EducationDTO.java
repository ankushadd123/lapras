package com.lapras.cv.model.cv;

public class EducationDTO {

    private String universityBoard;
    private String standardDegree;
    private String startYear;
    private String endYear;
    private String percentage;

    public EducationDTO() {
    }

    public EducationDTO(String universityBoard, String standardDegree, String startYear, String endYear, String percentage) {
        this.universityBoard = universityBoard;
        this.standardDegree = standardDegree;
        this.startYear = startYear;
        this.endYear = endYear;
        this.percentage = percentage;
    }

    public String getUniversityBoard() {
        return universityBoard;
    }

    public void setUniversityBoard(String universityBoard) {
        this.universityBoard = universityBoard;
    }

    public String getStandardDegree() {
        return standardDegree;
    }

    public void setStandardDegree(String standardDegree) {
        this.standardDegree = standardDegree;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
