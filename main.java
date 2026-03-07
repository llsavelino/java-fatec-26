public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1234, 567, "João Silva");

        conta1.depositar(500);
        conta1.sacar(200);

        System.out.println(conta1);

        conta1.sacar(300);
        conta1.encerrarConta();

        System.out.println(conta1);
    }
}
