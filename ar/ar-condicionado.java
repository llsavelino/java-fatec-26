public class ArCondicionado {
    private String marca;
    private String modelo;
    private int temperatura;
    private boolean ligado;

    public ArCondicionado() {
        this.marca = "Generico";
        this.modelo = "Standard";
        this.temperatura = 24;
        this.ligado = false;
    }

    public ArCondicionado(String marca, String modelo, int temperatura) {
        this.marca = marca;
        this.modelo = modelo;
        this.temperatura = temperatura;
        this.ligado = false;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        if (temperatura >= 16 && temperatura <= 30) {
            this.temperatura = temperatura;
        } else {
            System.out.println("Erro: Temperatura deve estar entre 16 e 30 graus.");
        }
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public void ajustarTemperatura(int novaTemp) {
        if (ligado) {
            setTemperatura(novaTemp);
        } else {
            System.out.println("O aparelho esta desligado. Nao e possivel ajustar a temperatura.");
        }
    }

    public void modoTurbo() {
        if (ligado) {
            processarResfriamentoRapido();
        }
    }

    private void processarResfriamentoRapido() {
        System.out.println("Aumentando rotacao do compressor...");
        System.out.println("Ligando ventilacao maxima...");
        setTemperatura(16);
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Temperatura: " + temperatura + ", Ligado: " + (ligado ? "Sim" : "Nao");
    }
}
