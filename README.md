# 📖 Blog Dio

Projeto desenvolvido como parte dos estudos em Java e Spring Boot, com foco na criação de um sistema de publicações e temas relacionados, simulando um blog.  
O projeto visa praticar conceitos de **API RESTful**, **JPA/Hibernate**, **validações**, e relacionamento entre entidades em banco de dados.

---

## 📋 Sobre o Projeto

O **Blog Dio** é uma API que permite gerenciar **temas** e **publicações** associadas a esses temas.  
Cada tema pode conter várias publicações, e cada publicação possui título e texto descritivo.

Funcionalidades principais:
- ✅ Cadastro de temas
- ✅ Cadastro de publicações associadas a um tema
- ✅ Listagem de temas com suas publicações
- ✅ Consulta e criação de publicações
- ✅ Validação para não duplicar publicações

---

## 🛠 Tecnologias Utilizadas

- **Java 17** 🧑‍💻
- **Spring Boot 3.x** 🚀
- **Spring Data JPA** 🔗
- **Hibernate Validator (Jakarta Validation)** ✅
- **PostgreSQL** (ou **H2 Database** para testes locais) 🛢️
- **Springdoc OpenAPI 3 (Swagger)** para documentação interativa da API 📚

---

## 🗂 Diagrama de Classes

```mermaid
classDiagram
    class Tema {
        +Long id
        +String descricao
        +List~Publicacao~ publicacao
    }

    class Publicacao {
        +Long id
        +String titulo
        +String texto
    }

    Tema "1" --> "*" Publicacao : contém
