package br.edu.ifnmg.entidade;

import java.util.HashMap;

public class ResultadoMensal {

    private final double meta;
    private final double lucro;
    private final HashMap<Vendedor, Double> mapaVendedorVendas;
    private final HashMap<Operario, Integer> mapaOperarioFaltas;

    public ResultadoMensal(int mes, double meta, double lucro, HashMap<Vendedor, Double> mapaVendedorVendas,
                           HashMap<Operario, Integer> mapaOperarioFaltas) {
        this.meta = meta;
        this.lucro = lucro;
        this.mapaVendedorVendas = mapaVendedorVendas;
        this.mapaOperarioFaltas = mapaOperarioFaltas;
    }

    public double getMeta() {
        return meta;
    }

    public double getLucro() {
        return lucro;
    }

    public HashMap<Vendedor, Double> getMapaVendedorVendas() {
        return mapaVendedorVendas;
    }

    public HashMap<Operario, Integer> getMapaOperarioFaltas() {
        return mapaOperarioFaltas;
    }

}
