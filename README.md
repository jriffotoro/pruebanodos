# Document Manager API

This project implements an API for a small document manager using the Spring Boot framework. The manager is based on the concept of Nodes, which are objects with fields such as id, name, parentId, and children. Nodes are organized in a hierarchical structure, where each Node can have zero or more children and a single parent.

## Requirements

- Java 8 or higher
- Maven

## Setup

1. Clone the repository:

   ```bash
    git clone https://github.com/jriffotoro/pruebanodos.git
   ```

2. Navigate to the directory:

   ```bash
   cd pruebanodos
   ```

3. Compile:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html`, where you will find an interactive interface describing the different endpoints, input parameters, and expected outputs.

## Endpoints

The available endpoints in the document manager API are described below.

### Add a New Node

```bash
POST /nodes
```

This endpoint allows adding a new Node to the document manager. You must provide the Node name and the parent Node identifier. If you want to assign the Root Node as the parent, you should indicate "root" as the parentId. The API will automatically generate a unique identifier for the new Node.

#### Request Example:

```bash
curl --location 'http://localhost:8080/nodes' --header 'Content-Type: application/json' --header 'Accept: */*' --data '{
  "name": "Folder4",
  "parentId": "7e1dcfdd-44c8-40f3-8177-d9306d3789c7"
}'
```

### Get Node Information

```bash
GET /nodes/{id}
```

This endpoint retrieves information about a Node and all its descendants.

#### Request Example:

```bash
curl --location 'http://localhost:8080/nodes/2e89f82f-ff8f-42b6-b631-bafa40d58bac' --header 'Accept: */*'
```

### Delete a Node

```bash
DELETE /nodes/{id}
```

This endpoint allows deleting a Node and all its descendants.

#### Request Example:

```bash
curl --location --request DELETE 'http://localhost:8080/nodes/2e89f82f-ff8f-42b6-b631-bafa40d58bac' --header 'Accept: */*'
```
