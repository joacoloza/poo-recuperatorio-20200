package Filtros;

import clases.AutoParte;

public class FiltroMaterial implements Filtro{
    private String material;
    public FiltroMaterial (String material){this.material = material;}

    @Override
    public boolean cumple(AutoParte autoParte) {
        return autoParte.getMateriales().contains(material);
    }
}
