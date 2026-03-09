public class Streaming {
    private String usuario;
    private String plano;
    private float mensalidade;
    private boolean ativo;
    private String ultimoFilmeAssistido;

    public Streaming(String usuario, String plano) {
        this.usuario = usuario;
        this.plano = plano;
        this.ativo = true;
        this.ultimoFilmeAssistido = "";

        if (plano.equals("Básico")) {
            this.mensalidade = 25.90f;
        } else if (plano.equals("Premium")) {
            this.mensalidade = 45.90f;
        } else if (plano.equals("Família")) {
            this.mensalidade = 60.90f;
        }
    }

    public void assistirFilme(String nomeFilme) {
        if (ativo) {
            this.ultimoFilmeAssistido = nomeFilme;
            System.out.println("Assistindo: " + nomeFilme);
        } else {
            System.out.println("precisa pagar a fatura.");
        }
    }

    public void cancelarAssinatura() {
        this.ativo = false;
    }

    public String toString() {
        String status = ativo ? "Ativo" : "Suspenso";
        return "Usuário: " + usuario + " | Plano: " + plano + " | Mensalidade: $" + mensalidade + " | Status: " + status + " | Último filme assistido: " + ultimoFilmeAssistido;
    }
}
