# 📦 U3_04_CBDP – API REST: Gestión de Compra y Renta de Almacenes

Desarrollado por: Carlos Benjamin Diaz Pedroza
Materia: Desarrollo Web Integral

---

## 🛠️ Descripción

Este proyecto consiste en una **API RESTful construida con Spring Boot** para gestionar un sistema de compra y renta de almacenes. Incluye el registro de:

-  Cedes (ubicaciones)
- ️ Almacenes (con clave automática)
-  Clientes

La API cumple con:
- ️ CRUD completo para cada entidad
- ️ Validaciones
- ️ Principios de seguridad básicos
- ️ Principios SOLID aplicados

---

##  Entidades

###  Cede
- `id`: Long
- `clave`: Generada automáticamente (C[id]-[ddMMyyyy]-[XXXX])
- `estado`: String
- `municipio`: String

###   Almacen
- `id`: Long
- `clave`: Generada automáticamente ([clave de cede]-A[id])
- `fechaRegistro`: LocalDate
- `precioVenta`: Double
- `precioRenta`: Double
- `tamaño`: String (G, M, P)
- `cede`: Relación ManyToOne

###  Cliente
- `id`: Long
- `nombreCompleto`: String
- `telefono`: String
- `correo`: String

---

##  Principios de Seguridad Implementados

1. **Control Global de Excepciones** (`@ControllerAdvice`)
2. **Validación de Datos** (`@Valid` y anotaciones como `@NotBlank`, `@Email`)
3. **Ocultamiento de consola H2 en producción**
4. **Protección contra SQL Injection** (uso de Spring Data JPA)

---

##  Principios SOLID Aplicados

1. **S – Single Responsibility Principle**  
   Cada clase tiene una única responsabilidad: modelo, repositorio, servicio, controlador.

2. **D – Dependency Inversion Principle**  
   Se usa Spring para inyectar dependencias mediante `@Autowired`, evitando acoplamiento directo.

---

##  Ejecución

1. Clona el repositorio:

   ```bash
   git clone https://github.com/TU_USUARIO/U3_04_CBDP.git
   cd U3_04_CBDP
