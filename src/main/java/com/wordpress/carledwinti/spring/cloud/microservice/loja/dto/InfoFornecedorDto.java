package com.wordpress.carledwinti.spring.cloud.microservice.loja.dto;

public class InfoFornecedorDto {
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    private String logradouro;

    @Override
    public String toString() {
        return "InfoFornecedorDto{" +
                "logradouro='" + logradouro + '\'' +
                '}';
    }
}
