package model;

import java.util.ArrayList;

import java.util.Date;

public class Eleccion {

    //Atributos

    private String nombreEleccion;

    private Date fechaEleccion;

    private String lugarEleccion;

    private CargoElegido cargo;

    private ArrayList<Candidato> candidatos;

    //Constructor
    public Eleccion(){

        this.nombreEleccion = "";
        this.fechaEleccion = null;
        this.lugarEleccion = "";
        this.cargo = null;
        this.candidatos = new ArrayList<Candidato>();

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

    public CargoElegido getCargo() {
        return cargo;
    }

    public void setCargo(CargoElegido cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
