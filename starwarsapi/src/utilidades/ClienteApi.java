package utilidades;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteApi {
    public static JsonObject get(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() == 404) {
            throw new RuntimeException("Recurso no encontrado. Verifica la URL: " + url);
        }

        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error en la conexión con la API: Código " + respuesta.statusCode());
        }

        return JsonParser.parseString(respuesta.body()).getAsJsonObject();
    }
}
