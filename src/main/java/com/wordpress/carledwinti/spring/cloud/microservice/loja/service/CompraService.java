package com.wordpress.carledwinti.spring.cloud.microservice.loja.service;

import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.CompraDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoFornecedorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CompraService {

    private Logger logger = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private RestTemplate restTemplate;

    public void realizaCompra(CompraDto compraDto) {

        ResponseEntity<InfoFornecedorDto> infoFornecedorResponse = restTemplate
                .exchange("http://fornecedor/info/" + compraDto.getEndereco().getEstado(),
                    HttpMethod.GET,
                    null,
                    InfoFornecedorDto.class);

        logger.info(infoFornecedorResponse.toString());
    }
}
