# 📋 Sistema de Gestión de Tareas – Java + MyBatis + Jersey (REST API)

[![Java](https://img.shields.io/badge/Java-11%2B-%23f89820?logo=java)](https://www.oracle.com/java/)
[![MyBatis](https://img.shields.io/badge/MyBatis-3.5+-%23A91E22?logo=apache)](https://mybatis.org/mybatis-3/)
[![Jersey](https://img.shields.io/badge/Jersey-3.0+-%2376B9E0?logo=eclipse)](https://eclipse-ee4j.github.io/jersey/)
[![REST API](https://img.shields.io/badge/REST-API-%230A66C2?logo=rest)](https://en.wikipedia.org/wiki/Representational_state_transfer)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-%23C71A36?logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)

---

Aplicación RESTful para gestión de tareas, desarrollada con **Java 11**, **MyBatis** (persistencia), **Jersey** (servicios web) y arquitectura multicapa. Expone endpoints CRUD para manipular recursos de tareas mediante HTTP/JSON.

---

## 🛠️ Tecnologías clave

- **Java SE 11+**
- **MyBatis 3.5+** (Mapeo objeto-relacional)
- **Jersey 3.0+** (Implementación JAX-RS para REST)
- **Maven** (Gestión de dependencias)
- **PostgreSQL** (Base de datos)
- **Arquitectura RESTful** (Resource → Service → DAO → Model)

---

## 🎯 Objetivo del proyecto

Demostrar habilidades en el desarrollo de APIs REST con Java puro, integrando:
- MyBatis para interacción eficiente con la base de datos.
- Jersey para construir servicios web siguiendo el estándar JAX-RS.
- Buenas prácticas en estructuración de proyectos backend (separación de capas).

---

## 🏗️ Estructura del código

# 🚀 Gestión de Tareas - REST API con Java, MyBatis y Jersey

[![Java](https://img.shields.io/badge/Java-11+-%23f89820?logo=java)](https://www.oracle.com/java/)
[![MyBatis](https://img.shields.io/badge/MyBatis-3.5+-%23A91E22?logo=apache)](https://mybatis.org/mybatis-3/)
[![Jersey](https://img.shields.io/badge/Jersey-3.0+-%2376B9E0?logo=eclipse)](https://eclipse-ee4j.github.io/jersey/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-%23316192?logo=postgresql)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-%23C71A36?logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

## 📌 Descripción

Sistema completo de gestión de tareas con usuarios y etiquetas, que incluye:
- **API RESTful** con Jersey (JAX-RS)
- **Persistencia** con MyBatis 3.5+
- **Modelo relacional**: Usuario ↔ Tarea ↔ Etiqueta
- **Cliente Jersey** integrado para pruebas

## 🏗️ Estructura del Proyecto

```bash
src/main/java/com/spectrum/gestiondetareas/
├── Restapp/                     # Configuración principal
│   └── Configuration.java       # Inicialización de la aplicación
├── controller/                  # Controladores REST
│   ├── TareaController.java     # Endpoints para /api/tareas
│   ├── UsuarioController.java   # Endpoints para /api/usuarios
│   └── EtiquetaController.java  # Endpoints para /api/etiquetas
├── jerseyClient/                # Cliente para consumir la API
│   └── JerseyClient.java        
├── mapper/                      # Interfaces MyBatis
│   ├── TareaMapper.java
│   ├── UsuarioMapper.java
│   └── EtiquetaMapper.java
├── model/                       # Entidades del dominio
│   ├── Tarea.java               # (id, titulo, descripcion, fechacreacion, fechaVencimiento, estado)
│   ├── Usuario.java             # (id, nombre, email, password)
│   └── Etiqueta.java            # (id, nombre, color)
├── repository/                  # Implementación DAO
│   ├── TareaRepositoryImpl.java
│   ├── UsuarioRepositoryImpl.java
│   └── EtiquetaRepositoryImpl.java
├── service/                     # Lógica de negocio
│   ├── TareaServiceImpl.java
│   ├── UsuarioServiceImpl.java
│   └── EtiquetaServiceImpl.java
└── utilities/
    └── BaseDatos.java           # Utilidades de conexión

src/main/resources/
├── mybatis-config.xml           # Configuración MyBatis
├── mapper/                      # Mappers XML
│   ├── TareaMapper.xml
│   ├── UsuarioMapper.xml
│   └── EtiquetaMapper.xml
└── application.properties       # Configuración DB
```
---

## 🚀 Ejecución

1. **Clonar el repositorio**:

   git clone https://github.com/harold-20-06/GestionDeTareas-MyBatis-Rest-Jersey.git

2. 	Configurar base de datos PostgreSQL:
• 	Crear tablas necesarias (Usuario, Tarea, Etiqueta).
• 	Actualizar credenciales en  /utilities/BaseDatos.java para tu entorno local.

3. 	Ejecutar el programa:
## 🚀 Ejecución del Proyecto

### Opción 1: Con JBoss/WildFly 17 (Recomendada)
1. **Empaquetar**:
   ```bash
   mvn clean package
   ```
2. **Desplegar**:

Copiar el .war generado en target/ al directorio standalone/deployments/ de JBoss

O usar el plugin de Maven:

mvn wildfly:deploy

Opción 2: Servidor Embebido (Tomcat - Para desarrollo rápido)

mvn clean install tomcat7:run

El API estará disponible en: http://localhost:8080/tareas/api/

4. Endpoints disponibles:

GET /api/usuarios → Listar todas los usuarios.

POST /api/usuarios → Crear nuevo usuario (body JSON).

GET /api/usuarios/{id} → Buscar usuario por ID.

GET /api/etiquetas → Listar todas las etiquetas.

POST /api/etiquetas → Crear nueva etiquetas (body JSON).

GET /api/etiquetas/{id} → Buscar etiquetas por ID.

GET /api/tareas → Listar todas las tareas.

POST /api/tareas → Crear nueva tarea (body JSON).

GET /api/tareas/{id} → Buscar tarea por ID.
---

## ✅ Funcionalidades principales
• 	Registro, edición y eliminación de usuario, tarea, etiqueta.
• 	Consulta individual y listados generales.
• 	Validaciones simples para consistencia de datos.
• 	Separación lógica y ordenada en capas de desarrollo.

---

## 📜 Licencia
Este proyecto está licenciado bajo la [MIT License](https://opensource.org/licenses/MIT) — consulta el archivo [`LICENSE`](./LICENSE) para más información.

---

## 👨‍💻 Autor
Creado con ❤️ por [@harold-20-06](https://github.com/harold-20-06)
🔗 [LinkedIn](https://www.linkedin.com/in/harold-montecinos/)
🔗 [GitHub](https://github.com/harold-20-06)
