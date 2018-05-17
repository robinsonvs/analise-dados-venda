package br.com.digitec.analise.dados.venda.model;

import java.util.ArrayList;
import java.util.List;

import br.com.digitec.analise.dados.venda.bean.Vendedor;

public class VendedorModel {

    private List<Vendedor> listaVendedor;

    public VendedorModel() {
        this.listaVendedor = new ArrayList<Vendedor>();
    }

    public void add(Vendedor newVendedor){
        boolean isJaExiste = isExisteVendedor(newVendedor);
        if(!isJaExiste){
            listaVendedor.add(newVendedor);
        }
    }

    private boolean isExisteVendedor(Vendedor newVendedor) {
        return listaVendedor.stream()
                .anyMatch(oldVendedor -> {
                    if(isNomeJaExiste(newVendedor, oldVendedor) && oldVendedor.getCpf().isEmpty()){
                        if(!newVendedor.getCpf().isEmpty()) {
                            atualizaVendedor(newVendedor, oldVendedor);
                        }
                        return true;
                    }else{
                        return false;
                    }
                });
    }

    private void atualizaVendedor(Vendedor newVendedor, Vendedor oldVendedor) {
        oldVendedor.setCpf(newVendedor.getCpf());
        oldVendedor.setSalario(newVendedor.getSalario());
        oldVendedor.setId(newVendedor.getId());
    }

    public List<Vendedor> getAll(){
        return listaVendedor;
    }

    private boolean isNomeJaExiste(Vendedor newVendedor, Vendedor vendedor) {
        return vendedor.getNome().toUpperCase().equals(newVendedor.getNome().toUpperCase());
    }


}
