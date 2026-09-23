# Prueba técnica - Fútbol 5

API REST desarrollada con Java y Spring Boot para registrar los resultados de los entrenamientos de un equipo de fútbol 5 y calcular los 5 jugadores titulares de la semana.

## Tecnologías

- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Git / GitHub

## Funcionamiento

El equipo realiza 3 entrenamientos por semana.

En cada entrenamiento se registra para cada jugador:

- Potencia de tiro
- Velocidad
- Pases efectivos

El resultado de cada jugador se calcula utilizando los siguientes porcentajes:

- Potencia de tiro: 20%
- Velocidad: 30%
- Pases efectivos: 50%

### Fórmula

```text
resultado = (potenciaTiro * 0.20)
          + (velocidad * 0.30)
          + (pasesEfectivos * 0.50)