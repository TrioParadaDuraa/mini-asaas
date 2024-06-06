# 🪽 Mini Asaas

## ⏳️ Status
Em andamento.

## 💻 Sobre o Mini Asaas
O "Mini Asaas" se trata de uma aplicação para controlar os recebíveis de uma empresa. Nela, estão contidas as seguintes funcionalidades:
 1. Cadastro de pagadores;
 2. Geração de cobranças;
 3. Confirmação de pagamento;
 4. Vencimento de cobranças;
 5. Esteira de exibição de notificações via e-mail;
 6. Gestão multi usuários.

Para cumprimento das especificações propostas, os Services foram implementados de maneira explícita, foi utilizado Spring Security para controle de contas do sistema, em todos os domínios foi salva a data de criação
e nenhum registro foi deletado explicitamente, abordamos a técnica de soft delete.

O backend foi elaborado em 4 domínios, sendo eles: Customer, User, Payer e Payment e dois mecanismos: um para vencer cobranças e outro para notificar eventos via e-mail.
A estrutura de manipulação foi composta por Domain, Service e Controller. Além disso, cada domínio salva informações pertinentes a sua funcionalidade.

A interface foi construída na plataforma Figma seguindo as boas práticas regidas pelo design UX/UI, composta principalmente pelas telas de cadastro, login, operações CRUD em pagador e cobrança, aba de notificações.
Na etapa de implementação do frontend, utilizamos a biblioteca Atlas que nos foi disponibilizada.

## 🚧 Tecnologias Utilizadas
- Grails 5.0.0
- Java JVM 11.0.17
- MySQL Database

## 🛠️ Clonando e executando o repositório

```bash
git clone https://github.com/TrioParadaDuraa/mini-asaas.git

cd [your-path]-mini-asaas

grails run-app
```

<details>
<summary>Configuração para envio de email</summary>

1. Navegue para o gerenciamento de conta do Google
2. Na aba "Segurança", na seção "Como você faz login no Google", clique em "Verificação em duas etapas" e realize a autenticação solicitada
    - Se a verificação em duas etapas ainda não estiver ativada, você deve ativá-la para prosseguir
3. Em "Senhas de app", digite um nome para identificar o MiniAsaas e guarde a senha que será gerada
4. No arquivo application.groovy, adicione o código a seguir, substituindo os valores de username pelo seu email e password pela senha gerada no passo 3

```
grails.mail.host = "smtp.gmail.com"
grails.mail.port = 587
grails.mail.username = "seuemail@asaas.com.br"
grails.mail.password = "senha_gerada_etapa_6"
grails.mail.props = ["mail.smtp.ssl.trust": "smtp.gmail.com",
                    "mail.smtp.starttls.enable": "true",
                    "mail.smtp.ssl.protocols": "TLSv1.2",
                    "mail.smtp.protocol": "smtps",
                    "mail.smtp.channel": "plain",
                    "mail.smtp.auth": "true"]
```
</details><br>

Prontinho!<br>
Agora é possível acessar a aplicação através da rota http://localhost:8080/

## 🗣 Informações Adicionais
Este projeto foi desenvolvido pelos estagiários do time de Talentos 2024 do Asaas, composto pelo trio João Victor Cardozo, Nayane Batista e Pedro da Silva. ♥
