package calculadores;

import clases.AutoParte;

public class CalculadorPorcentaje implements Calculador{
    private float pocentaje;
    public CalculadorPorcentaje (float pocentaje){this.pocentaje = pocentaje;}
    @Override
    public float calcular(AutoParte autoParte){ return  autoParte.getCostoBase() * pocentaje; }
}
