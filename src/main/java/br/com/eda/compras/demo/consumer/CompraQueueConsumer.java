package br.com.eda.compras.demo.consumer;

import br.com.eda.compras.demo.config.JmsConfig;
import br.com.eda.compras.demo.model.CompraProcessadaEvent;
import br.com.eda.compras.demo.model.CompraRequest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompraQueueConsumer {

    private final JmsTemplate jmsTemplate;

    public CompraQueueConsumer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = JmsConfig.FILA_COMPRA)
    public void receberCompraDaFila(CompraRequest compra) {
        System.out.println("[QUEUE CONSUMER] Compra recebida da fila: " + compra.getId());
        System.out.println("[QUEUE CONSUMER] Processando compra de: " + compra.getCliente());

        CompraProcessadaEvent evento = new CompraProcessadaEvent(
                compra.getId(),
                compra.getCliente(),
                compra.getProduto(),
                compra.getValor(),
                "PROCESSADA"
        );

        System.out.println("[QUEUE CONSUMER] Publicando evento no tópico: " + evento.getId());

        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(JmsConfig.TOPICO_COMPRA_PROCESSADA, evento);
        jmsTemplate.setPubSubDomain(false);
    }
}