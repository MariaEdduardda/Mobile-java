package tiposDeDispositivosEletronicos;

// Classe abstrata base
abstract class Dispositivo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Dispositivo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Método comum
    public void exibirInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
    }

    // Métodos abstratos (cada dispositivo implementa do seu jeito)
    public abstract void ligar();
    public abstract void desligar();
}

// Subclasse Computador
class Computador extends Dispositivo {
    private String processador;

    public Computador(String marca, String modelo, int ano, String processador) {
        super(marca, modelo, ano);
        this.processador = processador;
    }

    @Override
    public void ligar() {
        System.out.println("O computador está iniciando o sistema operacional...");
    }

    @Override
    public void desligar() {
        System.out.println("O computador está desligando com segurança.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Processador: " + processador);
    }
}

// Subclasse Smartphone
class Smartphone extends Dispositivo {
    private boolean tem5G;

    public Smartphone(String marca, String modelo, int ano, boolean tem5G) {
        super(marca, modelo, ano);
        this.tem5G = tem5G;
    }

    @Override
    public void ligar() {
        System.out.println("O smartphone está ligando e mostrando a tela inicial.");
    }

    @Override
    public void desligar() {
        System.out.println("O smartphone foi desligado.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Suporte a 5G: " + (tem5G ? "Sim" : "Não"));
    }
}

// Classe principal para testar
public class Main {
    public static void main(String[] args) {
        Dispositivo pc = new Computador("Dell", "Inspiron", 2022, "Intel i7");
        Dispositivo celular = new Smartphone("Samsung", "Galaxy S22", 2023, true);

        pc.exibirInfo();
        pc.ligar();
        pc.desligar();

        System.out.println("--------------------");

        celular.exibirInfo();
        celular.ligar();
        celular.desligar();
    }
}
