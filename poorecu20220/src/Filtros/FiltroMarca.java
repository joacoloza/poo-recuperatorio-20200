package Filtros;

import clases.AutoParte;

public class FiltroMarca implements Filtro{
    private String marca;
    public  FiltroMarca (String marca) {this.marca = marca;}

    @Override
    public boolean cumple(AutoParte autoParte) {
        return autoParte.getMarca() == marca;
    }
}
