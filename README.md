# 🟢 Arquitetura Orientada a Eventos com Spring Boot e ActiveMQ

## 📌 Descrição

Este projeto demonstra a aplicação prática da Arquitetura Orientada a Eventos (EDA), utilizando Spring Boot e ActiveMQ.

O sistema foi desenvolvido com o objetivo de implementar um fluxo baseado em mensageria, utilizando filas e tópicos para promover comunicação assíncrona e desacoplamento entre os componentes.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring JMS
- ActiveMQ
- Maven
- Lombok

---

## 🧠 Arquitetura

O sistema segue o padrão Event Driven Architecture (EDA), no qual os componentes se comunicam por meio de eventos.

### 🔁 Fluxo da aplicação



---

## 📦 Funcionamento

1. Uma requisição HTTP POST é enviada para o endpoint `/compras`
2. O Producer envia a mensagem para a fila (`fila.compra`)
3. O Consumer da fila processa a mensagem
4. Após o processamento, um evento é publicado no tópico (`topico.compra.processada`)
5. Dois consumidores reagem ao evento:
   - Auditoria: registra o processamento
   - Notificação: envia uma notificação ao cliente

---

## 📡 Endpoint

### 🔹 POST /compras

http://localhost:8080/compras


### 📥 Exemplo de JSON

```json
{
  "id": 1,
  "cliente": "Matteus",
  "produto": "Mouse Gamer",
  "valor": 150.0
}


⚙️ Como Executar
Clonar o repositório:
git clone https://github.com/seu-repositorio.git
