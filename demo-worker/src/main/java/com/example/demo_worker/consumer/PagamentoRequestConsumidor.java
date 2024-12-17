package com.example.demo_worker.consumer;

import com.example.demo_worker.producer.PagamentoErroProduto;
import com.example.demo_worker.producer.PagamentoSucessoProduto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumidor {

    @Autowired
    private PagamentoErroProduto erroProduto;
    @Autowired
    private PagamentoSucessoProduto sucessoProduto;

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message messege){
        System.out.println(messege);
        if (new Random().nextBoolean()){
            sucessoProduto.gerarResposta("Mensagem de sucesso Pagamento " + messege);
        }
        else {
            erroProduto.gerarResposta("ERRO no pagamento "+ messege);
        }
    }
}
