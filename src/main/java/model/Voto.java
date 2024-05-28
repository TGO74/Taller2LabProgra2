package model;

import java.util.Date;

public class Voto {

    //Atributos

    private Candidato candidatoElegido;

    private Date fechaEmison;

    //Constructor

    public Voto(){
        this.candidatoElegido = null;
        this.fechaEmison = null;
    }

    //Getters y Setters


    public Candidato getCandidatoElegido() {
        return candidatoElegido;
    }

    public void setCandidatoElegido(Candidato candidatoElegido) {
        this.candidatoElegido = candidatoElegido;
    }

    public Date getFechaEmison() {
        return fechaEmison;
    }

    public void setFechaEmison(Date fechaEmison) {
        this.fechaEmison = fechaEmison;
    }
}
