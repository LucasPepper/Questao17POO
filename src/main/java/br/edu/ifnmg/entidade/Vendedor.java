package br.edu.ifnmg.entidade;

public class Vendedor extends Funcionario{
    private double bonificacao;
    public Vendedor(String nome, String cpf, char sexo, int idade, double salario) {
        super(nome, cpf, sexo, idade, salario);
    }
}
