package model;

import java.util.ArrayList;

import java.util.Date;

public class Eleccion {

    //Atributos

    private String nombreEleccion;

    private Date fechaEleccion;

    private String lugarEleccion;

    private CargoElegido cargoElegido;

    private ArrayList<Candidato> candidatos;

    //Constructor
    public Eleccion(){

        this.nombreEleccion = "";
        this.fechaEleccion = null;
        this.lugarEleccion = "";
        this.cargoElegido = null;
        this.candidatos = new ArrayList<Candidato>();

    }

    public Eleccion(String nombreEleccion, java.sql.Date fechaEleccion, String lugarEleccion, String cargoElegido, String coalicionPartido, ArrayList<Object> objects) {
    }

    public Eleccion(String nombre, String fecha, String lugar, String cargo, String coalicion) {
    }

    //Getters y Setters


    public String getNombreEleccion() {
        return nombreEleccion;
    }

    public void setNombreEleccion(String nombreEleccion) {
        this.nombreEleccion = nombreEleccion;
    }

    public Date getFechaEleccion() {
        return fechaEleccion;
    }

    public void setFechaEleccion(Date fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
    }

    public String getLugarEleccion() {
        return lugarEleccion;
    }

    public void setLugarEleccion(String lugarEleccion) {
        this.lugarEleccion = lugarEleccion;
    }

    public CargoElegido getCargoElegido() {
        return cargoElegido;
    }

    public void setCargoElegido(CargoElegido cargo) {
        this.cargoElegido = cargoElegido;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
