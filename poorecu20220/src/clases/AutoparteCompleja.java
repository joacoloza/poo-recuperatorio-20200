package clases;

import Filtros.Filtro;

import java.util.Vector;

public class AutoparteCompleja extends AutoparteBasica{ //extienda de autoparte basica porque si bien el getHUella es distinto hay que cargarle una huella inicial
    public AutoparteCompleja (float peso,float huellaCarb,String marca,float costo) { super(peso,huellaCarb,marca,costo); }

    @Override
    public float getHuella() { return huellaCarb + peso + materiales.size();}

    @Override
    public int cumpleCondicion(Filtro filtro) {
        if (filtro.cumple(this)) return 1;
        return 0;
    }
}
