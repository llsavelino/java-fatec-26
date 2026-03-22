import java.time.LocalDate;

class Leitor {
    private int id;
    private String nome;

    public Leitor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Leitor{id=" + id + ", nome='" + nome + "'}";
    }
}

class Livro {
    private int id;
    private String titulo;
    private String autor;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }
}

class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Emprestimo(Leitor leitor, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.leitor = leitor;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    @Override
    public String toString() {
        return "Empréstimo{" +
               "leitor=" + leitor.getNome() + 
               " (ID: " + leitor.getId() + "), " +
               "livro='" + livro.getTitulo() + "'" +
               ", dataEmpréstimo=" + dataEmprestimo +
               ", devolução prevista=" + dataDevolucaoPrevista +
               '}';
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        Leitor leitor1 = new Leitor(1, "Ana Silva");
        Livro livro1 = new Livro(101, "Dom Casmurro", "Machado de Assis");

        LocalDate hoje = LocalDate.now();
        LocalDate devolucao = hoje.plusDays(14);

        Emprestimo emp1 = new Emprestimo(leitor1, livro1, hoje, devolucao);

        System.out.println(emp1);
    }
}
