# Desafio_3
API Rest com Spring Boot, JAVA, MongoDB e RabbitMQ
O código funciona como o código do catálogo feito com o MongoDB, mas todo post e put feito 
desencadeiará na publicação do produto em duas Queues do RabbitMQ, onde uma delas está sendo 
consumida e ao ser consumida cadastra o produto no banco de dados e a outra não está sendo 
consumida para fis de demonstração da fila retida no RabbitMQ.
