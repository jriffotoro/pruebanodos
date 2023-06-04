# API de Gestor Documental

Este proyecto implementa una API de un pequeño gestor documental utilizando el framework Spring Boot. El gestor se basa en el concepto de Nodos, que son objetos con campos como id, nombre, parentId y children. Los Nodos están organizados en una estructura jerárquica, donde cada Nodo puede tener cero o más hijos y un único padre.

## Requisitos

- Java 8 o superior
- Maven

## Configuración

1. Clona el repositorio:

   ```bash
    git clone https://github.com/jriffotoro/pruebanodos.git
    ```

2. Navega al directorio:

    ```bash
    cd pruebanodos
    ```

3. Compila:

    ```bash
    mvn clean install
    ```

4. Ejecuta la aplicación:

    ```bash
    mvn spring-boot:run
     ```

## Documentación de la API

La documentación de la API está disponible en `http://localhost:8080/swagger-ui.html`, donde encontrarás una interfaz interactiva que describe los diferentes endpoints, parámetros de entrada y salidas esperadas.

## Endpoints

A continuación se describen los endpoints disponibles en la API del gestor documental.

### Agregar un nuevo Nodo

```bash
POST /nodes
```

Este endpoint permite agregar un nuevo Nodo al gestor documental. Se debe proporcionar el nombre del Nodo y el identificador del Nodo padre. Si se desea asignar el Nodo Root como padre, se debe indicar el valor "root" como parentId. La API generará automáticamente un identificador único para el nuevo Nodo.

#### Ejemplo de solicitud:

```bash
curl --location 'http://localhost:8080/nodes' \
--header 'Content-Type: application/json' \
--header 'Accept: */*' \
--data '{
  "name": "Carpeta4",
  "parentId": "7e1dcfdd-44c8-40f3-8177-d9306d3789c7"
}'
```

### Obtener información de un Nodo

```bash
GET /nodes/{id}
```
Este endpoint permite obtener la información de un Nodo y toda su descendencia.

#### Ejemplo de solicitud:

```bash
curl --location 'http://localhost:8080/nodes/2e89f82f-ff8f-42b6-b631-bafa40d58bac' \
--header 'Accept: */*'
```

### Eliminar un Nodo

```bash
DELETE /nodes/{id}
```
Este endpoint permite eliminar un Nodo y todos sus descendientes..

#### Ejemplo de solicitud:

```bash
curl --location --request DELETE 'http://localhost:8080/nodes/2e89f82f-ff8f-42b6-b631-bafa40d58bac' \
--header 'Accept: */*'
```