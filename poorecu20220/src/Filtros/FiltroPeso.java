package Filtros;

import clases.AutoParte;

public class FiltroPeso implements Filtro{
    private float peso;
    public FiltroPeso (float peso) {this.peso = peso;}

    @Override
    public boolean cumple(AutoParte autoParte) {
        return autoParte.getPeso() == peso;
    }
}
