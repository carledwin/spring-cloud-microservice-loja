package com.wordpress.carledwinti.spring.cloud.microservice.loja.client;

import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoFornecedorDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoPedidoDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.ItemDaCompraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorFeignClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDto getInfoByEstado(@PathVariable String estado);

    @PostMapping("/pedidos/new")
    InfoPedidoDto realizaPedido(List<ItemDaCompraDto> items);
}