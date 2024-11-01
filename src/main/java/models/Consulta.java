package models;

import java.util.Date;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private Date data;

    public Consulta(Medico medico, Paciente paciente, Date data) {
        if (data.before(new Date())) {
            throw new IllegalArgumentException("A data da consulta não pode ser no passado.");
        }
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        if (data.before(new Date())) {
            throw new IllegalArgumentException("A data da consulta não pode ser no passado.");
        }
        this.data = data;
    }

    public void exibirInformacoes() {
        System.out.println("Consulta:");
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Data: " + data);
    }
}
