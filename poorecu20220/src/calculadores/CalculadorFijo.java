package calculadores;

import clases.AutoParte;

public class CalculadorFijo implements Calculador{
    @Override
    public float calcular(AutoParte autoParte) {return autoParte.getCostoBase();}
}
