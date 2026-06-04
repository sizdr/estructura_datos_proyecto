# 🐔 Granja Inteligente — Guía para el equipo

---

## ¿Cómo está organizado el proyecto?

```
src/
├── linea_vacunacion/   ← Módulo ya hecho, úsalo de referencia
├── menus/              ← Menú principal y validaciones (NO modificar)
└── modelos/            ← Clase Pollo (NO modificar)
```

Cada subcarpeta es un **paquete**. Debes crear el tuyo para tu módulo.

---

## 📦 Qué paquete y clases debes crear

### Módulo Corral → paquete `corral`

| Clase | Descripción |
|---|---|
| `NodoLista.java` | Nodo de la lista enlazada |
| `Lista.java` | La lista enlazada con todos sus métodos |
| `MenuCorral.java` | El submenú del corral |

### Módulo Almacén → paquete `almacen`

| Clase | Descripción |
|---|---|
| `Huevo.java` | Modelo con los datos de un huevo |
| `NodoPila.java` | Nodo de la pila |
| `Pila.java` | La pila con todos sus métodos |
| `MenuAlmacen.java` | El submenú del almacén |

---

## 🔗 Clases que ya existen y puedes usar

No las copies ni las vuelvas a crear.

**`modelos/`** — Aquí van las clases que representan las entidades del sistema, es decir, los objetos con sus datos. Por ejemplo `Pollo.java` tiene los campos del pollo (id, nombre, peso, etc.). Si tu módulo necesita un modelo propio, como `Huevo.java`, también va en este paquete.

**`menus/`** — Aquí está la lógica base de los menús. `Menu.java` es la clase que todos los menús extienden, y `ErrorValidacion.java` maneja los errores de validación. No debes modificar nada aquí.

**`linea_vacunacion/`** — Módulo ya completo. Revisa `Cola.java` y `Nodo.java` como referencia de cómo implementar tu propia estructura de datos y nodo.

---

## 🗂️ Cómo se relacionan tus clases

Tu menú solo habla con tu estructura. Tu estructura habla con su nodo. El nodo guarda el modelo.

```
MenuCorral  →  Lista  →  NodoLista  →  Pollo
MenuAlmacen →  Pila   →  NodoPila   →  Huevo
```

---

## 📋 Cómo hacer tu menú

Tu clase de menú debe **extender** la clase `Menu` del paquete `menus`. Eso significa que hereda todos sus métodos y solo tienes que implementar dos cosas:

| Método | Qué debe hacer |
|---|---|
| `getOpciones()` | Devolver un `String` con las opciones de tu menú |
| `procesarOpcion(int opcion)` | Recibir el número elegido y llamar al método correspondiente de tu estructura |

El flujo completo ya lo maneja la clase `Menu` por ti:

```
seleccionarOpcion()         ← lo llama el menú principal
  │
  ├─ getOpciones()          ← muestra tus opciones al usuario
  ├─ pedirDatoNumerico()    ← lee y valida que sea un número
  └─ procesarOpcion()       ← tú decides qué hacer con cada número
```

### Métodos disponibles que puedes usar dentro de tu menú

Estos ya vienen de la clase `Menu`, no tienes que programarlos:

| Método | Para qué sirve |
|---|---|
| `pedirDato("mensaje")` | Pide un texto al usuario, no permite vacíos |
| `pedirDatoNumerico("mensaje")` | Pide un número entero, no permite letras ni negativos |
| `mostrarMensaje("mensaje")` | Muestra un mensaje informativo al usuario |

> Abre `MenuVacunacion.java` y sigue exactamente la misma estructura. Solo cambia las opciones y los métodos que llamas.

---

## ⚠️ Reglas

- No uses `ArrayList`, `LinkedList`, `Stack` ni ninguna colección de Java.
- No modifiques ningún archivo que ya existe.
- El método de tu menú debe llamarse `mostrar()` para que el menú principal pueda abrirlo.
- Toda la interfaz va con `JOptionPane`, sin `System.out.println`.