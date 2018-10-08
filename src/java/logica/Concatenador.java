package logica;

import java.util.ArrayList;

public class Concatenador {

    public String obtenerMantisa(ArrayList<Integer> x, ArrayList<Integer> y) {

        int i = 0;
        for (i = 0; i < (y.size()); i++) {
            x.add(y.get(i));
        }

        for (i = 0; i < x.size(); i++) {
            if (x.get(i) == 1) {
                i++;
                break;
            }
        }
        String s = "";
        for (int j = i; j < 23 + i; j++) {

            s += x.get(j);
        }

        return s;
    }

}
