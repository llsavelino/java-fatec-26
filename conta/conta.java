public class Conta {

    public int numeroConta;
    public int agencia;
    public String nomeCliente;
    public float saldo;
    public boolean status; // true = ativa | false = encerrada

    public Conta(int numeroConta, int agencia, String nomeCliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0f;
        this.status = true;
    }

    public void depositar(float valor) {
        if (!status) {
            System.out.println("Conta inativa.");
            return;
        }

        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(float valor) {
        if (!status) {
            System.out.println("Conta inativa.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void encerrarConta() {
        if (saldo == 0) {
            status = false;
            System.out.println("Conta encerrada com sucesso.");
        } else {
            System.out.println("Não é possível encerrar. Saque o saldo restante primeiro.");
        }
    }

    @Override
    public String toString() {
        return "Conta {" +
                "Número: " + numeroConta +
                ", Agência: " + agencia +
                ", Cliente: " + nomeCliente +
                ", Saldo: R$ " + saldo +
                ", Status: " + (status ? "Ativa" : "Encerrada") +
                '}';
    }
}
