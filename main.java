public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1234, 567, "João Silva");
        ArCondicionado ac = new ArCondicionado("Samsung", "Eco", 22);

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
    }
}
