import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Arquivos {
    private static final String ARQUIVO = "trabalhadores.txt";

    public static void armazenaDados(Trabalhador trabalhador) {
        Map<String, String> dados = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                dados.put(partes[5], linha);  
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        String novosDados = String.format("%s;%.2f;%.2f;%d;%.2f;%s;%s;%s;%.2f;%.2f",
                trabalhador.getNome(),
                trabalhador.getSalarioBruto(),
                trabalhador.getDescontoINSS(),
                trabalhador.getNumeroDependentes(),
                trabalhador.getDescontosIRRF(),
                trabalhador.getCpf(),
                trabalhador.getCep(),
                trabalhador.getEndereco(),
                trabalhador.getSalarioLiquido(),
                trabalhador.getIrrf());

        dados.put(trabalhador.getCpf(), novosDados);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String linha : dados.values()) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
