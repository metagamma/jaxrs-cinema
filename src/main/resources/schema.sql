DROP SCHEMA IF EXISTS Cine;
CREATE SCHEMA Cine;
USE Cine;

CREATE TABLE IF NOT EXISTS Director (
    Director_id SMALLINT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(64) NOT NULL,
    Apellido VARCHAR(64) NOT NULL,
    PRIMARY KEY (Director_id)
);

CREATE TABLE IF NOT EXISTS Clasificacion (
    Clasificacion_id TINYINT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(8) NOT NULL,
    PRIMARY KEY (Clasificacion_id)
);

CREATE TABLE IF NOT EXISTS Genero (
    Genero_id TINYINT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(48) NOT NULL,
    PRIMARY KEY (Genero_id)
);

CREATE TABLE IF NOT EXISTS Formato (
    Formato_id TINYINT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(48) NOT NULL,
    PRIMARY KEY (Formato_id)
);

CREATE TABLE IF NOT EXISTS Sede (
    Sede_id TINYINT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(48) NOT NULL,
    Telefono VARCHAR(10) NOT NULL,
    Capacidad SMALLINT NOT NULL,
    PRIMARY KEY (Sede_id)
);

CREATE TABLE IF NOT EXISTS Pelicula (
    Pelicula_id INT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(128) NOT NULL,
    Imagen VARCHAR(256) NOT NULL,
    Sinopsis VARCHAR(512) NOT NULL,
    Duracion SMALLINT NOT NULL,
    Director_id SMALLINT UNSIGNED NULL,
    Clasificacion_id TINYINT UNSIGNED NULL,
    Genero_id TINYINT UNSIGNED NULL,
    Formato_id TINYINT UNSIGNED NULL,
    Sede_id TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (Pelicula_id),
    CONSTRAINT FK_Pelicula_Formato FOREIGN KEY (Formato_id)
        REFERENCES Formato (Formato_id),
    CONSTRAINT FK_Pelicula_Director FOREIGN KEY (Director_id)
        REFERENCES Director (Director_id),
    CONSTRAINT FK_Pelicula_Clasificacion FOREIGN KEY (Clasificacion_id)
        REFERENCES Clasificacion (Clasificacion_id),
    CONSTRAINT FK_Pelicula_Genero FOREIGN KEY (Genero_id)
        REFERENCES Genero (Genero_id),
    CONSTRAINT FK_Pelicula_Sede FOREIGN KEY (Sede_id)
        REFERENCES Sede (Sede_id)
);

CREATE TABLE IF NOT EXISTS Funcion (
    Funcion_Id INT UNSIGNED AUTO_INCREMENT,
    FechaFuncion DATE NOT NULL,
    Pelicula_id INT UNSIGNED NOT NULL,
    NumeroSala TINYINT UNSIGNED,
    HoraInicio TIME NOT NULL,
    HoraFin TIME NOT NULL,
    Sede_id TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (Funcion_Id),
    CONSTRAINT FK_Funcion_Pelicula FOREIGN KEY (Pelicula_id)
        REFERENCES Pelicula (Pelicula_id),
    CONSTRAINT FK_Funcion_Sede FOREIGN KEY (Sede_id)
        REFERENCES Sede (Sede_id)
);

CREATE TABLE IF NOT EXISTS Cliente (
    Cliente_id INT UNSIGNED AUTO_INCREMENT,
    Dni CHAR(8) NULL UNIQUE,
    Nombre VARCHAR(32) NOT NULL,
    ApellidoPaterno VARCHAR(32) NOT NULL,
    ApellidoMaterno VARCHAR(32) NOT NULL,
    Fecha_nacimiento DATE NULL,
    Correo VARCHAR(64) NULL,
    Tarjeta CHAR(16) NULL,
    CVV VARCHAR(3) NULL,
    PRIMARY KEY (Cliente_id)
);

CREATE TABLE IF NOT EXISTS Empleado (
    Empleado_id INT UNSIGNED AUTO_INCREMENT,
    Nombre VARCHAR(32) NOT NULL,
    ApellidoPaterno VARCHAR(32) NOT NULL,
    ApellidoMaterno VARCHAR(32) NOT NULL,
    Usuario VARCHAR(32) NOT NULL,
    Clave VARCHAR(64) NOT NULL,
    Sede_id TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (Empleado_id),
    CONSTRAINT FK_Empleado_Sede FOREIGN KEY (Sede_id)
        REFERENCES Sede (Sede_id)
);

CREATE TABLE IF NOT EXISTS OrdenVenta (
    OrdenVenta_id INT UNSIGNED AUTO_INCREMENT,
    CodigoReserva VARCHAR(8) NULL,
    Cliente_id INT UNSIGNED NULL,
    Empleado_id INT UNSIGNED NULL,
    Funcion_Id INT UNSIGNED NULL,
    Asiento TINYINT NOT NULL,
    Fila CHAR(1) NOT NULL,
    Cantidad TINYINT NOT NULL,
    Monto DECIMAL(5 , 2 ) NOT NULL,
    PRIMARY KEY (OrdenVenta_id),
    CONSTRAINT FK_OrdenVenta_Cliente FOREIGN KEY (Cliente_id)
        REFERENCES Cliente (Cliente_id),
    CONSTRAINT FK_OrdenVenta_Empleado FOREIGN KEY (Empleado_id)
        REFERENCES Empleado (Empleado_id),
    CONSTRAINT FK_OrdenVenta_Funcion FOREIGN KEY (Funcion_Id)
        REFERENCES Funcion (Funcion_Id)
);
