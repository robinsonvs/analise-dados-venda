package br.com.digitec.analise.dados.venda.parser;

import java.math.BigDecimal;
import java.util.List;

import br.com.digitec.analise.dados.venda.bean.IGenericBean;
import br.com.digitec.analise.dados.venda.bean.VendaItem;

public class VendaItemParser implements IParser{

    private final static int TIPO_ID_INDEX = 0;
    private final static int QUANTIDADE = 1;
    private final static int PRECO = 2;

    @Override
    public IGenericBean parser(List<String> vendaItemDados) {
        IGenericBean vendaItem  = new VendaItem(
                vendaItemDados.get(TIPO_ID_INDEX),
                Long.valueOf(vendaItemDados.get(QUANTIDADE)),
                new BigDecimal(vendaItemDados.get(PRECO).replace(",",".")));

        return vendaItem;
    }
}
