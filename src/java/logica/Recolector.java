package logica;

public class Recolector {

    public String obtenerParteDecimal(String x) {
        String s = "0.";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '.') {
                for (int j = i + 1; j < x.length(); j++) {
                    s += x.charAt(j);
                }
            }
        }
        return s;
    }

}
