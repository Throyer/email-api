# Spring Boot Email API

Aplicação em spring boot para envio de emails automatizados.

# Requisitos
 - MariaDB: `^10.3.11`
 - Java: `^11`

Esse projeto foi configurado com [Spring Initializr](https://start.spring.io/).

## Instalação

Clone o repositório. [Git](https://git-scm.com/)

```shell
git clone git@github.com:Throyer/email-api.git # SSH

git clone https://github.com/Throyer/email-api.git # HTTP
```
Entre na pasta do projeto
```bash
cd email-api
```

Baixe as dependencias
```bash
mvnw install
```

Rode a aplicação
```bash
mvnw spring-boot:run
```


## Funcionamento

exemplo de email:
```shell
curl --location --request POST 'http://localhost:8080/example' \
--header 'Content-Type: application/json' \
--data-raw '{
    "assunto": "Este e um email de exemplo",
    "template": "example", // este é o nome do arquivo de template
    "mensagem": "Mensagem do corpo", // variavel mensagem que vai ser passada para o template
    "destinatarios": [
        "fulano@email.com",
        "cicrano@email.com"
    ]
}'
```

template de exemplo:
```html
<body>
    <h1 th:text="${mensagem}"></h1>
</body>
```


## Variaveis de ambiente 
são definidas em: [**application.properties**](./src/main/resources/application.properties)

|                 **Descrição**                      |           **parametro**           |              **Valor padrão**             |
|----------------------------------------------------|-----------------------------------|-------------------------------------------|
| endereço do servidor smtp                          | `host`                            | smtp.gmail.com                            |
| porta do servidor smtp                             | `port`                            | 587                                       |
| nome de usuario                                    | `username`                        | user                                      |
| senha                                              | `password`                        | secret                                    |
| diretorio dos templates                            | `templates`                       | `src/main/resources/templates/`           |
| cache                                              | `cache`                           | true                                      |

