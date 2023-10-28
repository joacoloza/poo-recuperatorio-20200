import Filtros.*;
import calculadores.Calculador;
import calculadores.CalculadorFijo;
import clases.AutoParte;
import clases.AutoparteBasica;
import clases.AutoparteCompleja;
import clases.AutoparteCompuesta;

import java.util.Vector;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vector <AutoParte> autopartes = new Vector<>();
        //carga
        AutoparteBasica a1 = new AutoparteBasica(10,8,"philips",2000);
        AutoparteBasica a2 = new AutoparteBasica(200,3,"wezeer",2000);
        AutoparteBasica a3 = new AutoparteBasica(6,9,"ccc",2000);
        AutoparteCompleja c1 = new AutoparteCompleja(600,7,"wezeer",2000);
        AutoparteCompleja c2 = new AutoparteCompleja(300,0,"bbb",2000);
        AutoparteCompleja c3 = new AutoparteCompleja(1,20,"wezeer",2000);
        AutoparteCompleja c4 = new AutoparteCompleja(1,20,"contaminator",2000);
        AutoparteCompuesta b1 = new  AutoparteCompuesta("philips",200);
        AutoparteCompuesta b2 = new  AutoparteCompuesta("bbb",400);
        //materiales
        a1.agregarMat("aaa");
        a2.agregarMat("aluminio");
        a3.agregarMat("bb");
        c1.agregarMat("aluminio");
        c2.agregarMat("bbb");
        c3.agregarMat("aluminio");
        c4.agregarMat("ddd");
        // carga arreglo auto parte compleja
        b1.agregarAutoparte(10,"contaminator",a1);
        b1.agregarAutoparte(10,"contaminator",a2);
        b2.agregarAutoparte(10,"contaminator",a1);
        b2.agregarAutoparte(10,"contaminator",c1);
        b2.agregarAutoparte(10,"contaminator",c2);
        b1.agregarAutoparte(10,"contaminator",c3);//no add
        b2.agregarAutoparte(10,"contaminator",c3);//no add
        b2.agregarAutoparte(10,"contaminator",c4);//no add
        //carga filtros
        FiltroMarca f1 = new FiltroMarca("philips");
        FiltroMarca f2 = new FiltroMarca("wezeer");
        FiltroMaterial f3 = new FiltroMaterial("aluminio");
        FiltroPeso f4 = new FiltroPeso(500);
        FiltroAnd f6 = new FiltroAnd(f2,f3);
        autopartes.add(a1);
        autopartes.add(a2);
        autopartes.add(a3);
        autopartes.add(b1);
        autopartes.add(b2);
        autopartes.add(c1);
        autopartes.add(c2);
        autopartes.add(c3);
        autopartes.add(c4);
        //final carga
        // enunciado
        int sum = 0;
        for (AutoParte autoParte : autopartes){
            if (f1.cumple(autoParte)){sum++;}
        }
        System.out.println("la cantidad de autopartes con la marca philips es: " + sum);
        sum = 0;
        for (AutoParte autoParte : autopartes){
            if (f6.cumple(autoParte)){sum++;}
        }
        System.out.println("la cantidad de autopartes con marca weezer y aluminio son: " + sum);

        System.out.println("el costo de las autpartes son: ");
        CalculadorFijo calculador = new CalculadorFijo();
        FiltroTrue ft = new FiltroTrue();
        int suma = 1;
        for (AutoParte autoParte : autopartes) {
            System.out.println("para :"+ suma + " costo: " + autoParte.calcularCosto(calculador,ft));
            suma++;
        }
    }
}