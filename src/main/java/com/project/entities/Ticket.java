package com.project.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Ticket {
    private int id;
    private int idExhibition;
    private int idUser;
    private Timestamp soldDate;

    public Ticket(int id, int idExhibition, int idUser, Timestamp soldDate) {
        this.id = id;
        this.idExhibition = idExhibition;
        this.idUser = idUser;
        this.soldDate = soldDate;
    }

    public int getIdExhibition() {
        return idExhibition;
    }

    public void setIdExhibition(int idExhibition) {
        this.idExhibition = idExhibition;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Timestamp getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Timestamp soldDate) {
        this.soldDate = soldDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return idExhibition == ticket.idExhibition && idUser == ticket.idUser && Objects.equals(soldDate, ticket.soldDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExhibition, idUser, soldDate);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idExhibition=" + idExhibition +
                ", idUser=" + idUser +
                ", soldDate=" + soldDate +
                '}';
    }
}