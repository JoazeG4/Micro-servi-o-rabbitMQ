package com.example.demo_backend.consumer;

import com.example.demo_backend.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseSucessoConsumidor {

    @Autowired
    private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.sucessoPagamento(payload);
    }
}
