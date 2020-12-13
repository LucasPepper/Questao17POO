package br.edu.ifnmg.entidade;

public class BonificacaoMensal {

    private static final double PORCENTAGEM_BONIFICACAO_DIRETOR = 0.1;
    private static final double PORCENTAGEM_BONIFICACAO_VENDEDOR = 0.01;
    private static final double PORCENTAGEM_BONIFICACAO_OPERARIO = 0.05;

    private final Funcionario funcionario;
    private final double valor;
    private final ResultadoMensal resultadoMensal;

    public BonificacaoMensal(int mes, Funcionario funcionario, ResultadoMensal resultadoMensal) {
        this.funcionario = funcionario;
        this.resultadoMensal = resultadoMensal;
        this.valor = calcularBonificacao();
    }

    public double getValor() {
        return this.valor;
    }

    public double calcularBonificacao(){

        double valorBonificacao = 0;
        if (this.funcionario instanceof Diretor) {
            if (this.resultadoMensal.getLucro() >= this.resultadoMensal.getMeta()) {
                valorBonificacao =
                        this.resultadoMensal.getLucro() * PORCENTAGEM_BONIFICACAO_DIRETOR;

            }
        }else if (this.funcionario instanceof Vendedor){
            double totalVendas = this.resultadoMensal.getMapaVendedorVendas().get(funcionario);
            valorBonificacao =
                    PORCENTAGEM_BONIFICACAO_VENDEDOR * totalVendas;

        }else if (this.funcionario instanceof Operario){
            int totalFaltas = this.resultadoMensal.getMapaOperarioFaltas().get(funcionario);

            if (totalFaltas == 0){
                valorBonificacao =
                        this.funcionario.getSalario() * PORCENTAGEM_BONIFICACAO_OPERARIO;
            }
        }

        return valorBonificacao;
    }

}
