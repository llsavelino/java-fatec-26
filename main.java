public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1234, 567, "João Silva");
        ArCondicionado ac = new ArCondicionado("Samsung", "Eco", 22);
        Placar placar = new Placar("Corinthians", "Flamengo");
        Streaming streaming = new Streaming("Alguém", "Premium");

        conta1.depositar(500);
        conta1.sacar(200);

        System.out.println(conta1);

        conta1.sacar(300);
        conta1.encerrarConta();

        System.out.println(conta1);

        ac.ajustarTemperatura(10);
        ac.ajustarTemperatura(25);
        
        System.out.println(ac);
        
        ac.modoTurbo();
        ac.ligar();
        ac.modoTurbo();
        
        System.out.println(ac);

        placar.registrarPonto("Corinthians", 3);
        System.out.println(placar);

        streaming.assistirFilme("Star Wars");
        System.out.println(streaming);
    }
}
