package com.example.demo_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSucessoProduto {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
                "pagamento-response-sucesso-exchange",
                "pagamento-response-sucesso-rout-key",
                mensagem
        );
    }
}
