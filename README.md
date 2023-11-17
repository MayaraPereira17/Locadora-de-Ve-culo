# Reserva de veículos


* [Spring](https://spring.io/) - v5.1.2.RELEASE - Framework Web Java/Kotlin MVW
* [Spring Boot](https://spring.io/projects/spring-boot) - v3.1.5- Framework Initializer
* [Java](https://www.java.com/) - v1.8.191-b12 - Linguagem
* [MySQL](https://www.mysql.com/) - v8.0.12 - SGBD
* [Intellij IDEA](https://www.jetbrains.com/idea/) - v2023.2.5 - IDE
* [Visual Studio Cod](https://code.visualstudio.com/idea/download) -v1.84 - editor de código-fonte

 
 
 ### Regras de negócio:
- Não é possível alugar um veículo que já esteja reservado
- Deve ser possível Cadastrar,Remover se não estiver reservado
- CRUD (Create, Read, Update, Delete)

  
#### Veículos:
| Função | Rota | Parametro | Tipo |
| ------ | ------ | ------ | ------ |
| Listar Todos | /veiculo | Nenhum | GET
| Exibir | /buscar/id | ID do Veículo | GET
| Cadastrar | /criar | JSON do Veículo | POST
| Editar | /atualizar/id | ID do Veículo | PUT
| Remover | /deletar/id| ID do Veículo | DELETE


#### Efetuar Reserva de Veículo:
| Função | Rota | Parametro | Tipo |
| ------ | ------ | ------ | ------ |
| Listar Todas | /reserva | Nenhum | GET
| Exibir | reserva| ID da Reserva | GET
| Cadastrar | /criar| JSON do Reserva | POST
| Editar | /reserva/id | ID do Reserva | PUT
| Remover | /cancelar/id_veiculo | ID do Reserva | DELETE
