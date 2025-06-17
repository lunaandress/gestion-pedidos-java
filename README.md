# 🛒 Aplicación de Gestión de Pedidos - Java Console App

Este proyecto es una aplicación de consola desarrollada en Java que permite a los usuarios (clientes) autenticarse, seleccionar productos, elegir talla y color, y realizar pedidos con una dirección de envío.

## 📚 Tecnologías y herramientas

- Java (JDK 8+)
- JDBC (para conexión a base de datos)
- MySQL o similar (según implementación de `ClienteService`, `ProductoService`, etc.)
- Programación orientada a objetos (POO)
- Patrón MVC (Model-View-Controller)

## 🧩 Estructura del proyecto

org.educa
├── entity
│ ├── ClienteEntity.java
│ ├── DireccionEntity.java
│ ├── PedidoEntity.java
│ └── ProductoEntity.java
├── service
│ ├── ClienteService.java
│ ├── PedidoService.java
│ └── ProductoService.java
└── Console.java ← clase principal que ejecuta la app


## 🔑 Funcionalidades principales

- **Login de cliente** mediante DNI y contraseña.
- **Selección de productos** con posibilidad de elegir talla y color.
- **Gestión de pedidos**: se pueden añadir varios productos y luego confirmar el pedido.
- **Direcciones de envío**: se muestra una lista de direcciones del cliente para seleccionar.
- **Persistencia** de datos mediante servicios y JDBC (según se infiere del código).

## 🖥️ Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repo.git
   cd tu-repo
Abre el proyecto en tu IDE favorito (IntelliJ, Eclipse, VS Code...).
Asegúrate de tener configurado el acceso a tu base de datos (ver clases en service).
Ejecuta la clase Console.java.
