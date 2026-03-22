import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int duracao;

    public Filme(int id, String titulo, String genero, int duracao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme [ID=" + id + ", Titulo=" + titulo + ", Genero=" + genero + ", Duracao=" + duracao + " min]";
    }
}

class Ingresso {
    private int id;
    private String assento;
    private String tipo;
    private float preco;

    public Ingresso(int id, String assento, String tipo, float preco) {
        this.id = id;
        this.assento = assento;
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Ingresso [ID=" + id + ", Assento=" + assento + ", Tipo=" + tipo + ", Preco=R$" + preco + "]";
    }
}

class Sessao {
    private int id;
    private LocalDateTime horario;
    private int sala;
    private Filme filme;
    private ArrayList<Ingresso> ingressos;

    public Sessao(int id, LocalDateTime horario, int sala) {
        this.id = id;
        this.horario = horario;
        this.sala = sala;
        this.ingressos = new ArrayList<>();
    }

    public void vincularFilme(Filme f) {
        this.filme = f;
    }

    public void venderIngresso(int id, String assento, String tipo, float preco) {
        Ingresso novoIngresso = new Ingresso(id, assento, tipo, preco);
        this.ingressos.add(novoIngresso);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- SESSÃO ---").append("\n");
        sb.append("Sala: ").append(sala).append(" | Horário: ").append(horario.format(formatador)).append("\n");
        sb.append(filme != null ? filme.toString() : "Nenhum filme vinculado").append("\n");
        sb.append("Ingressos Vendidos:\n");
        
        if (ingressos.isEmpty()) {
            sb.append("  Nenhum ingresso vendido.\n");
        } else {
            for (Ingresso ingresso : ingressos) {
                sb.append("  - ").append(ingresso.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}

public class TestaCinema {
    public static void main(String[] args) {
        Filme filme1 = new Filme(1, "Batman", "Ação", 176);
        Filme filme2 = new Filme(2, "Duna", "Ficção Científica", 155);

        Sessao sessao = new Sessao(1, LocalDateTime.of(2026, 7, 20, 20, 0), 1);

        sessao.vincularFilme(filme1);

        sessao.venderIngresso(1, "A1", "Inteira", 40.0f);
        sessao.venderIngresso(2, "A2", "Meia", 20.0f);
        sessao.venderIngresso(3, "A3", "Inteira", 40.0f);

        System.out.println(sessao.toString());
    }
}
