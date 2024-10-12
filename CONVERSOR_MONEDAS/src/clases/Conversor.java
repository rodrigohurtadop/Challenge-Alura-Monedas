package clases;

import java.util.HashMap;
import java.util.Map;

public class Conversor {

    private static final Map<String, Double> MONEDAS = new HashMap<>();
    private static final Map<String, Double> UNIDADES = new HashMap<>();

    static {
        MONEDAS.put("PEN->USD", 3.82);
        MONEDAS.put("PEN->EUR", 4.05);
        MONEDAS.put("PEN->GBP", 4.70);
        MONEDAS.put("PEN->JPY", 27.30);
        MONEDAS.put("PEN->KRW", 3.00);

        UNIDADES.put("Metro->Kilometro", 0.001);
        UNIDADES.put("Metro->Milla", 0.000621371);
        UNIDADES.put("Metro->Centímetro", 100.0);
        UNIDADES.put("Metro->Milímetro", 1000.0);
        UNIDADES.put("Metro->Decametro", 0.1);
    }

    public static double convertir(String clave, double valor) {
        Double tasa = MONEDAS.getOrDefault(clave, UNIDADES.get(clave));
        if (tasa == null) throw new IllegalArgumentException("Conversión no soportada.");
        return valor * tasa;
    }

    public static double invertirConversion(String clave, double valor) {
        Double tasa = MONEDAS.getOrDefault(clave, UNIDADES.get(clave));
        if (tasa == null) throw new IllegalArgumentException("Conversión no soportada.");
        return valor / tasa;
    }
}
