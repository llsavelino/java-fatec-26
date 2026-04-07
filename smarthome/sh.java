interface Autenticavel {
    void validarAcesso(String senha);
}

interface DispositivoLigavel {
    void ligar();
    void desligar();
}

interface SensorTemperatura {
    double lerTemperatura();
}

// ====================== CLASSES ======================

class FechaduraEletronica implements Autenticavel, DispositivoLigavel {
    
    private boolean trancada = true;
    private final String senhaCorreta = "123456";
    
    @Override
    public void validarAcesso(String senha) {
        if (senha.equals(senhaCorreta)) {
            System.out.println("✅ Acesso concedido! Fechadura destrancada.");
            trancada = false;
        } else {
            System.out.println("❌ Senha incorreta! Acesso negado.");
        }
    }
    
    @Override
    public void ligar() {
        if (!trancada) {
            System.out.println("🔓 Fechadura: Porta DESTRANCADA (ligada)");
        } else {
            System.out.println("⚠️  Fechadura está trancada. Valide o acesso primeiro.");
        }
    }
    
    @Override
    public void desligar() {
        trancada = true;
        System.out.println("🔒 Fechadura: Porta TRANCADA (desligada)");
    }
}

class TermostatoSmart implements DispositivoLigavel, SensorTemperatura {
    
    private boolean ligado = false;
    private double temperaturaAtual = 23.5; // Temperatura simulada
    
    @Override
    public void ligar() {
        ligado = true;
        System.out.println("🌡️  Termostato ligado. Controlando temperatura...");
    }
    
    @Override
    public void desligar() {
        ligado = false;
        System.out.println("❄️  Termostato desligado.");
    }
    
    @Override
    public double lerTemperatura() {
        if (ligado) {
            // Simula pequena variação de temperatura
            temperaturaAtual += (Math.random() * 0.8 - 0.4);
            System.out.printf("📊 Temperatura atual: %.1f°C%n", temperaturaAtual);
            return temperaturaAtual;
        } else {
            System.out.println("⚠️  Termostato está desligado. Não é possível ler temperatura.");
            return -1;
        }
    }
    
    // Método extra para demonstrar funcionalidade
    public void ajustarTemperaturaDesejada(double desejada) {
        if (ligado) {
            System.out.printf("🎯 Ajustando temperatura desejada para %.1f°C%n", desejada);
        } else {
            System.out.println("❌ Termostato desligado. Ligue-o primeiro.");
        }
    }
}

// ====================== MAIN ======================

public class SmartHome {
    public static void main(String[] args) {
        
        System.out.println("🏠 SISTEMA DE CASA INTELIGENTE INICIADO\n");
        
        // Criando os dispositivos
        FechaduraEletronica fechadura = new FechaduraEletronica();
        TermostatoSmart termostato = new TermostatoSmart();
        
        // ==================== TESTANDO FECHADURA ====================
        System.out.println("=== TESTE DA FECHADURA ELETRÔNICA ===");
        
        fechadura.ligar();                    // Deve falhar (trancada)
        fechadura.validarAcesso("senhaerrada"); // Senha errada
        fechadura.validarAcesso("123456");      // Senha correta
        fechadura.ligar();                      // Agora deve funcionar
        fechadura.desligar();                   // Tranca novamente
        
        System.out.println("\n=== TESTE DO TERMOSTATO SMART ===");
        
        // Testando termostato desligado
        termostato.lerTemperatura();
        
        // Ligando o termostato
        termostato.ligar();
        
        // Lendo temperatura várias vezes
        termostato.lerTemperatura();
        termostato.lerTemperatura();
        
        termostato.ajustarTemperaturaDesejada(22.0);
        
        termostato.desligar();
        termostato.lerTemperatura(); // Deve falhar
        
        System.out.println("\n🏠 Fim do sistema Smart Home!");
    }
}
