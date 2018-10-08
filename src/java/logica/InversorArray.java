package logica;

import java.util.ArrayList;

public class InversorArray {

    public ArrayList invertirArreglo(ArrayList x) {
        ArrayList<Integer> y = new ArrayList();
        for (int i = x.size() - 1; i >= 0; i--) {

            y.add((Integer) x.get(i));

        }

        return y;
    }

    public String mantisaString(ArrayList x) {

        String s = "";

        for (int j = 0; j < x.size(); j++) {

            s += x.get(j);
        }

        return s;
    }
}
