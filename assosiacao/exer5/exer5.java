class Processador {
    private String marca;
    private String modelo;
    private double frequencia;

    public Processador(String marca, String modelo, double frequencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Processador{marca='" + marca + "', modelo='" + modelo + "', frequencia=" + frequencia + "GHz}";
    }
}

class Computador {
    private int id;
    private String marca;
    private Processador processador;

    public Computador(int id, String marcaComputador, String marcaProcessador, String modeloProcessador, double frequencia) {
        this.id = id;
        this.marca = marcaComputador;
        this.processador = new Processador(marcaProcessador, modeloProcessador, frequencia);
    }

    @Override
    public String toString() {
        return "Computador{id=" + id + 
               ", marca='" + marca + 
               "', processador=" + processador + "}";
    }

    public Processador getProcessador() {
        return processador;
    }
}

public class ExercicioComputador {
    public static void main(String[] args) {
        System.out.println("Criando computador...\n");

        Computador pc = new Computador(
            1001,
            "Dell",
            "Intel",
            "Core i7-13700K",
            5.4
        );

        Processador proc = pc.getProcessador();

        System.out.println("Antes de perder a referência ao computador:");
        System.out.println(pc);
        System.out.println("Processador acessível: " + proc);
        System.out.println();

        pc = null;

        System.out.println("Depois de pc = null (computador sem referência):");
        System.out.println("Referência ao computador: " + pc);

        System.out.println("\nTentativa de acessar processador pela referência antiga:");
        if (proc != null) {
            System.out.println("Processador ainda acessível: " + proc);
        } else {
            System.out.println("Processador também foi coletado.");
        }

        System.out.println("\nNota: Em Java não temos destrutor explícito.");
        System.out.println("   Quando não há mais referências ao Computador,");
        System.out.println("   o Processador também fica sem referência e se torna elegível para GC.");
        System.out.println("   Isso demonstra composição (todo-parte forte).");
    }
}
