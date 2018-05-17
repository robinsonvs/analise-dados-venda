package br.com.digitec.analise.dados.venda.parser;

import java.util.List;

import br.com.digitec.analise.dados.venda.bean.IGenericBean;
import br.com.digitec.analise.dados.venda.bean.Cliente;

public class ClienteParser implements IParser{

    private final static int TIPO_ID_INDEX = 0;
    private final static int CNPJ_INDEX = 1;
    private final static int NOME_INDEX = 2;
    private final static int BUSSINESS_AREA_INDEX = 3;

    @Override
    public IGenericBean parser(List<String> dadosCliente) {
        IGenericBean cliente  = new Cliente(
                dadosCliente.get(TIPO_ID_INDEX),
                dadosCliente.get(CNPJ_INDEX),
                dadosCliente.get(NOME_INDEX),
                dadosCliente.get(BUSSINESS_AREA_INDEX));

        return cliente;
    }
}
