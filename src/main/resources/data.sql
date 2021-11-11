USE Cine;

INSERT INTO Director (Nombre, Apellido) VALUES 
('George','Lucas'),
('Tim','Burton'),
('Frank','Darabont'),
('Francis','Ford Coppola'),
('Christopher','Nolan'),
('Sidney','Lumet'),
('Steven','Spielberg'),
('Peter','Jackson'),
('Quentin','Tarantino'),
('Sergio','Leone'),
('David','Fincher'),
('Robert','Zemeckis'),
('Irvin','Kershner'),
('Milos','Forman'),
('Martin','Scorsese'),
('Akira','Kurosawa'),
('Jean-Pierre','Jeunet'),
('Jonathan','Demme'),
('Tony','Kaye'),
('Fernando','Meirelles'),
('Roberto','Benigni'),
('Stanley','Kubrick'),
('Sam','Mendes'),
('Ethan','Coen');

SELECT * FROM Director;

INSERT INTO Clasificacion (Nombre) VALUES
('APT'),
('+14'),
('+18');

SELECT * FROM Clasificacion;

INSERT INTO Genero (Nombre) VALUES 
('Drama'),
('Ciencia Ficción'),
('Terror'),
('Comedio'),
('Acción'),
('Intriga'),
('Aventuras'),
('Animación'),
('Romance'),
('Bélico'),
('Histórico'),
('Musical'),
('Wester');

SELECT * FROM Genero;

INSERT INTO Formato (Nombre) VALUES
('Widescreen'),
('XD'),
('D-BOX'),
('IMAX'),
('3D');

SELECT * FROM Formato;

INSERT INTO Sede (Nombre, Telefono, Capacidad) VALUES
('Lima sur','12345671',5000),
('Lima norte','22345672',5200),
('Lima este','32345673',3400),
('Lima oeste','42345674',5600),
('Lima centro','52345675',6000);

SELECT * FROM Sede;

INSERT INTO Pelicula (Nombre, Imagen, Sinopsis, Duracion, Director_id, Clasificacion_id, Genero_id, Formato_id, Sede_id) VALUES
('Cadena perpetua','https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg','Un hombre inocente es enviado a una corrupta penitenciaria de Maine en 1947 y sentenciado a dos cadenas perpetuas por un doble asesinato.',142,3,2,1,4,1),
('El padrino','https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,704,1000_AL_.jpg','Una adaptación ganadora del Premio de la Academia, de la novela de Mario Puzo acerca de la familia Corleone.',178,4,2,1,2,2),
('El caballero oscuro','https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg','Batman tiene que mantener el equilibrio entre el heroísmo y el vigilantismo para pelear contra un vil criminal conocido como el Guasón, que sumiría a Ciudad Gótica en la anarquía.',152,5,2,1,1,3),
('La lista de Schindler','https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,666,1000_AL_.jpg','El industrialista alemán Oskar Schindler (Liam Neeson) urde un plan con su contador (Ben Kingsley) para rescatar prisioneros judíos de los nazis.',192,7,2,1,4,4),
('Pulp Fiction','https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,686,1000_AL_.jpg','Quentin Tarantino se enfoca en un grupo de violentos personajes en esta historia sobre la vida criminal.',178,9,2,1,4,5),
('El club de la lucha','https://m.media-amazon.com/images/M/MV5BMjJmYTNkNmItYjYyZC00MGUxLWJhNWMtZDY4Nzc1MDAwMzU5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,676,1000_AL_.jpg','El lado oscuro de un trabajador de cuello blanco sale a flote en un club clandestino donde los hombres pelean a muerte.',151,11,2,1,2,1),
('Forrest Gump','https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg','La simpleza e inocencia de un sureño lo impulsan a través de hechos importantes de la historia moderna de EE.UU.',144,12,2,1,1,2),
('Alguien voló sobre el nido del cuco','https://m.media-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,672,1000_AL_.jpg','Un grupo de pacientes mentales sigue a Randle P. McMurphy, el personaje inadaptado social de la novela de Ken Kesey.',134,14,2,1,4,2),
('Ciudad de Dios','https://m.media-amazon.com/images/M/MV5BMGU5OWEwZDItNmNkMC00NzZmLTk1YTctNzVhZTJjM2NlZTVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_CR0,0,677,1000_AL_.jpg','Después de formar una pandilla en Río de Janeiro, un joven y su mejor amigo pasan de los robos, al narcotráfico y a los asesinatos.',135,20,2,1,2,3),
('El silencio de los corderos','https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,677,1000_AL_.jpg','Una agente en entrenamiento del FBI busca la ayuda y consejo de un brillante asesino para poder capturar a otro asesino, el doctor Hannibal Lecter, un psiquiatra que también es un psicópata violento y antropófago.',138,18,2,1,2,4),
('La vida es bella','https://m.media-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_SX670_AL_.jpg','Un hombre construye una elaborada fantasía para proteger a su hijo de la vida en un campo de concentración nazi.',122,21,2,1,4,5),
('American History X','https://m.media-amazon.com/images/M/MV5BZjA0MTM4MTQtNzY5MC00NzY3LWI1ZTgtYzcxMjkyMzU4MDZiXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_.jpg','Tras ser liberado de la cárcel, un ex neonazi trata de evitar que su hermano menor siga sus pasos en la senda del odio.',119,19,2,1,2,1),
('El pianista','https://m.media-amazon.com/images/M/MV5BOWRiZDIxZjktMTA1NC00MDQ2LWEzMjUtMTliZmY3NjQ3ODJiXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,724,1000_AL_.jpg','El estilo de vida privilegiada de un músico judío llega a su fin con la invasión nazi y los horrores del holocausto.',150,3,2,1,2,2),
('Infiltrados','https://m.media-amazon.com/images/M/MV5BMTI1MTY2OTIxNV5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_.jpg','Billy Costigan, policía del Sur de Boston, trabaja de forma encubierta para infiltrarse en la organización de la pandilla del jefe Frank Costello. Como Billy se gana la confianza del gángster, un criminal de carrera llamado Colin Sullivan se infiltra en la policía y reporta sus actividades a los jefes de su sindicato.',151,15,2,1,1,3),
('Apocalypse Now','https://m.media-amazon.com/images/M/MV5BZTNkZmU0ZWQtZjQzMy00YTNmLWFmN2MtZGNkMmU1OThmMGYwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,652,1000_AL_.jpg','Controvertida historia sobre la misión de un capitán del ejército de encontrar y matar a un oficial renegado en Camboya.',153,4,2,1,4,4),
('Memento','https://m.media-amazon.com/images/M/MV5BZTcyNjk1MjgtOWI3Mi00YzQwLWI5MTktMzY4ZmI2NDAyNzYzXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,681,1000_AL_.jpg','Un hombre con problemas de memoria usa notas, fotografías y tatuajes para hallar al asesino de su esposa.',113,5,2,1,2,5),
('El resplandor','https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg','Jack Torrance se convierte el cuidador de invierno del desolado Hotel Overlook, en Colorado con la esperanza de curar su bloqueo de escritor. Se instala en el hotel junto con su esposa, Wendy, y su hijo, Danny, que está plagado de premoniciones psíquicas.',146,22,2,1,2,1),
('American Beauty','https://m.media-amazon.com/images/M/MV5BNTBmZWJkNjctNDhiNC00MGE2LWEwOTctZTk5OGVhMWMyNmVhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg','La visión de un joven núbil inspira a un esposo a aprovechar su última oportunidad para lograr la verdadera felicidad.',122,23,2,1,2,2),
('Amelie','https://m.media-amazon.com/images/M/MV5BNDg4NjM1YjMtYmNhZC00MjM0LWFiZmYtNGY1YjA3MzZmODc5XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SY1000_CR0,0,666,1000_AL_.jpg','El hallazgo de un tesoro olvidado pone a una camarera parisina a cuestionar, y alterar la vida de quienes la rodean.',129,17,2,1,4,3),
('Taxi Driver','https://m.media-amazon.com/images/M/MV5BM2M1MmVhNDgtNmI0YS00ZDNmLTkyNjctNTJiYTQ2N2NmYzc2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,658,1000_AL_.jpg','Un veterano de Vietnam inicia una confrontación violenta con los proxenetas que trabajan en las calles de Nueva York.',114,15,2,1,2,4),
('El gran Lebowski','https://m.media-amazon.com/images/M/MV5BMTQ0NjUzMDMyOF5BMl5BanBnXkFtZTgwODA1OTU0MDE@._V1_SY1000_CR0,0,670,1000_AL_.jpg','Un desempleado es confundido por unos matones con el millonario Jeff Lebowski, quien se llama igual que él y a cuya esposa han secuestrado. Cuando acude a casa del millonario para quejarse, éste decide contratarlo para rescatar a su esposa a cambio de una recompensa.',119,24,2,1,4,5);

SELECT * FROM Pelicula;

INSERT INTO Funcion (Pelicula_id, NumeroSala, FechaFuncion, HoraInicio, HoraFin, Sede_id) VALUES
(1,1,'2018-01-11','20:00','22:30',1);

SELECT * FROM Funcion;

INSERT INTO Cliente (Dni, Nombre, ApellidoPaterno, ApellidoMaterno, Fecha_nacimiento, Correo, Tarjeta, CVV) VALUES 
('15358586','Henry','Londres','Hertz','1985-01-04','henry@mail.com','1452145698754126','475'),
('14758512','Gerónimo','Paredes','Arana','1998-06-07','geronimo@mail.com','2452145698754126','118'),
('48959536','Lucía','Garcia','Alba','1993-04-03','lucia@mail.com','3452145698754126','411'),
('69258589','Marco','Robles','Costa','1984-09-02','marco@mail.com','4452145698754126','468'),
('14845194','Marta','Egea','Espejo','1989-12-01','marta@mail.com','5452145698754126','578'),
('86532819','Bryan','Camps','Espinoza','1992-05-24','bryan@mail.com','6452145698754126','478'),
('98989588','Walter','Cárdenes','Escobar','1991-01-16','walter@mail.com','7452145698754126','378'),
('89859871','Fabian','Bernal','Nadal','1997-05-23','fabian@mail.com','8452145698754126','278'),
('45654583','Raúl','Aznar','Oliva','1996-04-06','raul@mail.com','9452145698754126','178');

SELECT * FROM Cliente;

INSERT INTO Empleado (Nombre, ApellidoPaterno, ApellidoMaterno, Usuario, Clave, Sede_id) VALUES
('Beatriz','Villa','Vera','bvilla','123',1),
('Julio','Zamora','Ugarte','jzamora','123',1),
('Mary','Torres','Sosa','mtorres','123',3),
('Wendy','Salazar','Ruiz','wsalazar','123',1),
('Carlos','Moya','Sáez','cmoya','123',2),
('Victoria','Pacheco','Romero','vpacheco','123',2),
('Sofía','Ponce','Polo','sponce','123',3),
('Irene','Naranjo','Roma','inaranjo','123',4),
('Ramón','Mora','Rivero','rmora','123',5),
('Rubén','Nevado','Herrera','rnevado','123',4),
('Alejandro','Rojas','Goñi','arojas','123',5);

SELECT * FROM Empleado;

INSERT INTO OrdenVenta (CodigoReserva, Cliente_id, Empleado_id, Funcion_Id, Asiento, Fila, Cantidad, Monto) VALUES
('V455-001',1,8,1,14,'A',1,15.00),
('V455-002',2,1,1,13,'B',2,30.00),
('V455-003',3,2,1,11,'C',2,30.00),
('V455-004',4,3,1,10,'D',1,15.00),
('V455-005',5,7,1,27,'E',2,30.00),
('V455-006',6,8,1,18,'F',1,15.00),
('V455-007',7,1,1,20,'G',3,45.00),
('V455-008',8,1,1,16,'H',2,30.00),
('V455-009',8,1,1,12,'I',3,45.00),
('V455-010',1,3,1,30,'A',1,15.00),
('V455-011',2,8,1,15,'B',2,30.00),
('V455-012',3,5,1,12,'C',1,15.00),
('V455-013',4,6,1,18,'D',2,30.00),
('V455-014',5,4,1,29,'E',4,60.00),
('V455-015',6,6,1,36,'F',1,15.00),
('V455-016',7,1,1,30,'G',2,30.00),
('V455-017',8,8,1,31,'H',2,30.00);

SELECT * FROM OrdenVenta;