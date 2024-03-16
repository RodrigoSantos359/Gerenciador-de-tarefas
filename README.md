# Meu Aplicativo de Gerenciamento de Tarefas (TO-DO)

Este é um aplicativo de gerenciamento de tarefas simples desenvolvido com Java, Spring Boot, HTML, CSS e Thymeleaf.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:
- Java Development Kit (JDK) 8 ou superior
- Maven
- PostgreSQL (ou H2 Database)

## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL com o nome `todo_db`.
2. Execute o script `create_table.sql` para criar a tabela de usuários.

## Configuração do Projeto

1. Clone este repositório em sua máquina local.
2. Navegue até o diretório do projeto:


## Execução do Aplicativo

1. Compile o projeto usando Maven:


2. Execute o JAR gerado:


3. O aplicativo estará disponível em: `http://localhost:8080`

## Testes

Para executar os testes unitários, use o comando:

## Deploy

Para implantar o aplicativo em um servidor de produção:
1. Configure as variáveis de ambiente necessárias, como URL do banco de dados, chave secreta JWT, etc.
2. Compile o projeto usando Maven:
3. Copie o arquivo JAR gerado para o servidor de produção.
4. Execute o JAR no servidor de produção:
5. Configure um servidor web (por exemplo, Apache ou Nginx) como proxy reverso para redirecionar o tráfego para o aplicativo.

## Contribuição

Contribuições são bem-vindas! Para contribuir com este projeto, siga estas etapas:
1. Fork este repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/SuaFeature`).
3. Commit suas mudanças (`git commit -m 'Adicione sua feature'`).
4. Faça push para a branch (`git push origin feature/SuaFeature`).
5. Abra um Pull Request.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
