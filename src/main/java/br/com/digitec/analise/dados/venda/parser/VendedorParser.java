package br.com.digitec.analise.dados.venda.parser;

import java.math.BigDecimal;
import java.util.List;

import br.com.digitec.analise.dados.venda.bean.IGenericBean;
import br.com.digitec.analise.dados.venda.bean.Vendedor;

public class VendedorParser implements IParser{

    private final static int TIPO_ID_INDEX = 0;
    private final static int CPF_INDEX = 1;
    private final static int NOME_INDEX = 2;
    private final static int SALARIO = 3;

    @Override
    public IGenericBean parser(List<String> dadosVendedor) {
        IGenericBean vendedor  = new Vendedor(
                dadosVendedor.get(TIPO_ID_INDEX),
                dadosVendedor.get(CPF_INDEX),
                dadosVendedor.get(NOME_INDEX),
                new BigDecimal(dadosVendedor.get(SALARIO).replace(",",".")));

        return vendedor;
    }

    /**
     * 
     * @param nomeVendedor
     * @return
     */
    public IGenericBean extract(String nomeVendedor) {
        IGenericBean vendedor  = new Vendedor(nomeVendedor);
        return vendedor;
    }
}
