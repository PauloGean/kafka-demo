# Kafka Demo




* Java
* SpringBoot
* Docker
* Docker Compose
* Kafka

Na Raiz Executar o comando docker-compose up.
O mesmo irá executar o kafka.

Após o kafka está rodando executar a criacao de topicos

docker-compose exec kafka  \
kafka-topics --create --topic ordertopic --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181

docker-compose exec kafka  \
kafka-topics --create --topic ordertopicreply --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181

Executar o projeto kafka-consumer ele receberá um envio do producer , fará um 'processamento' e enviara a resposta para o producer pelo topico ordertopicreply

Executar o projeto kafka-producer ele tem um end point POST  para envio de dados String.
Além disso ele tem um consumer de resposta: reply que tras as mensagens processadas


http://localhost:8080/orders





 



