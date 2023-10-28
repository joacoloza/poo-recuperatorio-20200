package clases;

import Filtros.Filtro;
import calculadores.Calculador;
import calculadores.CalculadorPorcentaje;

import java.util.Vector;

public abstract class AutoParte {
    protected String marca;
    private float costoBase;
    public AutoParte (String marca,float costoBase) {
        this.marca = marca;
        this.costoBase = costoBase;
    }
    public abstract float getHuella ();
    public abstract float getPeso ();
    public abstract Vector<String> getMateriales ();

    public String getMarca() { return marca; }
    public abstract int cumpleCondicion (Filtro filtro);
    public abstract float calcularCosto (Calculador calculador,Filtro filtro);

    public float getCostoBase() {
        return costoBase;
    }
}
