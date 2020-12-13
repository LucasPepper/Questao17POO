package br.edu.ifnmg.entidade;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected char sexo;
    protected int idade;
    protected double salario;

    public Funcionario(String nome, String cpf, char sexo, int idade, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public double getSalario() {
        return salario;
    }

}
