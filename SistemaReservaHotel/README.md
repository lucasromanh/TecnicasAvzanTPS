# Sistema de Reserva de Hotel

## Descripción
Este proyecto tiene la finalidad de gestionar las reservas en un hotel. El sistema permite realizar reservas de habitaciones, gestionar su disponibilidad y calcular los costos de las reservas, que pueden incluir comodidades y puntos acumulados para el cliente.

## Arquitectura del Sistema

### Interfaces

#### `Habitacion<T>`
Una interfaz genérica para manejar tipos de habitaciones que implementa:
- `getTipo()`: Obtener el tipo de habitación.
- `getPrecio()`: Precio base de la habitación.
- `getComodidades()`: Obtener la lista de comodidades.
- `estaDisponible(fechaInicio: LocalDate, fechaFin: LocalDate)`: Verificar disponibilidad.
- `calcularPrecioTotal(fechaInicio: LocalDate, fechaFin: LocalDate)`: Calcular precio total.

#### `Reserva`
Interfaz para manejar reservas que implementa:
- `getCliente()`: Obtener el cliente.
- `getHabitacion()`: Obtener la habitación.
- `getFechaInicio()`, `getFechaFin()`: Obtener las fechas de la reserva.
- `calcularCosto()`: Calcular el costo total.
- `cancelarReserva()`: Cancelar la reserva.
- `modificarFechas(fechaInicio: LocalDate, fechaFin: LocalDate)`: Modificar la fecha.

#### `Cliente`
Interfaz para manejar información del cliente que implementa:
- `getNombre()`: Obtener el nombre del cliente.
- `getPuntos()`: Obtener los puntos del cliente.
- `acumularPuntos(reserva: Reserva)`: Acumular puntos en su cuenta.

### Clases Abstractas

#### `HabitacionGeneral<T extends Comodidad>`
Clase abstracta que implementa la interfaz `Habitacion` y define:
- Atributos: `tipo`, `precio`, `comodidades`.
- Métodos abstractos necesarios.

#### `Comodidad`
Clase abstracta para las comodidades que define:
- Atributos: `nombre`, `precio`.
- `calcularCosto(fechaInicio: LocalDate, fechaFin: LocalDate)`: Calcular costo de la comodidad.

### Clases Finales

#### `GestorDisponibilidad`
Maneja la disponibilidad de habitaciones:
- `contarReservas(hab: HabitacionGeneral<?>, fechaInicio: LocalDate, fechaFin: LocalDate)`: Cuenta las reservas de una habitación en un rango de fechas.

#### `GestorReservas`
Maneja las operaciones relacionadas con reservas:
- `realizarReserva(cliente: Cliente, hab: Habitacion, fechaInicio: LocalDate, fechaFin: LocalDate)`: Realiza una reserva.
- `cancelarReserva(reserva: Reserva)`: Cancela una reserva.
- `modificarReserva(reserva: Reserva, fechaInicio: LocalDate, fechaFin: LocalDate)`: Modifica una reserva.
- `calcCostoReserva(reserva: Reserva)`: Calcula el costo de una reserva.

#### Tipos de Habitaciones
- **HabitacionSimple**: Implementa `HabitacionGeneral<ComodidadBasica>`.
- **HabitacionDoble**: Implementa `HabitacionGeneral<ComodidadBasica>`.
- **HabitacionSuite**: Implementa `HabitacionGeneral<ComodidadPremium>`.

#### Tipos de Comodidades
- **ComodidadBasica**: Implementa `Comodidad`.
- **ComodidadPremium**: Implementa `Comodidad`.

### Clase `App`
La clase principal que gestiona el proyecto:
- Instancia listas de habitaciones y reservas.
- Instancia gestores de disponibilidad y reservas.
- Crea instancias de habitaciones, comodidades y clientes.
- Realiza y gestiona reservas, calcula costos y puntos acumulados.

## Uso del Sistema

### Ejemplo de Uso
1. Instanciar una lista de habitaciones.
2. Instanciar una lista de reservas.
3. Instanciar el gestor de disponibilidad y reservas.
4. Crear instancias de habitaciones, comodidades y clientes.
5. Realizar reservas y calcular costos y puntos.

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para cualquier cambio.

## Usos
Porfa a quien le sirva, que lo use. pero modifiquen el código para que se adapte a sus necesidades.
Y que no sean lineas iguales y nos afecte a todos

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
