package com.wordpress.carledwinti.spring.cloud.microservice.loja.client;

import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoFornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fornecedor")
public interface FornecedorFeignClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDto getInfoByEstado(@PathVariable String estado);
}