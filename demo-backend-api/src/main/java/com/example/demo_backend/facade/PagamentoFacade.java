package com.example.demo_backend.facade;

import com.example.demo_backend.dto.PagamentoDto;
import com.example.demo_backend.producer.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    @Autowired
    private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDto request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e){
            return "Ocorreu um erro ao solicitar pagamento .." + e.getMessage();
        }
        return "pagamento aguardando comfirmação...";
    }

    public void erroPagamento(String payload) {
        System.err.println("===== RESPOSTA ERRO =====" + payload);
    }

    public void sucessoPagamento(String payload) {
        System.out.println("===== RESPOSTA SUCESSO =====" + payload);
    }
}
