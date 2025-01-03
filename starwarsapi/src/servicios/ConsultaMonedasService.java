package servicios;

import com.google.gson.JsonObject;
import utilidades.ClienteApi;

public class ConsultaMonedasService {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/188f5bc1344c18c5920c71b0/latest/";

    public double convertir(String monedaOrigen, String monedaDestino, double monto) {
        try {
            JsonObject respuesta = ClienteApi.get(URL_API + monedaOrigen);

            JsonObject tasasConversion = respuesta.getAsJsonObject("conversion_rates");

            if (!tasasConversion.has(monedaDestino)) {
                throw new IllegalArgumentException("Moneda destino no encontrada: " + monedaDestino);
            }

            double tasa = tasasConversion.get(monedaDestino).getAsDouble();
            return monto * tasa;

        } catch (Exception e) {
            System.err.println("Error durante la conversión: " + e.getMessage());
            return 0;
        }
    }
}
