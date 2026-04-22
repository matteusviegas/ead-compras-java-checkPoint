package br.com.eda.compras.demo.producer;

import br.com.eda.compras.demo.config.JmsConfig;
import br.com.eda.compras.demo.model.CompraRequest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompraProducer {

    private final JmsTemplate jmsTemplate;

    public CompraProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void enviarParaFila(CompraRequest compra) {

        System.out.println("[PRODUCER] Enviando compra para fila: " + compra.getId());

        jmsTemplate.convertAndSend(JmsConfig.FILA_COMPRA, compra);
    }
}