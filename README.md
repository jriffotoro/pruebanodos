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
