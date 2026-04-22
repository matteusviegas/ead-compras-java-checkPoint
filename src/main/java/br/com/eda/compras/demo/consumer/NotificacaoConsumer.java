package br.com.eda.compras.demo.consumer;

import br.com.eda.compras.demo.config.JmsConfig;
import br.com.eda.compras.demo.model.CompraProcessadaEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoConsumer {

    @JmsListener(destination = JmsConfig.TOPICO_COMPRA_PROCESSADA, containerFactory = "topicListenerFactory")
    public void enviarNotificacao(CompraProcessadaEvent event) {
        System.out.println("[NOTIFICACAO] Evento recebido do tópico.");
        System.out.println("[NOTIFICACAO] Notificação enviada ao cliente " + event.getCliente()
                + " referente à compra " + event.getId());
    }
}