package br.com.digitec.analise.dados.venda.model;

import java.util.ArrayList;
import java.util.List;

import br.com.digitec.analise.dados.venda.bean.Venda;
import br.com.digitec.analise.dados.venda.bean.VendaItem;

public class VendaModel {
    private List<Venda> listVenda;

    public VendaModel() {
        this.listVenda = new ArrayList<>();
    }

    public void add(Venda venda){
        listVenda.add(venda);
    }

    public List<Venda> getAll(){
        return listVenda;
    }

    public void addItemSale(VendaItem vendaItem, String vendaId){
        listVenda.forEach(venda -> {
            if(venda.getId().equals(vendaId)){
            	venda.getVendaItem().add(vendaItem);
            }
        });
    }


}
