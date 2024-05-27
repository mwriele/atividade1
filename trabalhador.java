public class Trabalhador {
    private String nome;
    private double salarioBruto;
    private double descontoINSS;
    private int numeroDependentes;
    private double descontosIRRF;
    private String cpf;
    private String cep;
    private String endereco;
    private double salarioLiquido;
    private double irrf;

    public Trabalhador(String nome, double salarioBruto, double descontoINSS, int numeroDependentes,
            double descontosIRRF, String cpf, String cep, String endereco, double salarioLiquido, double irrf) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.descontoINSS = descontoINSS;
        this.numeroDependentes = numeroDependentes;
        this.descontosIRRF = descontosIRRF;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.salarioLiquido = salarioLiquido;
        this.irrf = irrf;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getDescontoINSS() {
        return descontoINSS;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public double getDescontosIRRF() {
        return descontosIRRF;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public double getIrrf() {
        return irrf;
    }
}
