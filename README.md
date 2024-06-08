# Segundo_Parcial_SI2
backend and frontend

## Tecnologías Utilizadas

### Backend

- **Java**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - Lombok
    - Otros...

### Frontend

- **TypeScript**
- **Angular**
    - Angular CLI
    - Angular Material
    - Otros...

### Base de Datos

- **PostgreSQL** (Para producción)

### Herramientas y Otros

- **Maven** (Para la gestión de dependencias del backend)
- **Node.js & NPM** (Para la gestión de dependencias del frontend)
- **Git** (Para el control de versiones)
- **Postman** (Para probar APIs)
- Otros...

## Requisitos

- **Java 11+**
- **Node.js 14+** y **NPM 6+**
- **Maven 3.6+**

## Instalación y Configuración

### Backend

1. Clonar el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/nombre-del-repositorio.git
    cd nombre-del-repositorio/backend
    ```

2. Configurar el archivo `application.properties` en `src/main/resources/` con tus parámetros de base de datos.

3. Compilar y ejecutar el proyecto:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend

1. Navegar al directorio del frontend:
    ```sh
    cd ../frontend
    ```

2. Instalar las dependencias:
    ```sh
    npm install
    ```

3. Ejecutar la aplicación Angular:
    ```sh
    ng serve
    ```

## Uso

Instrucciones sobre cómo utilizar tu proyecto una vez que esté en funcionamiento.

## Contribuir

1. Hacer un fork del proyecto.
2. Crear una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realizar los cambios necesarios y commit (`git commit -m 'Agregar nueva funcionalidad'`).
4. Hacer push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abrir un Pull Request.
