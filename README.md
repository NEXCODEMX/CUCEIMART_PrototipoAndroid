# CUCEI MART — App Android (Java Nativo)

<div align="center">

```
  ██████╗██╗   ██╗ ██████╗███████╗██╗    ███╗   ███╗ █████╗ ██████╗ ████████╗
 ██╔════╝██║   ██║██╔════╝██╔════╝██║    ████╗ ████║██╔══██╗██╔══██╗╚══██╔══╝
 ██║     ██║   ██║██║     █████╗  ██║    ██╔████╔██║███████║██████╔╝   ██║   
 ██║     ██║   ██║██║     ██╔══╝  ██║    ██║╚██╔╝██║██╔══██║██╔══██╗   ██║   
 ╚██████╗╚██████╔╝╚██████╗███████╗██║    ██║ ╚═╝ ██║██║  ██║██║  ██║   ██║   
  ╚═════╝ ╚═════╝  ╚═════╝╚══════╝╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝  
```

**E-Commerce Universitario — CUCEI · Universidad de Guadalajara**

*"Tu punto de emprendimiento universitario"*

Desarrollado por **NEXCODE** | Java Nativo · Android Studio · SQLite

</div>

---

## Tabla de Contenidos

1. [Descripcion General](#1-descripcion-general)
2. [Arquitectura del Proyecto](#2-arquitectura-del-proyecto)
3. [Estructura de Carpetas](#3-estructura-de-carpetas)
4. [Layouts y Pantallas](#4-layouts-y-pantallas)
5. [Base de Datos SQLite](#5-base-de-datos-sqlite)
6. [Sistema de Paletas de Color](#6-sistema-de-paletas-de-color)
7. [Funcionalidades Principales](#7-funcionalidades-principales)
8. [Modulo de Reputacion e Inteligencia de Filtro](#8-modulo-de-reputacion-e-inteligencia-de-filtro)
9. [Roles de Usuario](#9-roles-de-usuario)
10. [Convenciones de Codigo](#10-convenciones-de-codigo)
11. [Requisitos Previos](#11-requisitos-previos)
12. [Guia de Instalacion](#12-guia-de-instalacion)
13. [Equipo](#13-equipo)
14. [Licencia](#14-licencia)

---

## 1. Descripcion General

**CUCEI MART** es una aplicacion Android de comercio electronico universitario desarrollada en **Java nativo**, orientada exclusivamente a la comunidad del Centro Universitario de Ciencias Exactas e Ingenierias (CUCEI) de la Universidad de Guadalajara.

La plataforma conecta a estudiantes consumidores con emprendedores universitarios mediante una interfaz visual tipo tienda electronica por categorias, inspirada en el flujo de navegacion de plataformas como Amazon, adaptada al ecosistema universitario y completamente funcional sin conexion a Internet gracias a su base de datos **SQLite** local.

### Que resuelve CUCEI MART

Antes de CUCEI MART, la difusion de emprendimientos en el campus se limitaba a grupos informales de WhatsApp y Facebook sin ninguna estructura centralizada. La app sustituye ese ecosistema desordenado con una experiencia de usuario moderna, categorizada y con sistema de reputacion verificable.

### Usuarios Objetivo

| Rol | Descripcion |
|---|---|
| **Estudiante** | Busca y descubre productos y servicios dentro del campus |
| **Emprendedor** | Registra su negocio, sube su catalogo y gestiona su reputacion |

---

## 2. Arquitectura del Proyecto

La app sigue el patron **MVC (Modelo - Vista - Controlador)** adaptado a Android con Java nativo y tres capas bien definidas:

```
┌─────────────────────────────────────────────────────┐
│                CAPA DE PRESENTACION                  │
│   Activities + Fragments + Adapters + Layouts XML    │
└───────────────────┬─────────────────────────────────┘
                    │
┌───────────────────▼─────────────────────────────────┐
│               CAPA DE LOGICA DE NEGOCIO              │
│   Managers + Helpers + Filtros + Reputacion          │
└───────────────────┬─────────────────────────────────┘
                    │
┌───────────────────▼─────────────────────────────────┐
│               CAPA DE DATOS (SQLite)                 │
│   DatabaseHelper + DAOs + Modelos Java               │
└─────────────────────────────────────────────────────┘
```

### Tecnologias

| Componente | Tecnologia |
|---|---|
| Lenguaje | Java (JDK 11+) |
| IDE | Android Studio Hedgehog o superior |
| Base de Datos | SQLite (android.database.sqlite) |
| UI | XML Layouts + Material Design Components |
| Iconos | Font Awesome via fuente TTF integrada |
| Imagenes | Bitmap local almacenado en SQLite como BLOB |
| minSdkVersion | 24 (Android 7.0) |
| targetSdkVersion | 34 (Android 14) |

---

## 3. Estructura de Carpetas

```
CUCEIMART/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/mx/udg/cucei/cuceimart/
│   │       │   │
│   │       │   ├── actividades/                    # Todas las Activities de la app
│   │       │   │   ├── ActividadBienvenida.java
│   │       │   │   ├── ActividadInicioSesion.java
│   │       │   │   ├── ActividadCrearCuenta.java
│   │       │   │   ├── ActividadPrincipal.java
│   │       │   │   ├── ActividadBusqueda.java
│   │       │   │   ├── ActividadCategoria.java
│   │       │   │   ├── ActividadPerfilEmprendedor.java
│   │       │   │   ├── ActividadDetalleProducto.java
│   │       │   │   ├── ActividadPanelEmprendedor.java
│   │       │   │   ├── ActividadGestionProductos.java
│   │       │   │   ├── ActividadConfiguracion.java
│   │       │   │   ├── ActividadPaleta.java
│   │       │   │   └── ActividadHistorialBusqueda.java
│   │       │   │
│   │       │   ├── modelos/                        # POJOs de datos
│   │       │   │   ├── Estudiante.java
│   │       │   │   ├── Emprendedor.java
│   │       │   │   ├── Producto.java
│   │       │   │   ├── Categoria.java
│   │       │   │   ├── Resena.java
│   │       │   │   ├── HistorialBusqueda.java
│   │       │   │   └── Paleta.java
│   │       │   │
│   │       │   ├── basededatos/                    # Capa de persistencia SQLite
│   │       │   │   ├── AyudanteBD.java             # DatabaseHelper principal
│   │       │   │   ├── DaoEstudiante.java
│   │       │   │   ├── DaoEmprendedor.java
│   │       │   │   ├── DaoProducto.java
│   │       │   │   ├── DaoCategoria.java
│   │       │   │   ├── DaoResena.java
│   │       │   │   └── DaoHistorial.java
│   │       │   │
│   │       │   ├── adaptadores/                    # RecyclerView Adapters
│   │       │   │   ├── AdaptadorCategoria.java
│   │       │   │   ├── AdaptadorEmprendedor.java
│   │       │   │   ├── AdaptadorProducto.java
│   │       │   │   ├── AdaptadorResena.java
│   │       │   │   ├── AdaptadorHistorial.java
│   │       │   │   └── AdaptadorDestacados.java
│   │       │   │
│   │       │   ├── gestores/                       # Logica de negocio y utilidades
│   │       │   │   ├── GestorSesion.java           # SharedPreferences de sesion
│   │       │   │   ├── GestorPaleta.java           # Aplicacion dinamica de paletas
│   │       │   │   ├── GestorReputacion.java       # Calculo de puntaje y ranking
│   │       │   │   ├── GestorFiltro.java           # Filtro inteligente de busqueda
│   │       │   │   └── GestorImagen.java           # Comprimir/cargar Bitmap a BD
│   │       │   │
│   │       │   └── utilidades/                     # Helpers generales
│   │       │       ├── ConstantesBD.java           # Nombres de tablas y columnas
│   │       │       ├── ConstantesApp.java          # Claves SharedPreferences
│   │       │       └── AyudanteUI.java             # Snippets de UI reutilizables
│   │       │
│   │       └── res/
│   │           ├── layout/                         # Todos los XMLs de pantalla
│   │           ├── drawable/                       # Fondos, shapes, selectores
│   │           ├── font/                           # fontawesome-webfont.ttf
│   │           ├── values/
│   │           │   ├── strings.xml
│   │           │   ├── colors.xml                  # 9 paletas completas
│   │           │   ├── themes.xml
│   │           │   ├── dimens.xml
│   │           │   └── attrs.xml                   # Atributos personalizados de paleta
│   │           ├── menu/
│   │           └── anim/
│   │
│   └── build.gradle
│
├── README.md
└── LICENSE
```

---

## 4. Layouts y Pantallas

Cada pantalla tiene su propio archivo XML de layout. Todos los layouts heredan la paleta activa del `GestorPaleta` y aplican los colores de forma dinamica desde Java al inflar la vista.

### 4.1 Layout de Bienvenida — `layout_bienvenida.xml`

Pantalla splash con logo hexagonal de CUCEI MART y degradado animado.

**Elementos:**
- Logo CUCEI MART (ImageView hexagonal)
- Texto del slogan
- Boton **Iniciar Sesion**
- Boton **Crear Cuenta**
- Seleccionador rapido de paleta (icono engranaje)

---

### 4.2 Layout de Inicio de Sesion — `layout_inicio_sesion.xml`

Pantalla unica de login con selector de tipo de usuario.

**Elementos:**
- RadioGroup: Estudiante / Emprendedor
- Campo correo (EditText)
- Campo contrasena (EditText con toggle visible)
- Boton **Ingresar**
- Link **Crear cuenta nueva**
- Validacion contra SQLite en `DaoEstudiante` o `DaoEmprendedor`

---

### 4.3 Layout de Crear Cuenta — `layout_crear_cuenta.xml`

Formulario de registro separado por tipo de usuario (dos fragmentos dentro de la misma Activity).

**Para Estudiante:**
- Nombre completo
- Numero de codigo (codigo UDG)
- Correo institucional `@alumnos.udg.mx`
- Contrasena y confirmacion

**Para Emprendedor:**
- Nombre del emprendimiento
- Descripcion breve del negocio
- Categoria principal (Spinner vinculado a tabla `categorias`)
- Foto de perfil/logo (ImageView con boton de galeria o camara)
- Correo y contrasena

---

### 4.4 Layout Principal — `layout_principal.xml`

Pantalla central de la app. Equivalente a la pagina de inicio de una tienda electronica.

**Estructura visual (de arriba a abajo):**

```
┌──────────────────────────────────────────┐
│  [Hamburger]  CUCEI MART  [Perfil][Paleta]│  Toolbar
├──────────────────────────────────────────┤
│  [Lupa]  Buscar productos o negocios...  │  SearchView
├──────────────────────────────────────────┤
│  *** EMPRENDEDOR DESTACADO ***            │  CardView destacado
│  [Foto] NombreEmprendedor  ★★★★★  >     │
├──────────────────────────────────────────┤
│  CATEGORIAS                              │  Titulo seccion
│  ┌────┐ ┌────┐ ┌────┐ ┌────┐           │
│  │ fa │ │ fa │ │ fa │ │ fa │  ...       │  GridView de categorias
│  │Comida│ │Ropa│ │Tech│ │Serv│          │
│  └────┘ └────┘ └────┘ └────┘           │
├──────────────────────────────────────────┤
│  EMPRENDEDORES RECIENTES                 │  RecyclerView horizontal
│  [Foto] Nombre  ★4.8  >                 │
│  [Foto] Nombre  ★4.5  >                 │
└──────────────────────────────────────────┘
```

**Categorias con Font Awesome:**

| Categoria | Icono FA |
|---|---|
| Comida y Bebida | `\uf2e7` (utensils) |
| Ropa y Accesorios | `\uf553` (tshirt) |
| Tecnologia | `\uf109` (laptop) |
| Servicios | `\uf0ad` (wrench) |
| Arte y Diseno | `\uf53f` (paint-brush) |
| Salud y Bienestar | `\uf21e` (heartbeat) |
| Apuntes y Material | `\uf02d` (book) |
| Otros | `\uf0ca` (list) |

---

### 4.5 Layout de Busqueda y Filtro — `layout_busqueda.xml`

Pantalla de resultados de busqueda con filtro inteligente.

**Elementos:**
- SearchView con historial desplegable (RecyclerView debajo del campo)
- Chips de filtro rapido: por categoria, precio, calificacion minima
- Ordenamiento: Mejor calificados / Mas resenas / Recientes
- RecyclerView de resultados (emprendedores y productos mezclados)
- Cada tarjeta muestra: foto, nombre, descripcion corta, estrellas, categoria

**Logica de filtro inteligente (`GestorFiltro.java`):**
El buscador tokeniza la consulta y la compara contra nombre del emprendedor, nombre de productos, descripcion y etiquetas de categoria. Los resultados se ordenan por `puntajeReputacion` DESC como criterio primario.

---

### 4.6 Layout de Categoria — `layout_categoria.xml`

Lista de todos los emprendedores de una categoria seleccionada.

**Elementos:**
- Header con icono FA y nombre de categoria
- RecyclerView en grid (2 columnas), cada tarjeta tiene:
  - Foto de perfil del emprendedor (circular)
  - Nombre del emprendimiento
  - Calificacion promedio con estrellas
  - Numero de resenas
- Ordenado por `puntajeReputacion` DESC

---

### 4.7 Layout de Perfil del Emprendedor — `layout_perfil_emprendedor.xml`

Vista publica del emprendedor (equivalente a la pagina de vendedor en Amazon).

**Elementos:**
- Foto de perfil grande (circular)
- Nombre del emprendimiento
- Descripcion del negocio
- Calificacion global (estrellas + numero de resenas)
- Histograma de distribucion de estrellas (1 a 5)
- RecyclerView horizontal: **Productos del emprendedor**
- Seccion de resenas con autor, calificacion, comentario y fecha
- Boton **Dejar resena** (solo para estudiantes)

---

### 4.8 Layout de Detalle de Producto — `layout_detalle_producto.xml`

Vista de un producto especifico dentro de un emprendimiento.

**Elementos:**
- Imagen del producto
- Nombre y precio
- Descripcion detallada
- Nombre del emprendedor con foto (tappable -> va a su perfil)
- Calificacion del emprendedor
- Boton **Ver todos los productos de este emprendedor**
- Boton **Contactar por WhatsApp** (deeplink con numero guardado en BD)

---

### 4.9 Layout Panel del Emprendedor — `layout_panel_emprendedor.xml`

Dashboard privado del emprendedor. Accesible solo tras autenticarse como emprendedor.

**Elementos:**
- Resumen estadistico: total resenas, calificacion promedio, visualizaciones
- Boton **Editar mi perfil**
- RecyclerView de **Mis productos** con botones editar/eliminar por item
- Boton flotante (+) para **Agregar nuevo producto**
- Seccion de ultimas resenas recibidas
- Indicador de posicion en ranking de categoria

---

### 4.10 Layout Gestion de Productos — `layout_gestion_producto.xml`

Formulario para agregar o editar un producto del emprendedor.

**Elementos:**
- ImageView con boton para seleccionar imagen de galeria o camara
- Nombre del producto (EditText)
- Descripcion (EditText multilinea)
- Precio (EditText numerico)
- Categoria del producto (Spinner)
- Disponibilidad (Switch: Disponible / No disponible)
- Boton **Guardar** / **Cancelar**

---

### 4.11 Layout de Configuracion — `layout_configuracion.xml`

Ajustes de la cuenta y de la apariencia.

**Elementos:**
- Foto de perfil con opcion de cambiar
- Datos editables de la cuenta
- Seccion **Apariencia**: selector de paleta de color
- Preview en tiempo real de la paleta al seleccionarla
- Cerrar sesion

---

### 4.12 Layout Selector de Paleta — `layout_paleta.xml`

Dialogo o pantalla dedicada para elegir la paleta visual de la app.

**Elementos:**
- 9 tarjetas de paleta, cada una con preview de colores (primario, acento, fondo)
- Nombre de la paleta
- Paleta activa marcada con icono de verificacion (FA: `\uf058`)
- Boton **Aplicar** que llama a `GestorPaleta.aplicarPaleta()`

---

### 4.13 Layout de Historial de Busqueda — `layout_historial.xml`

Pantalla de historial de busquedas por sesion de usuario.

**Elementos:**
- RecyclerView con todas las busquedas anteriores del usuario
- Boton de eliminar por item (swipe o icono)
- Boton **Limpiar historial completo**
- Al tocar un item repite la busqueda automaticamente

---

## 5. Base de Datos SQLite

### Clase Principal: `AyudanteBD.java`

Extiende `SQLiteOpenHelper`. Nombre de la base de datos: `cuceimart.db`. Version: `1`.

### Esquema de Tablas

#### Tabla `estudiantes`
```sql
CREATE TABLE estudiantes (
    id_estudiante       INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_completo     TEXT    NOT NULL,
    codigo_udg          TEXT    UNIQUE NOT NULL,
    correo              TEXT    UNIQUE NOT NULL,
    contrasena_hash     TEXT    NOT NULL,
    fecha_registro      TEXT    NOT NULL
);
```

#### Tabla `emprendedores`
```sql
CREATE TABLE emprendedores (
    id_emprendedor      INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_negocio      TEXT    NOT NULL,
    descripcion         TEXT,
    correo              TEXT    UNIQUE NOT NULL,
    contrasena_hash     TEXT    NOT NULL,
    foto_perfil         BLOB,
    whatsapp            TEXT,
    id_categoria        INTEGER NOT NULL,
    puntaje_reputacion  REAL    DEFAULT 0.0,
    total_resenas       INTEGER DEFAULT 0,
    visualizaciones     INTEGER DEFAULT 0,
    es_destacado        INTEGER DEFAULT 0,
    fecha_registro      TEXT    NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);
```

#### Tabla `categorias`
```sql
CREATE TABLE categorias (
    id_categoria        INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre              TEXT    NOT NULL,
    icono_fa            TEXT    NOT NULL,
    descripcion         TEXT
);
```

#### Tabla `productos`
```sql
CREATE TABLE productos (
    id_producto         INTEGER PRIMARY KEY AUTOINCREMENT,
    id_emprendedor      INTEGER NOT NULL,
    nombre              TEXT    NOT NULL,
    descripcion         TEXT,
    precio              REAL    NOT NULL,
    imagen              BLOB,
    disponible          INTEGER DEFAULT 1,
    fecha_creacion      TEXT    NOT NULL,
    FOREIGN KEY (id_emprendedor) REFERENCES emprendedores(id_emprendedor)
);
```

#### Tabla `resenas`
```sql
CREATE TABLE resenas (
    id_resena           INTEGER PRIMARY KEY AUTOINCREMENT,
    id_emprendedor      INTEGER NOT NULL,
    id_estudiante       INTEGER NOT NULL,
    calificacion        INTEGER NOT NULL CHECK(calificacion BETWEEN 1 AND 5),
    comentario          TEXT,
    fecha               TEXT    NOT NULL,
    UNIQUE(id_emprendedor, id_estudiante),
    FOREIGN KEY (id_emprendedor) REFERENCES emprendedores(id_emprendedor),
    FOREIGN KEY (id_estudiante)  REFERENCES estudiantes(id_estudiante)
);
```

#### Tabla `historial_busqueda`
```sql
CREATE TABLE historial_busqueda (
    id_historial        INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario          INTEGER NOT NULL,
    tipo_usuario        TEXT    NOT NULL CHECK(tipo_usuario IN ('estudiante','emprendedor')),
    termino_busqueda    TEXT    NOT NULL,
    fecha               TEXT    NOT NULL
);
```

#### Tabla `etiquetas_producto`
```sql
CREATE TABLE etiquetas_producto (
    id_etiqueta         INTEGER PRIMARY KEY AUTOINCREMENT,
    id_producto         INTEGER NOT NULL,
    etiqueta            TEXT    NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);
```

### Datos Iniciales (Seed)

`AyudanteBD.onUpgrade()` y `onCreate()` insertan las 8 categorias base con sus iconos Font Awesome y un emprendedor de ejemplo para pruebas.

---

## 6. Sistema de Paletas de Color

### Como funciona

1. El usuario elige una paleta en `ActividadConfiguracion` o `ActividadPaleta`.
2. `GestorPaleta.guardarPaleta(nombrePaleta)` persiste la eleccion en `SharedPreferences`.
3. Cada Activity, en su metodo `onCreate()`, llama a `GestorPaleta.aplicarPaleta(this, vistaRaiz)` antes de `setContentView`.
4. `GestorPaleta` lee los colores del `res/values/colors.xml` segun el nombre de paleta y los aplica programaticamente a todos los componentes via `setBackgroundColor`, `setTextColor`, `setCardBackgroundColor`, etc.

### Paletas Disponibles

| Nombre Clave | Color Primario Inicio | Color Primario Fin | Acento |
|---|---|---|---|
| `ocean` | `#667eea` | `#764ba2` | `#4299e1` |
| `trust` | `#283593` | `#1E88E5` | `#00ACC1` |
| `forest` | `#4caf50` | `#2e7d32` | `#388e3c` |
| `neon` | `#00bcd4` | `#e91e63` | `#ff4081` |
| `dark` | `#424242` | `#212121` | `#616161` |
| `royal` | `#9c27b0` | `#673ab7` | `#8e24aa` |
| `rosenight` | `#1c3a66` | `#b73064` | `#f4b5cf` |
| `greenroots` | `#132a13` | `#31572c` | `#4f772d` |
| `yellow` | `#fdd835` | `#fbc02d` | `#f9a825` |
| `red` | `#e53935` | `#b71c1c` | `#d32f2f` |

### Variables CSS → Atributos Java

Cada variable de paleta CSS se mapea a un metodo de aplicacion en `GestorPaleta`:

| Variable CSS | Uso en la App |
|---|---|
| `--primary-start / --primary-end` | GradientDrawable del Toolbar y botones principales |
| `--accent-color` | Boton flotante, chips, iconos activos |
| `--text-primary` | Titulos y texto principal de tarjetas |
| `--text-secondary` | Subtitulos, metadatos, contadores |
| `--background-overlay` | Fondo de CardViews y RecyclerView |
| `--shadow-color` | Elevacion de sombras en tarjetas |
| `--border-color` | Bordes de EditText, lineas separadoras |

---

## 7. Funcionalidades Principales

### 7.1 Registro e Inicio de Sesion

- Login diferenciado por rol (Estudiante / Emprendedor) en la misma pantalla con RadioGroup
- Contrasenas almacenadas con hash MD5 o SHA-256 via `MessageDigest` de Java
- Sesion persistida con `SharedPreferences` gestionadas por `GestorSesion`
- Un mismo correo no puede registrarse en ambos roles

### 7.2 Pantalla Principal con Categorias

- 8 categorias renderizadas en `GridView` (2 columnas) con iconos Font Awesome via `Typeface`
- Al tocar una categoria -> `ActividadCategoria` con lista de emprendedores de ese giro
- Banner de **Emprendedor Destacado** rotativo: el emprendedor con mayor `puntaje_reputacion` de cada semana aparece destacado en la parte superior

### 7.3 Busqueda con Filtro Inteligente

- `SearchView` en la pantalla principal con `setOnQueryTextListener`
- Al escribir, `GestorFiltro.buscar(termino)` ejecuta una consulta SQL con `LIKE` contra nombre del emprendedor, nombre de productos, descripcion y etiquetas
- Historial guardado automaticamente en `historial_busqueda` por usuario y sesion
- Sugerencias del historial se muestran debajo del campo de busqueda como dropdown
- Filtros adicionales por categoria (Spinner) y calificacion minima (SeekBar de 1-5 estrellas)

### 7.4 Tarjetas de Emprendedor

- Diseño tipo Amazon: foto circular del emprendedor como logo
- Nombre del negocio, categoria, calificacion con estrellas y numero de resenas
- Al tocar la tarjeta -> `ActividadPerfilEmprendedor` con catalogo de productos

### 7.5 Catalogo de Productos

- RecyclerView con tarjetas de producto: imagen, nombre, precio, disponibilidad
- Al tocar un producto -> `ActividadDetalleProducto`
- Solo el emprendedor dueno puede agregar, editar o eliminar sus propios productos

### 7.6 Sistema de Resenas

- Solo estudiantes autenticados pueden dejar resena
- Un estudiante puede resenar cada emprendedor una sola vez (UNIQUE en BD)
- Calificacion de 1 a 5 estrellas con `RatingBar`
- Comentario de texto opcional
- Tras guardar la resena, `GestorReputacion.recalcularPuntaje(idEmprendedor)` actualiza `puntaje_reputacion` y `total_resenas` en la tabla `emprendedores`

### 7.7 Emprendedor Destacado

- Un `CardView` especial en la pantalla principal muestra al emprendedor con mayor `puntaje_reputacion`
- Si hay empate, se prioriza el que tenga mas `total_resenas`
- El campo `es_destacado` en BD se actualiza periodicamente al iniciar la app

### 7.8 Contacto Directo

- Cada emprendedor puede registrar su numero de WhatsApp
- El boton **Contactar** en su perfil lanza un deeplink `https://wa.me/52XXXXXXXXXX` via `Intent.ACTION_VIEW`

---

## 8. Modulo de Reputacion e Inteligencia de Filtro

### Calculo del Puntaje de Reputacion

`GestorReputacion.java` implementa la siguiente formula al recibir una nueva resena:

```
puntaje_reputacion = (suma_calificaciones / total_resenas) * factor_volumen

factor_volumen = 1 + log10(total_resenas + 1) * 0.1
```

Esto garantiza que un emprendedor con muchas resenas positivas suba mas rapido en el ranking que uno con pocas resenas perfectas, incentivando la interaccion activa de la comunidad.

### Logica de Orden en Resultados

Los emprendedores en cualquier listado se ordenan por:

1. `puntaje_reputacion` DESC (primario)
2. `total_resenas` DESC (desempate)
3. `fecha_registro` ASC (favorece a emprendedores mas antiguos en caso de empate total)

Esto se traduce en la siguiente clausula SQL:

```sql
ORDER BY puntaje_reputacion DESC, total_resenas DESC, fecha_registro ASC
```

### Historial de Busqueda por Cuenta

- El historial es personal: cada usuario (estudiante o emprendedor) tiene su propio historial
- Se guardan los ultimos 20 terminos unicos de busqueda
- Al superar 20 entradas, se elimina automaticamente la mas antigua (FIFO)
- El historial puede ser borrado manualmente desde `ActividadHistorialBusqueda`

---

## 9. Roles de Usuario

### Estudiante

- Puede buscar emprendedores y productos
- Puede ver perfiles de emprendedores y sus catalogos
- Puede dejar resenas (una por emprendedor)
- Tiene historial de busqueda personal
- **No puede** registrar productos ni negocios

### Emprendedor

- Puede gestionar su perfil (foto, descripcion, WhatsApp)
- Puede agregar, editar y eliminar sus propios productos
- Puede ver su puntaje de reputacion y estadisticas basicas
- Puede buscar en la app (con historial propio)
- **No puede** dejar resenas a otros emprendedores

---

## 10. Convenciones de Codigo

> El proyecto sigue estas convenciones de forma estricta en todos los archivos.

- **Variables y metodos:** `camelCase` en espanol. Ejemplo: `nombreEmprendedor`, `obtenerEmprendedoresPorCategoria()`
- **Clases:** `PascalCase` en espanol. Ejemplo: `GestorReputacion`, `AdaptadorEmprendedor`
- **Constantes:** `MAYUSCULAS_CON_GUION`. Ejemplo: `NOMBRE_BD`, `VERSION_BD`
- **Comentarios:** Unicamente en secciones importantes del layout XML (no en logica Java rutinaria). Ejemplo: `<!-- Sección de emprendedor destacado —>` 
- **Sin emojis:** Ningun emoji en cadenas de texto de la app. Toda iconografia usa Font Awesome
- **Sin Kotlin:** El proyecto es 100% Java nativo. No se acepta codigo Kotlin ni interoperabilidad

---

## 11. Requisitos Previos

| Herramienta | Version Minima |
|---|---|
| Android Studio | Hedgehog 2023.1.1 |
| JDK | 11 o superior |
| Android SDK | API 24 (Android 7.0) |
| Gradle | 8.x |
| Dispositivo/Emulador | Android 7.0+ |

**Dependencias en `build.gradle` (app):**

```groovy
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    // SQLite ya viene incluido en android.database.sqlite — sin dependencia externa
}
```

La fuente `fontawesome-webfont.ttf` se coloca manualmente en `res/font/` y se carga con:

```java
Typeface iconoFA = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
textViewIcono.setTypeface(iconoFA);
textViewIcono.setText("\uf2e7"); // Icono de utensils (comida)
```

---

## 12. Guia de Instalacion

### 1. Clonar el repositorio

```bash
git clone https://github.com/NEXCODEMX/cuceimart-android.git
cd cuceimart-android
```

### 2. Abrir en Android Studio

`File > Open > Seleccionar carpeta raiz del proyecto`

### 3. Agregar la fuente Font Awesome

Descargar `fontawesome-webfont.ttf` (version 4.7.x) y colocarla en:

```
app/src/main/assets/fonts/fontawesome-webfont.ttf
```

### 4. Sincronizar Gradle

`File > Sync Project with Gradle Files`

### 5. Ejecutar en emulador o dispositivo fisico

- API minima: 24 (Android 7.0)
- Click en el boton **Run** o `Shift + F10`
- La base de datos SQLite se crea automaticamente en el primer inicio via `AyudanteBD.onCreate()`

### 6. Cuentas de prueba

Al iniciar por primera vez, `AyudanteBD.onCreate()` inserta datos de ejemplo:

| Tipo | Correo | Contrasena |
|---|---|---|
| Estudiante | ana@alumnos.udg.mx | cucei2025 |
| Emprendedor | sanza@cucei.mx | nexcode2025 |

---

## 13. Equipo

Desarrollado por **NEXCODE**

| Rol | Nombre |
|---|---|
| Fundador y Desarrollador Principal | Ragknos Demian Fernandez Agraz Rodriguez |
| Colaborador | Carlos Maximiliano Fonseca Farfan |
| Colaborador | Christian Alejandro Garcia Ramirez |

Redes:

- Instagram: [@NexCode_MX](https://instagram.com/NexCode_MX)
- YouTube: [@NexCodeMX](https://youtube.com/@NexCodeMX)
- GitHub: [NEXCODEMX](https://github.com/NEXCODEMX)

---

## 14. Licencia

Este proyecto esta bajo la **Licencia de Uso Academico No Comercial CUCEI MART v1.0**.

El codigo, la arquitectura y la documentacion son de uso exclusivo para el proyecto universitario CUCEI MART dentro del marco academico del CUCEI, Universidad de Guadalajara. No se permite su uso comercial sin autorizacion expresa de NEXCODE.

Consulta el archivo `LICENSE` para los terminos completos.

---

<div align="center">

**© 2025–2026 CUCEI MART — NEXCODE**

*Desarrollado para el Centro Universitario de Ciencias Exactas e Ingenierias (CUCEI)*
*Universidad de Guadalajara · Guadalajara, Jalisco, Mexico*

</div>
