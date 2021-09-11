package com.project.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Exhibition {
    private int id;
    private int idTheme;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private int cost;
    private String status;

    public Exhibition(int id, int idTheme, Date startDate, Date endDate, Time startTime, Time endTime, int cost, String status) {
        this.id = id;
        this.idTheme = idTheme;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.status = status;
    }

    public Exhibition(int idTheme, Date startDate, Date endDate, Time startTime, Time endTime, int cost, String status) {
        this.idTheme = idTheme;
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

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exhibition that = (Exhibition) o;
        return id == that.id && idTheme == that.idTheme && cost == that.cost && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTheme, startDate, endDate, startTime, endTime, cost, status);
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", idTheme=" + idTheme +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                '}';
    }
}
