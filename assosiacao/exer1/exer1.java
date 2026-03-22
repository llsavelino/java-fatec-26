import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaClinicaMedica {

    static class Medico {
        private int id;
        private String nome;
        private String especialidade;

        public Medico(int id, String nome, String especialidade) {
            this.id = id;
            this.nome = nome;
            this.especialidade = especialidade;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEspecialidade() {
            return especialidade;
        }

        @Override
        public String toString() {
            return "Dr(a). " + nome + " - " + especialidade + " (ID: " + id + ")";
        }
    }

    static class Paciente {
        private int id;
        private String nome;
        private String cpf;

        public Paciente(int id, String nome, String cpf) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        @Override
        public String toString() {
            return nome + " - CPF: " + cpf + " (ID: " + id + ")";
        }
    }

    static class Consulta {
        private Medico medico;
        private Paciente paciente;
        private LocalDateTime dataHora;
        private double valorDaConsulta;

        public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora, double valorDaConsulta) {
            this.medico = medico;
            this.paciente = paciente;
            this.dataHora = dataHora;
            this.valorDaConsulta = valorDaConsulta;
        }

        public Medico getMedico() {
            return medico;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public LocalDateTime getDataHora() {
            return dataHora;
        }

        public double getValorDaConsulta() {
            return valorDaConsulta;
        }

        public String getDataFormatada() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return dataHora.format(formatter);
        }

        @Override
        public String toString() {
            return "Consulta:\n" +
                   "  Data/Hora: " + getDataFormatada() + "\n" +
                   "  Médico:    " + medico + "\n" +
                   "  Paciente:  " + paciente + "\n" +
                   "  Valor:     R$ " + String.format("%.2f", valorDaConsulta);
        }
    }

    public static void main(String[] args) {

        Medico medico1 = new Medico(101, "Ana Claudia Ribeiro", "Cardiologia");

        Paciente paciente1 = new Paciente(1001, "João Pedro Almeida", "123.456.789-00");

        LocalDateTime dataConsulta = LocalDateTime.of(2026, 5, 20, 14, 30);

        Consulta consulta1 = new Consulta(
            medico1,
            paciente1,
            dataConsulta,
            380.00
        );

        System.out.println("=== REGISTRO DE CONSULTA ===");
        System.out.println(consulta1);
        System.out.println("============================");
    }
}
