package br.edu.ifnmg;

import br.edu.ifnmg.entidade.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private static final HashMap<Integer, ResultadoMensal> mapaMesResultados = new HashMap<>();
    private static final HashMap<Vendedor, Double> mapaVendedorVendas = new HashMap<>();
    private static final HashMap<Operario, Integer> mapaOperarioFaltas = new HashMap<>();
    private static final HashMap<Funcionario, BonificacaoMensal> mapaFuncionarioBonificacao = new HashMap<>();
    // Mapa Mês - (Funcionário - Bonificação)
    // private static final HashMap<Integer, HashMap<Funcionario, Double>> mapaMesMapaFuncionarioBonificacao = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carregarListaFuncionarios();
        System.out.println("Informe o nº do mês para cálculo dos resultados:");
        try {
            int mes = Integer.parseInt(scanner.nextLine());

            if (mes < 1 || mes > 12){
                throw new IllegalArgumentException("Mês inválido!");
            }
            registrarResultadoMensal(mes);
            System.out.printf("RESULTADOS DO MÊS %d:%n", mes);
            recuperarResultadosMes(mes);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void recuperarResultadosMes(int mes) {

        ResultadoMensal resultadoMensal = mapaMesResultados.get(mes);
        System.out.printf("META: %.2f%n", resultadoMensal.getMeta());
        System.out.printf("LUCRO: %.2f%n", resultadoMensal.getLucro());
        System.out.println("BONIFICAÇÕES:");
        for (Map.Entry<Funcionario, BonificacaoMensal> entry : mapaFuncionarioBonificacao.entrySet()) {
            System.out.printf("%s (%s): R$ %.2f%n",
                    entry.getKey().getNome(), entry.getKey().getClass().getName(),
                    entry.getValue().getValor());
        }

    }

    private static void registrarResultadoMensal(int mes) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe a Meta: ");
            double meta = Double.parseDouble(scanner.nextLine());
            if (meta <= 0){
                throw new IllegalArgumentException("Meta inválida!");
            }
            System.out.println("Informe o Lucro: ");
            double lucro = Double.parseDouble(scanner.nextLine());
            if (lucro < 0){
                throw new IllegalArgumentException("Lucro inválido!");
            }

            double valorVendasMensal;
            System.out.println("Informe as Vendas:");
            for (Funcionario vendedor : listaFuncionarios) {
                if (vendedor instanceof Vendedor) {
                    System.out.printf("%s:", vendedor.getNome());
                    valorVendasMensal = Double.parseDouble(scanner.nextLine());
                    if (valorVendasMensal < 0){
                        throw new IllegalArgumentException("Valor de Vendas inválido!");
                    }
                    mapaVendedorVendas.put((Vendedor) vendedor, valorVendasMensal);
                }
            }

            int numeroFaltasMensal;
            System.out.println("Informe as faltas dos Operários:");
            for (Funcionario operario : listaFuncionarios) {
                if (operario instanceof Operario) {
                    System.out.printf("%s:", operario.getNome());
                    numeroFaltasMensal = Integer.parseInt(scanner.nextLine());
                    if (numeroFaltasMensal < 0){
                        throw new IllegalArgumentException("Nº de faltas inválido!");
                    }
                    mapaOperarioFaltas.put((Operario) operario, numeroFaltasMensal);
                }
            }

            ResultadoMensal resultadoMensal = new ResultadoMensal(mes, meta, lucro, mapaVendedorVendas, mapaOperarioFaltas);

            mapaMesResultados.put(mes, resultadoMensal);
            for (Funcionario funcionario: listaFuncionarios) {
                BonificacaoMensal bonificacaoMensal =  new BonificacaoMensal(mes, funcionario, resultadoMensal);
                mapaFuncionarioBonificacao.put(funcionario, bonificacaoMensal);
            }

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    private static void carregarListaFuncionarios() {
        Diretor diretor = new Diretor("José", "111.111.111-11", 'M', 50, 10000);
        Vendedor vendedor1 = new Vendedor("João", "222.222.222-22", 'M', 30, 2000);
        Vendedor vendedor2 = new Vendedor("Maria", "333.333.333-33", 'F', 28, 2000);
        Operario operario = new Operario("Pedro", "444.444.444-44", 'M', 25, 1500);
        FuncAdministrativo funcAdministrativo = new FuncAdministrativo
                ("Fábio", "555.555.555-55", 'M', 32, 1500);
        FuncManutencao funcManutencao = new FuncManutencao
                ("Francisco", "666.666.666-66", 'M', 40, 1500);

        listaFuncionarios.add(diretor);
        listaFuncionarios.add(vendedor1);
        listaFuncionarios.add(vendedor2);
        listaFuncionarios.add(operario);
        listaFuncionarios.add(funcAdministrativo);
        listaFuncionarios.add(funcManutencao);

    }

}
