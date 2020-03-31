package com.wordpress.carledwinti.spring.cloud.microservice.loja.service;

import com.wordpress.carledwinti.spring.cloud.microservice.loja.Compra;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.client.FornecedorFeignClient;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.CompraDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoFornecedorDto;
import com.wordpress.carledwinti.spring.cloud.microservice.loja.dto.InfoPedidoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CompraService {

    private Logger logger = LoggerFactory.getLogger(CompraService.class);

    //Ja esta integrado com Ribbon, Eureka/EurekaServer, ClientSide LoadBalancer, ja recupera ip e porta que devem ser acessados
    @Autowired
    private FornecedorFeignClient fornecedorFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClientSideRibbon;

    public Compra realizaCompraFeignClient(CompraDto compraDto) {

        InfoFornecedorDto infoFornecedorDtoResponse = fornecedorFeignClient.getInfoByEstado(compraDto.getEndereco().getEstado());
        logger.info("Com Feign: " + infoFornecedorDtoResponse.toString());

        InfoPedidoDto infoPedidoDto = fornecedorFeignClient.realizaPedido(compraDto.getItems());

        Compra compra = new Compra();
        compra.setPedidoId(infoPedidoDto.getId());
        compra.setTempoDePreparo(infoPedidoDto.getTempoDePreparo());
        compra.setEnderecoDestino(compraDto.getEndereco().toString());

        return compra;
    }

    public void realizaCompraDiscoveryClientSideEurekaRibbonLoadBalancer(CompraDto compraDto) {

        ResponseEntity<InfoFornecedorDto> infoFornecedorResponse = restTemplate
                .exchange("http://fornecedor/info/" + compraDto.getEndereco().getEstado(),
                    HttpMethod.GET,
                    null,
                    InfoFornecedorDto.class);

        discoveryClientSideRibbon.getInstances("fornecedor").stream()
                .forEach(fornecedor -> {
                    logger.info("Uri: " + fornecedor.getUri());
                    logger.info("Host: " + fornecedor.getHost());
                    logger.info("Port : " + fornecedor.getPort());
                });

        logger.info("Com DiscoveryClient: " + infoFornecedorResponse.toString());
    }

}
