package gerenciadorDeInvestimentosPessoais;

import java.util.ArrayList;
import java.util.List;

// Interface para transações
interface Transacao {
    double getValor();
    String getDescricao();
    void exibirInfo();
    boolean precisaRevisao(); // regra de negócio
}

// Classe para despesas
class Despesa implements Transacao {
    private double valor;
    private String descricao;
    private String categoria;

    public Despesa(double valor, String descricao, String categoria) {
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    @Override
    public double getValor() {
        return -valor; // despesa diminui o saldo
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Despesa: " + descricao + " | Categoria: " + categoria + " | Valor: -" + valor);
    }

    @Override
    public boolean precisaRevisao() {
        return valor > 2000; // exemplo: valores muito altos precisam ser revisados
    }
}

// Classe para receitas
class Receita implements Transacao {
    private double valor;
    private String descricao;
    private String fonte;

    public Receita(double valor, String descricao, String fonte) {
        this.valor = valor;
        this.descricao = descricao;
        this.fonte = fonte;
    }

    @Override
    public double getValor() {
        return valor; // receita soma ao saldo
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Receita: " + descricao + " | Fonte: " + fonte + " | Valor: +" + valor);
    }

    @Override
    public boolean precisaRevisao() {
        return valor < 0; // receita não pode ser negativa
    }
}

// Classe que gerencia as transações
class GerenciadorFinanceiro {
    private List<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao t) {
        transacoes.add(t);
    }

    public void listarTransacoes() {
        System.out.println("Lista de Transações:");
        for (Transacao t : transacoes) {
            t.exibirInfo();
        }
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao t : transacoes) {
            saldo += t.getValor();
        }
        return saldo;
    }

    public void listarTransacoesRevisao() {
        System.out.println(" Transações que precisam de revisão:");
        for (Transacao t : transacoes) {
            if (t.precisaRevisao()) {
                t.exibirInfo();
            }
        }
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        GerenciadorFinanceiro gf = new GerenciadorFinanceiro();

        Transacao despesa1 = new Despesa(150.0, "Supermercado", "Alimentação");
        Transacao despesa2 = new Despesa(2500.0, "Compra Notebook", "Eletrônicos");
        Transacao receita1 = new Receita(3500.0, "Salário", "Empresa X");
        Transacao receita2 = new Receita(-200.0, "Erro de lançamento", "Banco"); // precisa revisão

        gf.adicionarTransacao(despesa1);
        gf.adicionarTransacao(despesa2);
        gf.adicionarTransacao(receita1);
        gf.adicionarTransacao(receita2);

        gf.listarTransacoes();
        System.out.println("\n Saldo atual: " + gf.calcularSaldo());
        System.out.println();
        gf.listarTransacoesRevisao();
    }
}

