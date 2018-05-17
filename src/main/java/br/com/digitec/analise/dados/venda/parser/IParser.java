package br.com.digitec.analise.dados.venda.parser;

import java.util.List;

import br.com.digitec.analise.dados.venda.bean.IGenericBean;

public interface IParser {
    IGenericBean parser(List<String> dados);
}
