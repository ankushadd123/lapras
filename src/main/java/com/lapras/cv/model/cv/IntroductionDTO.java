package com.lapras.cv.model.cv;

public class IntroductionDTO {

        private String fatherName;
        private String hobbies;
        private String dateOfBirth;
        private String alternateContactNumber;
        private String address;

    public IntroductionDTO() {
    }

    public IntroductionDTO(String fatherName, String hobbies, String dateOfBirth, String alternateContactNumber, String address) {
        this.fatherName = fatherName;
        this.hobbies = hobbies;
        this.dateOfBirth = dateOfBirth;
        this.alternateContactNumber = alternateContactNumber;
        this.address = address;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
