package model;

public enum CargoElegido {

    // Solo puede tomar el valor de Alcalde o Gobernador.

    ALCALDE, GOBERNADOR;

    public static CargoElegido getCargoElegido(String cargo) {
        if (cargo.equals("Alcalde")) {
            return ALCALDE;
        } else {
            return GOBERNADOR;
        }
    }

    public static String getCargoElegido(CargoElegido cargo) {
        if (cargo == ALCALDE) {
            return "Alcalde";
        } else {
            return "Gobernador";
        }
    }


}
