package Filtros;

import clases.AutoParte;

public class FiltroTrue implements Filtro{
    @Override
    public boolean cumple(AutoParte autoParte) {return true;}
}
