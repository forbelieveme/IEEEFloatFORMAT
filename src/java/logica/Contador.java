package logica;

import java.util.ArrayList;

public class Contador {

    public String contarPosiciones(ArrayList<Integer> x, ArrayList<Integer> y) {
        int i = 0;
        int aux = 0;
        int aux2;
        boolean b = true;
        for (i = 0; i < x.size(); i++) {
            if (x.get(i) == 1) {
                i++;
                b = false;
                aux = x.size() - i;
                break;
            }
        }
        if (b == true) {
            for (i = 0; i < y.size(); i++) {
                if (y.get(i) == 1) {
                    i++;
                    aux = -i;

                    break;
                }

            }

        }
        aux2 = 127 + aux;
        return "" + aux2;
    }
}
