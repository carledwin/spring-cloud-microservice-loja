package com.wordpress.carledwinti.spring.cloud.microservice.loja.dto;

import java.util.List;

public class CompraDto {

    private Long id;
    private List<ItemDaCompraDto> items;
    private EnderecoDto endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDaCompraDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDaCompraDto> items) {
        this.items = items;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "CompraDto{" +
                "id=" + id +
                ", items=" + items +
                ", endereco=" + endereco +
                '}';
    }
}
