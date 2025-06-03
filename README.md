# 📢 Comunica & Ajuda!

## Sobre o Projeto

O **Comunica & Ajuda!** é uma aplicação web projetada para ser uma ponte direta entre os cidadãos e a melhoria dos espaços públicos. Nosso objetivo é simplificar o processo de **denunciar e avisar sobre problemas** encontrados na comunidade, como buracos em ruas, lixeiras transbordando, iluminação pública deficiente, ou qualquer outra questão que afete o dia a dia.

Diferente de sistemas que exigem cadastro e login, o **Comunica & Ajuda!** foca na **facilidade e agilidade**. Qualquer cidadão pode registrar um problema de forma **anônima e rápida**, garantindo que as informações cheguem aos responsáveis sem burocracia.

### Cenário de Aplicação

O projeto simula um sistema de **manutenção de espaços públicos**, onde os usuários podem reportar diversas ocorrências como:

* Bancos e equipamentos de parques danificados
* Pichações e grafites em locais públicos
* Problemas com lixeiras e descarte irregular
* Falhas na iluminação de ruas e praças
* Buracos em calçadas e vias
* Questões relacionadas à arborização (quedas, podas necessárias)

## Como o Sistema Funciona

O sistema é dividido em duas grandes interfaces:

### 1. Interface Pública de Relato (para o Cidadão)

Esta é a parte do site que qualquer pessoa pode acessar para:

* **Registrar um Novo Relato**: Preencher um formulário simples com:
    * **Título** e **Descrição** do problema.
    * Nível de **Urgência** (de 1 a 5).
    * **Categoria** do problema (ex: "Iluminação Pública", "Manutenção de Parques").
    * **Localização** detalhada (endereço).
    * **Imagem** (opcional) para ilustrar o problema.
* **Visualizar Relatos Existentes**: Consultar uma lista de todos os problemas já reportados pela comunidade, incluindo seu status de resolução.

### 2. Interface do Administrador

Esta área é destinada aos responsáveis pelo gerenciamento dos problemas. O acesso é simplificado (sem login tradicional) e permite:

* **Gerenciar Categorias**: Criar, visualizar, editar e excluir as categorias de problemas (ex: "Infraestrutura Urbana", "Meio Ambiente").
* **Visualizar e Gerenciar Relatos**: Acessar uma lista completa de todos os relatos enviados.
* **Atualizar Status dos Relatos**: Mudar o status de um problema (ex: de "Recebido" para "Em Progresso" ou "Resolvido").
* **Adicionar Notas Internas**: Registrar informações ou observações privadas sobre um relato, visíveis apenas para a administração.
* **Excluir Relatos**: Remover problemas que já foram resolvidos ou são inválidos.

## Tecnologias Utilizadas

Este projeto será construído utilizando as seguintes tecnologias:

* **Backend**: Java ☕ com **Spring Boot** (APIs REST)
* **Frontend**:
    * **HTML5** (Estrutura da página)
    * **CSS3** (Estilização e layout)
    * **JavaScript** (Interatividade e comunicação com o backend via **Fetch API**)
* **Banco de Dados**: **PostgreSQL** 🐘
* **Formato de Dados**: **JSON** para a troca de informações entre frontend e backend.

## Estrutura do Banco de Dados

As principais tabelas do banco de dados (PostgreSQL) são:

1.  **`categorias`**:
    * `id` (BIGSERIAL, PK)
    * `nome` (VARCHAR, UNIQUE)
2.  **`relatos`**:
    * `id` (BIGSERIAL, PK)
    * `titulo` (VARCHAR)
    * `descricao` (TEXT)
    * `urgencia` (INTEGER, CHECK 1-5)
    * `categoria_id` (BIGINT, FK para `categorias.id`)
    * `localizacao` (VARCHAR)
    * `url_imagem` (VARCHAR, opcional)
    * `status` (VARCHAR, DEFAULT 'Recebido')
    * `notas_admin` (TEXT, opcional)
    * `criado_em` (TIMESTAMP WITH TIME ZONE, DEFAULT CURRENT_TIMESTAMP)

---

**Comunica & Ajuda!** - Construindo comunidades mais atentas e responsivas.
