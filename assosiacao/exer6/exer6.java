import java.util.ArrayList;

class Apartamento {
    private int numero;
    private int andar;

    public Apartamento(int numero, int andar) {
        this.numero = numero;
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Apartamento{numero=" + numero + ", andar=" + andar + "}";
    }
}

class Edificio {
    private String nome;
    private String endereco;
    private ArrayList<Apartamento> apartamentos;

    public Edificio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.apartamentos = new ArrayList<>();
    }

    public void construirApartamento(int num, int andar) {
        Apartamento apt = new Apartamento(num, andar);
        apartamentos.add(apt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edifício '").append(nome).append("'\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Total de apartamentos: ").append(apartamentos.size()).append("\n");

        if (!apartamentos.isEmpty()) {
            sb.append("Apartamentos:\n");
            for (Apartamento a : apartamentos) {
                sb.append("  • ").append(a).append("\n");
            }
        } else {
            sb.append("Nenhum apartamento construído ainda.\n");
        }

        return sb.toString();
    }
}

public class ExercicioEdificio {
    public static void main(String[] args) {
        Edificio torreJardim = new Edificio("Torre Jardim Europa", "Av. Brigadeiro Faria Lima, 3200 - São Paulo/SP");

        torreJardim.construirApartamento(101, 1);
        torreJardim.construirApartamento(102, 1);
        torreJardim.construirApartamento(201, 2);
        torreJardim.construirApartamento(301, 3);
        torreJardim.construirApartamento(302, 3);
        torreJardim.construirApartamento(401, 4);
        torreJardim.construirApartamento(1501, 15);

        System.out.println(torreJardim);

        System.out.println("-------------------------------\n");

        Edificio predioPequeno = new Edificio("Residencial Sol Nascente", "Rua das Flores, 45 - Campinas/SP");
        predioPequeno.construirApartamento(101, 1);
        predioPequeno.construirApartamento(102, 1);

        System.out.println(predioPequeno);

        System.out.println("-------------------------------\n");

        Edificio vazio = new Edificio("Edifício Futuro", "Rua Sem Nome, 000");
        System.out.println(vazio);
    }
}
