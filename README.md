
# Scheduling Rooms

Aplicação Java para gerenciamento de agendamentos de salas, empacotada como imagem Docker e publicada no Docker Hub.

## 🐳 Requisitos

Para rodar o projeto, você precisa ter instalado:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## 🚀 Como rodar o projeto

Com Docker e Docker Compose instalados, siga os passos abaixo:

### 1. Clone o repositório

```bash
git clone https://github.com/JeanBeltrame/rooms.git
cd rooms
```

### 2. Suba os containers com Docker Compose

```bash
docker compose up -d
```

Isso irá:

- Baixar a imagem `jeanbeltrame/scheduling-rooms` do Docker Hub
- Iniciar a aplicação em modo destacado (background)

### 3. Acesse a aplicação

A aplicação estará disponível em:

```
http://localhost:8080
```

## 🛑 Parar os containers

Para parar e remover os containers:

```bash
docker compose down
```

## 📝 Observações

- O projeto utiliza uma imagem publicada no Docker Hub:  
  [`jeanbeltrame/scheduling-rooms`](https://hub.docker.com/r/jeanbeltrame/scheduling-rooms)
- Nenhuma variável de ambiente ou configuração adicional é necessária.
- A imagem é gerada automaticamente durante o build do Maven e enviada para o Docker Hub via `docker-maven-plugin`.
- Fazer push automático para o Docker Hub

> Certifique-se de estar autenticado com `docker login` antes de executar esse comando.

