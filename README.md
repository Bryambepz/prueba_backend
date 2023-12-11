# Prueba para Backend
## Bryam Parra

### Para acceder a la documentación Swagger es el siguiente link
http://localhost:8081/pruebaBack/swagger-ui/index.html

### La Estructura del proyecto es la siguiente
- models: Contiene las entidades
- Service y ServiceImpl: Contiene los metodos CRUD que seran llamados desde el Controller
- Controller: Es la clase que contiene los endpoints API Rest
- Repository: Contiene la comunicación con metodos que permiten realizar cambios en la base de datos
- DTO: Clase que permite obtener la relación entre las clases Persona y Empresa
- Response: Estructure para las respuestas Rest
- validations: Contiene metodos que validan campos como el ingreso de la cédula y de la fecha
