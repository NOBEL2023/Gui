package com.example.demo11;

public class Evenement {
    private int id;
    private String nom;
    private int nombre_participant;
    private String commentaire;

    public Evenement(int id, String nom, int nombre_participant, String commentaire) {
        this.id = id;
        this.nom = nom;
        this.nombre_participant = nombre_participant;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombre_participant() {
        return nombre_participant;
    }

    public void setNombre_participant(int nombre_participant) {
        this.nombre_participant = nombre_participant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
