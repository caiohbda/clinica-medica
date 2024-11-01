package models;

public class Receituario {
    private Consulta consulta;
    private String prescricoes;

    public Receituario(Consulta consulta, String prescricoes) {
        if (prescricoes == null || prescricoes.trim().isEmpty()) {
            throw new IllegalArgumentException("As prescrições não podem ser nulas ou vazias.");
        }
        this.consulta = consulta;
        this.prescricoes = prescricoes;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public String getPrescricoes() {
        return prescricoes;
    }

    public void exibirInformacoes() {
        System.out.println("Consulta com: " + consulta.getMedico().getNome());
        System.out.println("Paciente: " + consulta.getPaciente().getNome());
        System.out.println("Data da Consulta: " + consulta.getData());
        System.out.println("Prescrições: " + prescricoes);
    }
}
