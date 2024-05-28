# Taller 2 - Laboratorio de Programación II

## Tomás Eduardo Gutiérrez Olcay

**Profesor:** Óscar Aguayo  
**Fecha:** [28/05/2024]

## Sistema de Administración de Elecciones.

### Descripción del Problema

El objetivo de este taller es desarrollar un sistema que permita **administrar y organizar** elecciones para la organización "Elecciones transparentes", dedicada a la transparencia y eficiencia de elecciones. 
Se busca desarrollar un sistema para las primarias de alcaldes y gobernadores. El sistema debe permitir a los votantwa ver detalles de las elecciones, candidatos participantes y votar electrónicamente. Además, 
a los candidatos les permite gestionar sus campañas y registrar sus detalles. 
El sistema debe permitir mostrar, agregar, eliminar y buscar productos. La búsqueda debe poder realizarse por ID y por marca, y al agregar un producto, la marca debe ser seleccionada de una lista de marcas preexistentes.

### Requerimientos: 
 - Elección: se desea gestionar nombreEleccion, fechaEleccion, lugarEleccion, cargoElegido, y candidatosParticipantes
 - Candidato: Se manejará nombreCandidato, partidoPolitico y cargoPostula
 - Votante: se llevará un control de los votantes registrados para votar, se incluye nombreVotante, rutVotante, contactoVotante y preferenciaPolitica
 - Voto: se gestionarán detalles del voto emitido, candidatoElegido y fechaEmision


### Funcionalidades y detalles
- Una elección presenta uno o más candidatos
- Un candidato puede participar en más de una elección
- Si una elección se cancela, su relación con los candidatos también.
- Un votante puede participar en más de una elección
- Una elección puede tener muchos votantes. Si un votante se da de baja en el sistema, se elimina su relación con la elección/es que asistiría
- Un votante solo puede emitir un voto por elección, eligiendo a uno de los candidatos.
- Si una elección se cancela, se eliminan todos los votos asociados a ella

**Se debe validar la entrada de datos y resultaos. No se pueden duplicar los datos.**
**Uso de funciones auxiliares**
**Considerar uso de excepciones, gestión de errores y mensajes al usuario**
**Usar buenas prácticas**
**No se considera el uso de variables globales**

### Descripción de la Solución Propuesta

Se propone implementar un sistema en Java que siga un patron de diseño MVC que dirigirá la arquitectura del sistema, uso de DAO para la capa de acceso a datos y JavaSwing para la interfaz de usuario, separando la lógica de negocio, la gestión y persistencia de datos y la interfaz gráfica en diferentes paquetes. El sistema gestionará la elecciones (crea eleccion ene le calendario), Administración de candidatos(Registro de candidatos nuevos), Registro votantes (registro votantes ene el sistema). 

**El sistema se dividirá en los siguientes paquetes:**
- **model**: Clases que representan el modelo de datos.
  - **data**: Clases para la conexión y creación de la base de datos.
    - **dao**: Clases para la gestión de los métodos CRUD.
- **gui/vista**: Clases relacionadas con las interfaces gráficas.
- **controller**: Clases que gestionan y extraen los datos de la base de datos y el modelo para mostrarlo en las ventanas gráficas.
- **principal**: Clase que inicializa el proyecto.



### Espacio para UML
![Class Diagram2](https://github.com/TGO74/Taller2LabProgra2/assets/128320982/bbf48f3e-38b9-490f-b859-fcadb61cda28)

(Colocar aquí el diagrama UML correspondiente)

