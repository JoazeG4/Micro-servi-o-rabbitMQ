package com.example.demo_backend.api;

import com.example.demo_backend.dto.PagamentoDto;
import com.example.demo_backend.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {

    @Autowired
    private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDto request){
        return pagamentoFacade.solicitarPagamento(request);

    }
}