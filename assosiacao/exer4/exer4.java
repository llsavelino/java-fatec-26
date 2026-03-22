import java.util.ArrayList;

class Programador {
    private int id;
    private String nome;
    private String linguagemPrincipal;

    public Programador(int id, String nome, String linguagemPrincipal) {
        this.id = id;
        this.nome = nome;
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    @Override
    public String toString() {
        return "Programador{id=" + id + ", nome='" + nome + "', linguagem='" + linguagemPrincipal + "'}";
    }
}

class Projeto {
    private int id;
    private String nomeProjeto;
    private ArrayList<Programador> programadores;

    public Projeto(int id, String nomeProjeto) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.programadores = new ArrayList<>();
    }

    public void adicionarProgramador(Programador p) {
        programadores.add(p);
    }

    public void listarProgramadores() {
        if (programadores.isEmpty()) {
            System.out.println("Nenhum programador alocado no projeto '" + nomeProjeto + "'");
            return;
        }

        System.out.println("Programadores no projeto '" + nomeProjeto + "' (ID: " + id + "):");
        for (Programador p : programadores) {
            System.out.println("  - " + p);
        }
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }
}

public class ExercicioProjetoSoftware {
    public static void main(String[] args) {
        Programador p1 = new Programador(101, "Mariana Costa", "Java");
        Programador p2 = new Programador(102, "Rafael Mendes", "Python");
        Programador p3 = new Programador(103, "Beatriz Lima", "JavaScript");
        Programador p4 = new Programador(104, "Lucas Ferreira", "Java");

        Projeto sistemaERP = new Projeto(1, "Sistema ERP Corporativo");
        Projeto appMobile = new Projeto(2, "App Mobile Fintech");

        sistemaERP.adicionarProgramador(p1);
        sistemaERP.adicionarProgramador(p2);
        sistemaERP.adicionarProgramador(p4);

        appMobile.adicionarProgramador(p3);
        appMobile.adicionarProgramador(p2);

        System.out.println("=== Listagem dos projetos ===\n");

        sistemaERP.listarProgramadores();
        System.out.println();

        appMobile.listarProgramadores();
        System.out.println();

        Projeto projetoVazio = new Projeto(3, "Projeto Futuro");
        projetoVazio.listarProgramadores();
    }
}
