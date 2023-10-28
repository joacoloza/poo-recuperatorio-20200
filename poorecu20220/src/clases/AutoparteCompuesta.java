package clases;

import Filtros.Filtro;
import calculadores.Calculador;

import java.util.Vector;

public class AutoparteCompuesta  extends AutoParte {
    private Vector <AutoParte> autoPartes;
    public AutoparteCompuesta(String marca, float costobase) {
        super(marca,costobase);
        autoPartes = new Vector<>();
    }

    public void agregarAutoparte (float huellaCarb, String marca, AutoParte autoParte){
        if (!((autoParte.getHuella() > huellaCarb) ||  (autoParte.getMarca() == marca))){
            autoPartes.add(autoParte);
        }
    }

    @Override
    public float getPeso() {
        float suma = 0;
        for (AutoParte autoParte : autoPartes){
            suma += autoParte.getPeso();
        }
        return suma;
    }

    @Override
    public float getHuella () {
        float max1 = -1;
        float max2 = -1;
        for (AutoParte autoParte : autoPartes){
            float aux = autoParte.getHuella();
            if (aux > max1) {
                max2 = max1;
                max1 = aux;
            }
        }
        return max1 + max2;
    }

    @Override
    public Vector<String> getMateriales() {
        Vector<String> res = new Vector<>();
        for (AutoParte autoParte : autoPartes){
            Vector<String> aux = autoParte.getMateriales();
            for (String material : aux){
                if (! res.contains(material)){
                    res.add(material);
                }
            }
        }
        return res;
    }

    @Override
    public int cumpleCondicion(Filtro filtro) {
        if (filtro.cumple(this)) {
            return 1;
        }
        else {
            int sum = 0;
            for (AutoParte autoParte : autoPartes){
                sum += autoParte.cumpleCondicion(filtro);
            }
            return sum;
        }
    }

    @Override
    public float calcularCosto(Calculador calculador,Filtro filtro) {
        float suma = 0;
        for (AutoParte autoParte : autoPartes){
            if(filtro.cumple(this)){
                suma += calculador.calcular(autoParte);
            }
        }
        return suma;
    }
}

