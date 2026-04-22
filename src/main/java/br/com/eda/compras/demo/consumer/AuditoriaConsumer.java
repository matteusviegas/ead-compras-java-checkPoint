package br.com.eda.compras.demo.consumer;

import br.com.eda.compras.demo.config.JmsConfig;
import br.com.eda.compras.demo.model.CompraProcessadaEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaConsumer {

    @JmsListener(destination = JmsConfig.TOPICO_COMPRA_PROCESSADA, containerFactory = "topicListenerFactory")
    public void registrarAuditoria(CompraProcessadaEvent event) {
        System.out.println("[AUDITORIA] Evento recebido do tópico.");
        System.out.println("[AUDITORIA] Compra " + event.getId() + " processada para auditoria.");
    }
}