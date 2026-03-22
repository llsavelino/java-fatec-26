import java.util.ArrayList;

class Atleta {
    private int id;
    private String nome;
    private String posicao;

    public Atleta(int id, String nome, String posicao) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Atleta{id=" + id + ", nome='" + nome + "', posicao='" + posicao + "'}";
    }
}

class Time {
    private int id;
    private String nome;
    private String tecnico;
    private ArrayList<Atleta> atletas;

    public Time(int id, String nome, String tecnico) {
        this.id = id;
        this.nome = nome;
        this.tecnico = tecnico;
        this.atletas = new ArrayList<>();
    }

    public void contratarAtleta(Atleta a) {
        atletas.add(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Time{id=").append(id)
          .append(", nome='").append(nome)
          .append("', tecnico='").append(tecnico)
          .append("', atletas=[\n");
        
        for (Atleta a : atletas) {
            sb.append("  ").append(a).append("\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}

public class ExercicioTimeBasquete {
    public static void main(String[] args) {
        Atleta a1 = new Atleta(7, "Lucas Dias", "Ala");
        Atleta a2 = new Atleta(11, "David Jackson", "Pivô");
        Atleta a3 = new Atleta(23, "Didi Louzada", "Ala-armador");

        Time franca = new Time(1, "SESI Franca Basquete", "Helinho Garcia");

        franca.contratarAtleta(a1);
        franca.contratarAtleta(a2);
        franca.contratarAtleta(a3);

        System.out.println("Antes de anular o time:");
        System.out.println(franca);
        System.out.println();

        System.out.println("Objeto atleta a1 continua existindo: " + a1);

        franca = null;

        System.out.println("\nDepois de anular o time (franca = null):");
        System.out.println("Referência ao time: " + franca);

        System.out.println("\nObjeto atleta a1 ainda existe: " + a1);
        System.out.println("a2 ainda existe: " + a2);
        System.out.println("a3 ainda existe: " + a3);
    }
}
