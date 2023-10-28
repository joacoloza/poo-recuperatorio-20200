package clases;

import Filtros.Filtro;
import calculadores.Calculador;

import java.util.Vector;

public class AutoparteBasica extends AutoParte{
    protected float peso;

    protected float huellaCarb;
    protected Vector<String> materiales;

    public AutoparteBasica (float peso,float huellaCarb,String marca,float costo) {
        super(marca,costo);
        this.peso = peso;
        this.huellaCarb = huellaCarb;
        materiales = new Vector<>();
    }
    public  void agregarMat (String material){ materiales.add(material); }

    @Override
    public float getHuella() { return huellaCarb; }

    @Override
    public float getPeso() {return peso;}

    @Override
    public Vector<String> getMateriales() {return materiales;}

    @Override
    public int cumpleCondicion(Filtro filtro) {
        if (filtro.cumple(this)) return 1;
        return 0;
    }

    @Override
    public float calcularCosto(Calculador calculador, Filtro filtro) {
        if (filtro.cumple(this)){
            return  calculador.calcular(this);
        }
        return getCostoBase();
    }
}
