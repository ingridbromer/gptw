Projeto com duas APIs Java RESTful:

(1) File-service, realiza a leitura de arquivo CSV por meio de um GET :8081/readCSV e publica cada registro do arquivo no tópico employee-topic;
(2) Mock-service, possui consumer para o mesmo tópico, e salva os dados em um banco de dados NoSQL (SGBD PostgreSQL). Ainda, conta com CRUD para manipulação desses registros.

Foi realizada a escolha do sistema de mensageria Kafka a fim de evitar perda de dados, por exemplo em uma eventual queda do banco de dados. 
Kafdrop foi utilizado como interface web amigável para visulização do tópico e suas mensagens.

Para o consumo da mensagem no tópico, é necessário que o token JWT já pré-configurado seja passado como corpo da mensagem Kafka. 

Ambas as APIs contam com documentação [Open-API] (http://<server>:<port>/swagger-ui/index.html). 
Para a File-service: http://localhost:8081/swagger-ui/index.html
Para a Mock-service: http://localhost:8082/swagger-ui/index.html

Todos os serviços necessários para a execução das APIs (zookeeper, kafka, kafdrop, postgres, file-service e mock-service) 
estão declarados no docker-compose. Nele, é possível manipular o perfil ativo das propriedades da API, para alterar entre dev-prd.

Foi realizado um teste unitário na File-service para verificação da leitura do arquivo CSV e publicação no tópico Kafka.

As APIs contam com pipeline CI/CD. Para uma melhor execução, será necessário que os demais serviços (zookeeper, kafka, kafdrop, postgres) estejam previamente hospedados em nuvem. 