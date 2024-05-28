package model;

public class Candidato {

    //Atributos

    private String nombreCandidato;

    private String rutCandidato;

    private String partidoPolitico;

    private String cargoPostula;



    //Constructor
    public Candidato(String nombreCandidato, String partidoPolitico, String cargoPostula){

        this.nombreCandidato = "";
        this.rutCandidato = "";
        this.partidoPolitico = "";
        this.cargoPostula = "";


    }

   //Getters y Setters


    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getRutCandidato() {
        return rutCandidato;
    }

    public void setRutCandidato(String rutCandidato) {
        this.rutCandidato = rutCandidato;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCargoPostula() {
        return cargoPostula;
    }

    public void setCargoPostula(String cargoPostula) {
        this.cargoPostula = cargoPostula;
    }
}
