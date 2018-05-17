package br.com.digitec.analise.dados.venda.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.digitec.analise.dados.venda.bean.IGenericBean;
import br.com.digitec.analise.dados.venda.bean.Venda;
import br.com.digitec.analise.dados.venda.bean.VendaItem;
import br.com.digitec.analise.dados.venda.bean.Vendedor;

public class VendaParser implements IParser{

    private final static int TIPO_ID_INDEX = 0;
    private final static int ID_INDEX = 1;
    private final static int ITEMS_INDEX = 2;
    private final static int NOME_VENDEDOR_INDEX = 3;
    private final VendaItemParser vendaItemParser;

    public VendaParser() {
        this.vendaItemParser = new VendaItemParser();
    }

    @Override
    public IGenericBean parser(List<String> dadosVenda) {
        List<VendaItem> listaDeItensVenda = new ArrayList<>();
        List<String> listaDadosItensVenda = Arrays.asList(clearDadoItemVenda(dadosVenda).split(","));

        listaDadosItensVenda.forEach(dadosItemVenda->{
            listaDeItensVenda.add((VendaItem)vendaItemParser.parser(Arrays.asList(dadosItemVenda.split("-"))));
        });

        IGenericBean venda  = new Venda(
                dadosVenda.get(TIPO_ID_INDEX),
                dadosVenda.get(ID_INDEX),
                listaDeItensVenda,
                new Vendedor(dadosVenda.get(NOME_VENDEDOR_INDEX)));

        return venda;
    }

    /**
     * 
     * @param dadosVenda
     * @return
     */
    private String clearDadoItemVenda(List<String> dadosVenda) {
        return dadosVenda.get(ITEMS_INDEX).replace("[","").replace("]","");
    }
}
