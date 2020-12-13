package br.edu.ifnmg.entidade;

public class Operario extends Funcionario{
    private double bonificacao;

    public Operario(String nome, String cpf, char sexo, int idade, double salario) {
        super(nome, cpf, sexo, idade, salario);
    }
}
