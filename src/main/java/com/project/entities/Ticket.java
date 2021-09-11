package com.project.entities;

import java.util.Objects;

public class Ticket {
    private int idExhibition;
    private int idUser;

    public Ticket(int idExhibition, int idUser) {
        this.idExhibition = idExhibition;
        this.idUser = idUser;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return idExhibition == ticket.idExhibition && idUser == ticket.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExhibition, idUser);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idExhibition=" + idExhibition +
                ", idUser=" + idUser +
                '}';
    }
}
