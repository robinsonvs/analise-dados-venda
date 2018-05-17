package br.com.digitec.analise.dados.venda.starter;

import br.com.digitec.analise.dados.venda.model.Processador;
import br.com.digitec.analise.dados.venda.model.Factory;
import br.com.digitec.analise.dados.venda.model.Relatorio;

public class Starter {

    private Processador processador;
    private Factory factory;
    private Relatorio relatorio;

    public Starter() {
        this.processador = new Processador();
        this.factory = new Factory();
        this.relatorio = new Relatorio();
    }

    public void executar(){
        processador.processar(factory, relatorio);
    }
}
