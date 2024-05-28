package model;

public class Votante {

    // Atributos

    private String nombreVotante;

    private String rutVotante;

    private String contactoVotante;

    private String preferenciaPolitica;

    // Constructor

    public Votante(){
        this.nombreVotante = "";
        this.rutVotante = "";
        this.contactoVotante = "";
        this.preferenciaPolitica = "";
    }

    public Votante(String rutVotante, String nombreVotante, String contactoVotante, String preferenciaPolitica) {
    }

    // Getters y Setters


    public String getNombreVotante() {
        return nombreVotante;
    }

    public void setNombreVotante(String nombreVotante) {
        this.nombreVotante = nombreVotante;
    }

    public String getRutVotante() {
        return rutVotante;
    }

    public void setRutVotante(String rutVotante) {
        this.rutVotante = rutVotante;
    }

    public String getContactoVotante() {
        return contactoVotante;
    }

    public void setContactoVotante(String contactoVotante) {
        this.contactoVotante = contactoVotante;
    }

    public String getPreferenciaPolitica() {
        return preferenciaPolitica;
    }

    public void setPreferenciaPolitica(String preferenciaPolitica) {
        this.preferenciaPolitica = preferenciaPolitica;
    }
}
