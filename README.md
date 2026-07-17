# Enterprise Infrastructure Manager (EIM)

## Descripción
Sistema empresarial para administrar infraestructura, servidores, aplicaciones, despliegues, tickets, auditoría y usuarios.

## Tecnologías
- Java 26
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Validation
- Spring Cache
- PostgreSQL
- Redis
- Docker & Docker Compose
- JWT
- MapStruct
- Lombok
- Flyway
- OpenAPI (Swagger)

## Arquitectura

```text
Cliente
   |
REST API
   |
Controller
   |
Service
   |
Repository
   |
PostgreSQL

Redis
├── Cache
├── Rate limiting
├── Tokens temporales
└── Blacklist de JWT
```

## Módulos
- Usuarios
- Roles y Permisos
- Servidores
- Aplicaciones
- Despliegues
- Tickets
- Comentarios
- Alertas
- Auditoría
- Dashboard
- Notificaciones

## Historias de Usuario

### Epic 1 - Usuarios
- Crear usuarios.
- Asignar roles.
- Iniciar sesión (JWT).
- Cambiar contraseña.
- Bloquear y desbloquear usuarios.

### Epic 2 - Infraestructura
- Registrar, editar y eliminar servidores.
- Buscar por SO, RAM, CPU, estado y ubicación.
- Ver historial del servidor.

Servidor:
- Hostname
- IP
- Sistema Operativo
- CPU
- RAM
- Disco
- Estado
- Ubicación
- Proveedor Cloud
- Responsable

### Epic 3 - Aplicaciones
- Registrar aplicaciones.
- Asociarlas a servidores.
- Gestionar versiones.
- Registrar repositorio Git.

### Epic 4 - Despliegues
Estados:
- Pendiente
- En progreso
- Exitoso
- Fallido

Guardar usuario, fecha, versión, servidor y notas.

### Epic 5 - Tickets
Estados:
- Nuevo
- Asignado
- En progreso
- Resuelto
- Cerrado

Prioridades:
- Baja
- Media
- Alta
- Crítica

### Epic 6 - Auditoría
Registrar:
- Usuario
- Fecha
- Acción
- Entidad
- Valor anterior
- Valor nuevo

### Epic 7 - Dashboard
- Servidores
- Usuarios activos
- Tickets
- Despliegues
- Alertas

### Epic 8 - Alertas
- Detectar caída de servidores.
- Crear alerta.
- Enviar correo.

## Modelo de Datos

### Usuario
id, nombre, email, password, estado, roles, createdAt

### Rol
id, nombre, permisos

### Permiso
id, nombre

### Servidor
id, hostname, ip, os, cpu, ram, disk, estado, provider, ubicación

### Aplicación
id, nombre, framework, lenguaje, repositorio, versión

### Deployment
id, servidor, aplicación, usuario, fecha, estado, notas

### Ticket
id, título, descripción, prioridad, estado, usuario, responsable

### Comentario
id, ticket, usuario, mensaje, fecha

### Auditoría
id, usuario, acción, tabla, antes, después, fecha

## Relaciones
- Rol 1..N Usuarios
- Rol N..N Permisos
- Usuario 1..N Tickets
- Usuario 1..N Deployments
- Servidor 1..N Deployments
- Servidor N..N Aplicaciones
- Ticket 1..N Comentarios

## Endpoints
- POST /login
- POST /users
- GET /users
- GET /users/{id}
- PUT /users/{id}
- DELETE /users/{id}
- POST /servers
- GET /servers
- GET /servers/search
- POST /tickets
- PATCH /tickets/{id}/close
- POST /deployments
- GET /dashboard
- GET /audit

## Seguridad
Roles:
- ADMIN
- DEVOPS
- SUPPORT
- MANAGER
- VIEWER

JWT + Refresh Token + autorización por permisos.

## Redis
- Caché del dashboard.
- Caché de usuarios.
- Rate limiting.
- Blacklist de JWT.
- OTP para recuperación de contraseña.

## Scheduler
Revisar periódicamente servidores caídos y generar alertas.

## Correo
Enviar notificaciones por:
- Cuenta creada.
- Contraseña restablecida.
- Ticket asignado.
- Servidor caído.

## Validaciones
- Email válido.
- IP válida.
- Hostname único.
- RAM y CPU mayores que cero.

## Extras
- Paginación.
- Specifications.
- Soft Delete.
- Auditoría automática.
- Optimistic Locking.
- DTOs.
- Docker.
- Tests.
- GitHub Actions.
- OpenAPI.
