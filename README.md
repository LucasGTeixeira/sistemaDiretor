# Sistema Diretor

# Setup para rodar o Projeto

## Subindo o Banco de Dados

### Instalando Docker

Caso não tenha docker na sua máquina, instale por aqui a versão mais recente: [Docker](https://www.docker.com/products/docker-desktop/)

### Criando um container docker usando o arquivo docker compose

Partindo da raiz do projeto, rode os seguintes comandos:

### Rodando com uma instância do MYSQL

```
cd mySQL
docker-compose up --build --remove-orphans -d

```
### Rodando com uma instância do PostgreSQL

### Descomente as configurações relacionadas ao postgres no arquivo "application.properties" e comente as configurações do Mysql
```
cd PostgreSQL
docker-compose up --build --remove-orphans -d
```
