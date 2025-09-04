package tiposDeVeiculos;

// Classe abstrata base
abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Método comum
    public void exibirInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
    }

    // Método abstrato (cada veículo terá sua forma de acelerar)
    public abstract void acelerar();

    // Método abstrato (cada veículo freia de forma diferente)
    public abstract void frear();
}

// Subclasse Carro
class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, String modelo, int ano, int portas) {
        super(marca, modelo, ano);
        this.portas = portas;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro acelera suavemente.");
    }

    @Override
    public void frear() {
        System.out.println("O carro está freando com ABS.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Portas: " + portas);
    }
}

// Subclasse Moto
class Moto extends Veiculo {
    private boolean temCarenagem;

    public Moto(String marca, String modelo, int ano, boolean temCarenagem) {
        super(marca, modelo, ano);
        this.temCarenagem = temCarenagem;
    }

    @Override
    public void acelerar() {
        System.out.println("A moto acelera rapidamente!");
    }

    @Override
    public void frear() {
        System.out.println("A moto freia usando disco.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Carenagem: " + (temCarenagem ? "Sim" : "Não"));
    }
}

// Subclasse Caminhao
class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, double capacidadeCarga) {
        super(marca, modelo, ano);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public void acelerar() {
        System.out.println("O caminhão acelera lentamente devido ao peso.");
    }

    @Override
    public void frear() {
        System.out.println("O caminhão usa freios a ar.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Capacidade de carga: " + capacidadeCarga + " toneladas");
    }
}

// Classe principal para testar
public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Toyota", "Corolla", 2022, 4);
        Veiculo moto = new Moto("Honda", "CB 500", 2021, true);
        Veiculo caminhao = new Caminhao("Volvo", "FH16", 2019, 25.0);

        carro.exibirInfo();
        carro.acelerar();
        carro.frear();

        System.out.println("--------------------");

        moto.exibirInfo();
        moto.acelerar();
        moto.frear();

        System.out.println("--------------------");

        caminhao.exibirInfo();
        caminhao.acelerar();
        caminhao.frear();
    }
}


