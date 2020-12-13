package br.edu.ifnmg.entidade;

public class Diretor extends Funcionario{
    private double bonificacao;

    public Diretor(String nome, String cpf, char sexo, int idade, double salario) {
        super(nome, cpf, sexo, idade, salario);
    }
}
