import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsultaCEP {
    public static String consultaCEP(String cep) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            String responseString = response.toString();
            if (responseString.contains("\"erro\": true")) {
                return null;
            }

            String logradouro = extractValue(responseString, "logradouro");
            String bairro = extractValue(responseString, "bairro");
            String localidade = extractValue(responseString, "localidade");
            String uf = extractValue(responseString, "uf");

            return String.format("%s, %s, %s, %s", logradouro, bairro, localidade, uf);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String extractValue(String json, String key) {
        String pattern = String.format("\"%s\":\"(.*?)\"", key);
        return json.replaceAll(pattern, "$1");
    }
}
