package com.lapras.cv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Day {

    private String issue;
    private String description;
    private String date;

    @Override
    public String toString() {
        return "Day{" +
                "issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
