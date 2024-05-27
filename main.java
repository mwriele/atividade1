import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Salário Bruto: ");
        double salarioBruto = scanner.nextDouble();
        
        System.out.print("Desconto do INSS: ");
        double descontoINSS = scanner.nextDouble();
        
        System.out.print("Número de Dependentes: ");
        int numeroDependentes = scanner.nextInt();
        
        System.out.print("Valor total de descontos cabíveis para dedução de IRRF: ");
        double descontosIRRF = scanner.nextDouble();
        
        scanner.nextLine();  
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        
        // Validar CPF
        if (Validacao.validaCPF(cpf).equals("CPF Inválido, tente novamente")) {
            System.out.println("CPF inválido.");
            return;
        }
        
        // Consulta CEP
        String endereco = ConsultaCEP.consultaCEP(cep);
        if (endereco == null) {
            System.out.println("CEP inválido.");
            return;
        }
        
        // Calcular Salário Líquido e IRRF
        double salarioLiquido = Calculos.calculaSalarioLiquido(salarioBruto, descontoINSS, descontosIRRF, numeroDependentes);
        double irrf = Calculos.calculaIRRF(salarioBruto, descontoINSS, descontosIRRF, numeroDependentes);
        
        Trabalhador trabalhador = new Trabalhador(nome, salarioBruto, descontoINSS, numeroDependentes, descontosIRRF, cpf, cep, endereco, salarioLiquido, irrf);
        
        System.out.println("Endereço: " + trabalhador.getEndereco());
        System.out.println("Salário Líquido: " + trabalhador.getSalarioLiquido());
        System.out.println("IRRF: " + trabalhador.getIrrf());
        
        // Armazenar dados
        Arquivos.armazenaDados(trabalhador);
        
        scanner.close();
    }
}
