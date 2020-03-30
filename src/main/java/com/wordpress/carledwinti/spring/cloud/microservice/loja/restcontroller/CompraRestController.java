package com.wordpress.carledwinti.spring.cloud.microservice.loja.restcontroller;

import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.CompraDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraRestController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public void realizarCompra(@RequestBody CompraDto compraDto){
        compraService.realizaCompra(compraDto);
    }
}