package tiposDeContatos;

import java.util.ArrayList;
import java.util.List;

// Interface que define o contrato de um contato
interface Contato {
    String getNome();
    String getTelefone();
    void exibirInfo();
    void enviarMensagem(String mensagem);
}

// Classe para contatos pessoais
class ContatoPessoal implements Contato {
    private String nome;
    private String telefone;
    private String aniversario;

    public ContatoPessoal(String nome, String telefone, String aniversario) {
        this.nome = nome;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Contato Pessoal: " + nome + " | Telefone: " + telefone + " | Aniversário: " + aniversario);
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando mensagem para " + nome + ": " + mensagem);
    }
}

// Classe para contatos profissionais
class ContatoProfissional implements Contato {
    private String nome;
    private String telefone;
    private String empresa;

    public ContatoProfissional(String nome, String telefone, String empresa) {
        this.nome = nome;
        this.telefone = telefone;
        this.empresa = empresa;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Contato Profissional: " + nome + " | Telefone: " + telefone + " | Empresa: " + empresa);
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando mensagem corporativa para " + nome + " (" + empresa + "): " + mensagem);
    }
}

// Classe Agenda que gerencia os contatos
class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        for (Contato c : contatos) {
            c.exibirInfo();
        }
    }

    public void buscarContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Encontrado:");
                c.exibirInfo();
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }
}

// Classe principal para testar
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato pessoal = new ContatoPessoal("João", "9999-9999", "15/03");
        Contato profissional = new ContatoProfissional("Maria", "9888-8888", "Escritório Solutions");

        agenda.adicionarContato(pessoal);
        agenda.adicionarContato(profissional);

        System.out.println(" Lista de Contatos:");
        agenda.listarContatos();

        System.out.println("\n Buscando contato 'Maria':");
        agenda.buscarContato("Maria");

        System.out.println("\n Enviando mensagens:");
        pessoal.enviarMensagem("Feliz aniversário!");
        profissional.enviarMensagem("Reunião marcada para amanhã às 10h.");
    }
}

