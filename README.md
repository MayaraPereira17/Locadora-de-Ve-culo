# Reserva de veículos
          


* [Spring Boot](https://spring.io/projects/spring-boot) - v3.1.5- Framework Initializer   <img align="center" alt="mayara-HTML" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" >
* [Java](https://www.java.com/) - v1.8.191-b12 - Linguagem    <img align="center" alt="mayara-java" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
* [MySQL](https://www.mysql.com/) - v8.0.12     <img align="center" alt="mayara-sql" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg">
* [Intellij IDEA](https://www.jetbrains.com/idea/) - v2023.2.5 - IDE    <img align="center" alt="mayara-intellij" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg">
* [Visual Studio Cod](https://code.visualstudio.com/idea/download) -v1.84 - editor de código-fonte  <img align="center" alt="mayara-vscode" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/visualstudio/visualstudio-plain.svg">
* [Angular](https://angular.io/) -v15.0 - Framework   <img align="center" alt="mayara-angular" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angularjs/angularjs-original.svg">
  

 
 
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
