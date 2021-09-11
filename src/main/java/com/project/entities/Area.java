package com.project.entities;

import java.util.Objects;

public class Area {
    private int id;
    private int area;

    public Area(int id, int area) {
        this.id = id;
        this.area = area;
    }

    public Area(int area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area1 = (Area) o;
        return id == area1.id && area == area1.area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", area=" + area +
                '}';
    }
}
