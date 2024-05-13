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

Para cumprimento das especificações propostas, os Services foram ser implementados de maneira explícita, foi utilizado Spring Security para controle de contas do sistema, em todos os domínios foi salva a data de criação
e nenhum registro foi deletado explicitamente, abordamos a técnica de soft delete.

O backend foi elaborado em 4 domínios, sendo eles: Customer, User, Payer e Payment e dois mecanismos: um para vencer cobranças e outro para notificar eventos via e-mail.
A estrutura de manipulação foi composta por Domain, Service e Controller. Além disso, cada domínio salva informações pertinentes a sua funcionalidade.

A interface foi construída na plataforma Figma seguindo as boas práticas regidas pelo design UX/UI, composta principalmente pelas telas de cadastro, login, operações CRUD em pagador e cobrança, aba de notificações.
Na etapa de implementação do frontend, utilizamos a biblioteca Atlas que nos foi disponibilizada.

## 🚧 Tecnologias Utilizadas
- IntelliJ IDEA
- Grails 5.0.0
- Java JVM 11.0.2
- MySQL Database
- Git
- GitHub

## 🎨 Layouts
⚠️ _Em construção._ ⚠️

## 🛠️ Clonando e executando o repositório

```bash
git clone https://github.com/TrioParadaDuraa/mini-asaas.git

cd [your-path]-miniasaas

grails run-app
```
Prontinho!<br>
Agora é possível acessar a aplicação através da rota http://localhost:8080/

## 🗣 Informações Adicionais
Este projeto foi desenvolvido pelos estagiários do time de Talentos 2024 do Asaas, composto pelo trio João Victor Cardozo, Nayane Batista e Pedro da Silva. ♥
