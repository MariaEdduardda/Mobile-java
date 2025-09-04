package gerenciadorDeFinançasPessoais;

import java.util.ArrayList;
import java.util.List;

// Interface para itens que podem precisar de revisão
interface Revisavel {
    boolean precisaRevisao();
}

// Classe abstrata para investimentos
abstract class Investimento implements Revisavel {
    protected String nome;
    protected double valorAplicado;

    public Investimento(String nome, double valorAplicado) {
        this.nome = nome;
        this.valorAplicado = valorAplicado;
    }

    public abstract double calcularRetorno(); // cada investimento calcula diferente

    public void exibirInfo() {
        System.out.println("Investimento: " + nome + " | Valor aplicado: R$" + valorAplicado);
    }
}

// Classe concreta para Ações
class Acao extends Investimento {
    private double variacaoPercentual; // pode ser positivo ou negativo

    public Acao(String nome, double valorAplicado, double variacaoPercentual) {
        super(nome, valorAplicado);
        this.variacaoPercentual = variacaoPercentual;
    }

    @Override
    public double calcularRetorno() {
        return valorAplicado * (variacaoPercentual / 100.0);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Ação | Variação: " + variacaoPercentual + "% | Retorno: R$" + calcularRetorno());
    }

    @Override
    public boolean precisaRevisao() {
        return variacaoPercentual < -10; // se cair mais de 10%, precisa revisão
    }
}

// Classe concreta para Renda Fixa
class RendaFixa extends Investimento {
    private double taxaJuros; // % ao ano

    public RendaFixa(String nome, double valorAplicado, double taxaJuros) {
        super(nome, valorAplicado);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public double calcularRetorno() {
        return valorAplicado * (taxaJuros / 100.0);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Renda Fixa | Juros: " + taxaJuros + "% | Retorno: R$" + calcularRetorno());
    }

    @Override
    public boolean precisaRevisao() {
        return taxaJuros < 3; // juros muito baixos, pode precisar de revisão
    }
}

// Classe que gerencia a carteira de investimentos
class CarteiraInvestimentos {
    private List<Investimento> investimentos;

    public CarteiraInvestimentos() {
        investimentos = new ArrayList<>();
    }

    public void adicionarInvestimento(Investimento inv) {
        investimentos.add(inv);
    }

    public void listarInvestimentos() {
        System.out.println("Lista de Investimentos:");
        for (Investimento inv : investimentos) {
            inv.exibirInfo();
            System.out.println("-----------------");
        }
    }

    public double calcularRetornoTotal() {
        double total = 0;
        for (Investimento inv : investimentos) {
            total += inv.calcularRetorno();
        }
        return total;
    }

    public void listarInvestimentosRevisao() {
        System.out.println("Investimentos que precisam de revisão:");
        for (Investimento inv : investimentos) {
            if (inv.precisaRevisao()) {
                inv.exibirInfo();
                System.out.println("-----------------");
            }
        }
    }
}

// Classe principal para testar
public class Main {
    public static void main(String[] args) {
        CarteiraInvestimentos carteira = new CarteiraInvestimentos();

        Investimento acao1 = new Acao("PETR4", 5000, -12);
        Investimento acao2 = new Acao("VALE3", 3000, 8);
        Investimento rf1 = new RendaFixa("CDB Banco X", 10000, 5);
        Investimento rf2 = new RendaFixa("Tesouro Selic", 8000, 2);

        carteira.adicionarInvestimento(acao1);
        carteira.adicionarInvestimento(acao2);
        carteira.adicionarInvestimento(rf1);
        carteira.adicionarInvestimento(rf2);

        carteira.listarInvestimentos();

        System.out.println("\n Retorno total da carteira: R$" + carteira.calcularRetornoTotal());
        System.out.println();
        carteira.listarInvestimentosRevisao();
    }
}

