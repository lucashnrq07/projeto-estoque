# Sistema de Controle de Estoque Java

## 📌 Visão Geral

Este projeto é um **sistema de controle de estoque** desenvolvido para resolver um problema real do dia a dia: a dificuldade em acompanhar produtos, quantidades e datas de validade de forma simples, confiável e acessível.

A aplicação foi pensada para **uso prático**, com foco em simplicidade, organização e automação de regras de negócio comuns em estoques pequenos e médios.

---

## 🎯 Problema Resolvido

Antes do sistema, o controle de estoque era feito de forma manual, o que gerava:

* Falta de visibilidade sobre produtos próximos do vencimento
* Risco de perda por produtos vencidos
* Dificuldade em manter o estoque organizado
* Dependência de uma única pessoa para controle

**Solução:** uma API backend que centraliza os dados do estoque, aplica regras automaticamente e disponibiliza as informações de forma estruturada.

---

## ⚙️ Funcionalidades Principais (CRUD)

A aplicação segue o padrão **CRUD**, permitindo:

* **Create** – Cadastro de produtos no estoque
* **Read** – Consulta de produtos, quantidades e datas de validade
* **Update** – Atualização de informações dos produtos
* **Delete** – Remoção de produtos (incluindo remoção automática de produtos vencidos)

Além do CRUD básico, o sistema implementa **regras de negócio**, como:

* Organização dos produtos por **data de validade**
* Identificação automática de produtos vencidos
* Classificação visual/lógica conforme proximidade do vencimento

---

## 🏗️ Arquitetura

O projeto utiliza **arquitetura em camadas**, facilitando manutenção, testes e evolução do sistema:

* **Controller**
  Responsável por receber as requisições HTTP e expor os endpoints da API.

* **Service**
  Camada onde ficam as regras de negócio (validações, cálculos, decisões).

* **Repository**
  Responsável pelo acesso e persistência dos dados.

* **Entity**
  Representação das entidades do domínio (ex: Produto, Estoque).

---

## 🔐 Boas Práticas Aplicadas

* Separação clara de responsabilidades
* Código orientado a domínio
* Regras de negócio centralizadas na camada de serviço
* Estrutura preparada para integração com frontend ou outros sistemas

---

## 🧰 Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* MySQL
* Git + GitHub

---

Projeto desenvolvido por **Lucas Henrique**.
