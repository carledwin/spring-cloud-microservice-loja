package com.wordpress.carledwinti.spring.cloud.microservice.loja.dto;

public class EnderecoDto {

    private String endereco;
    private String complemento;
    private Integer numero;
    private String estado;

    public String getEndereco() {
        return endereco;
    }

    public void setLogradouro(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                '}';
    }
}
