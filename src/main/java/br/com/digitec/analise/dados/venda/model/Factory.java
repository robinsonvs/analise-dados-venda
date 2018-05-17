package br.com.digitec.analise.dados.venda.model;

import br.com.digitec.analise.dados.venda.bean.Cliente;
import br.com.digitec.analise.dados.venda.bean.Venda;
import br.com.digitec.analise.dados.venda.bean.Vendedor;
import br.com.digitec.analise.dados.venda.parser.ClienteParser;
import br.com.digitec.analise.dados.venda.parser.VendaParser;
import br.com.digitec.analise.dados.venda.parser.VendedorParser;

import java.util.List;


public class Factory {
    public static final int TIPO = 0;
    public static final String VENDEDOR = "001";
    public static final String CLIENTE = "002";
    public static final String VENDA = "003";
    private ClienteParser clienteParser;
    private VendaParser vendaParser;
    private VendedorParser vendedorParser;
    private ClienteModel clienteModel;
    private VendaModel vendaModel;
    private VendedorModel vendedorModel;


    public Factory() {
        this.clienteParser = new ClienteParser();
        this.vendaParser = new VendaParser();
        this.vendedorParser = new VendedorParser();
        this.clienteModel = new ClienteModel();
        this.vendaModel = new VendaModel();
        this.vendedorModel = new VendedorModel();
    }

    public void processarParsers(List<String> dataModel){
        switch (dataModel.get(TIPO)) {
		case VENDEDOR:
			vendedorModel.add((Vendedor)vendedorParser.parser(dataModel));
			break;
		case CLIENTE:
			clienteModel.add((Cliente)clienteParser.parser(dataModel));
			break;
		case VENDA:
			vendaModel.add((Venda)vendaParser.parser(dataModel));
			break;			
		default:
			break;
		}
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public VendaModel getVendaModel() {
        return vendaModel;
    }

    public VendedorModel getVendedorModel() {
        return vendedorModel;
    }
}
