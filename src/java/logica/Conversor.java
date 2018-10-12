package logica;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Conversor {

    Recolector recolector = new Recolector();

    ArrayList<Integer> arregloAux2 = new ArrayList();

    public ArrayList convertirEnteroBinario(String p) {
        ArrayList<Integer> arregloAux = new ArrayList();
        arregloAux.clear();
        int aux1, aux2, aux3;
        String s = "";
        for (int i = 0; i < p.length(); i++) {

            if (p.charAt(i) == '.') {
                break;
            }

            s += p.charAt(i);
        }
        aux1 = Integer.parseInt(s);
        do {

            aux2 = (int) (aux1 % 2);
            aux3 = (int) (aux1 / 2);
            aux1 = aux3;
            arregloAux.add(aux2);

        } while (aux1 >= 1);
        return arregloAux;
    }

    public ArrayList convertirDecimalBinario(String decimal) {
        String s = decimal;
        BigDecimal multiplicador = new BigDecimal("2");

        for (int i = 0; i < 40; i++) {
            BigDecimal parteDecimal = new BigDecimal(s);
            BigDecimal multiplicacion = parteDecimal.multiply(multiplicador);
            String x = "" + multiplicacion;
            int z;

            double f = Double.parseDouble(x);
            z = (int) f;
            arregloAux2.add(z);

            s = recolector.obtenerParteDecimal(x);

        }

        return arregloAux2;
    }

    public ArrayList mantisaOchoBits(ArrayList x) {
        if (x.size() < 8) {
            x.add(0);
        }
        return x;

    }

    public String asignarSigno(String p) {
        if (Float.parseFloat(p) < 0) {
            return "1";
        } else {
            return "0";
        }

    }

    public String cambiarSigno(String p) {
        BigDecimal valor = new BigDecimal(p);
        BigDecimal menos = new BigDecimal(-1);

        if (valor.signum() < 0) {
            BigDecimal cambio = valor.multiply(menos);
            return "" + cambio;
        } else {
            return p;
        }

    }
}
