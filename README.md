# 📺 TV Series Web Application (JSP / Java)

Aplicación web desarrollada con **Java Server Pages (JSP)** y **Servlets** para la gestión, exploración y visualización de series de televisión. Este proyecto implementa una arquitectura patrón MVC (Modelo-Vista-Controlador) tradicional sobre un servidor web Java.

---

## 🚀 Características Principales

- 📁 **Arquitectura MVC:** Separación limpia entre la lógica de negocio (Servlets/JavaBeans), las vistas (`.jsp`) y el acceso a datos.
- 🔍 **Búsqueda y Exploración:** Permite consultar un catálogo de series de televisión.
- 🖥️ **Interfaz Dinámica con JSP:** Uso de scripts y directivas JSP para renderizar contenido del servidor de forma dinámica.
- 🗄️ **Persistencia de Datos:** Conexión a base de datos relacional mediante JDBC.

---

## 🛠️ Tecnologías y Stack Utilizado

- **Backend:** 
  - Java (JDK 8 o superior)
  - Jakarta Servlets / JSP (Java Server Pages)
  - JDBC (Java Database Connectivity)
- **Base de Datos:** MySQL / PostgreSQL *(ajusta según tu BD)*
- **Servidor de Aplicaciones / Contenedor Web:** Apache Tomcat (v9.0 o superior recomendado)
- **Frontend Tradicional:** HTML5, CSS3, JavaScript / Bootstrap *(ajusta si usas algún framework CSS)*
- **Herramientas de Construcción:** Maven / Gradle *(o proyecto dinámico de Eclipse/IntelliJ)*

---

## ⚙️ Requisitos Previos

Antes de ejecutar el proyecto en tu entorno local, asegúrate de tener instalado:

1. [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
2. [Apache Tomcat Server](https://tomcat.apache.org/)
3. Un entorno de desarrollo integrado (IDE) compatible con Java EE / Jakarta EE como **Eclipse IDE for Enterprise Java Developers**, **IntelliJ IDEA Ultimate**, o **NetBeans**.
4. Un gestor de base de datos (MySQL, MariaDB, etc.).

---

## 📥 Instalación y Configuración Local

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/pzunigal/Series.git](https://github.com/pzunigal/Series.git)

2. **Configurar la Base de Datos:**
   * Crea una base de datos en tu gestor SQL.
   * Ejecuta el script SQL (si se encuentra en la carpeta `/database` o `/sql` del repositorio) para poblar las tablas necesarias.
   * Modifica los parámetros de conexión (URL, usuario, contraseña) en la clase de configuración de conexión JDBC del proyecto (ej. `Conexion.java` o `ConexionDB.java`).

3. **Importar el Proyecto en tu IDE:**
   * **En Eclipse:** Ve a `File > Import > Existing Maven Projects` (o importa como proyecto web dinámico común) y selecciona la carpeta clonada.
   * **En IntelliJ IDEA:** Abre la carpeta del proyecto como un proyecto Maven/Java existente.

4. **Configurar el Servidor Tomcat:**
   * Añade tu servidor Apache Tomcat dentro del IDE.
   * Despliega el proyecto (`Run on Server`) seleccionando Tomcat como servidor de destino.

5. **Ejecutar la aplicación:**
   * Abre tu navegador web e ingresa a:
     ```text
     http://localhost:8080/Series/
     ```
     *(Asegúrate de verificar el contexto o nombre del artefacto generado).*

---

## 📂 Estructura del Proyecto

```text
Series/
│
├── src/main/java/          # Clases Java (Servlets, DAOs, Modelos/Beans)
├── src/main/webapp/        # Archivos JSP, HTML, CSS, JS e imágenes
│   ├── WEB-INF/            # Descriptores de despliegue (web.xml) y vistas protegidas
│   └── *.jsp               # Páginas JSP públicas
├── pom.xml                 # Dependencias del proyecto (si usas Maven)
└── README.md
```
**📌 Próximas Mejoras**
* Migrar el diseño frontend a un framework moderno o estilizar las vistas JSP con Bootstrap/Tailwind compilado.
* Implementar seguridad y control de sesiones por roles de usuario.
* Consumir una API externa de series mediante servicios REST en Java.

**📄 Licencia**
* Este proyecto está bajo la licencia MIT.
