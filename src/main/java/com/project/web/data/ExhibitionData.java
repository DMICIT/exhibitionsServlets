package com.project.web.data;

import java.sql.Date;
import java.sql.Time;

public class ExhibitionData {

    private int id;
    private ThemeData theme;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private int cost;
    private String status;

    public ExhibitionData(int id, ThemeData theme, Date startDate, Date endDate, Time startTime, Time endTime, int cost, String status) {
        this.id = id;
        this.theme = theme;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThemeData getTheme() {
        return theme;
    }

    public void setTheme(ThemeData theme) {
        this.theme = theme;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
