INSERT INTO personas (nombre)VALUES
('Albeiro Silva'),
('Pepito Pérez'),
('Armando Casas'),
('Mark Tacher'),
('Jaime Vélez'),
('Mario Muñoz'),
('Mario Muñoz'),
('Karol Vélez'),
('Maria hoyos');

INSERT INTO pacientes (id_paciente, descripcion) VALUES
  (1, 'Paciente de 22 años, presenta síntomas de ...'),
  (2, 'Descripcion de pepito perez ...'),
  (3, 'Descripcion de Armando Casas ...'),
  (4, 'Descripcion de Mark Tacher ...');

INSERT INTO personal_de_la_salud (id_personasalud, numero_tarjeta_profesional, especialidad, tipo_de_personal) VALUES
(5, 411001, 'Neurólogo', 'Médico especialista'),
(6, 488001, 'Nutricionista', 'Médico especialista'),
(7, 888, '', 'Médico general'),
(8, 8799, 'Otorrino', 'Médico especialista'),
(9, 11799, 'cuidados intensivos', 'enfermera');

INSERT INTO citas (fecha_cita, id_paciente, id_personasalud ) VALUES
('2021-03-11', 1, 5),
('2021-03-18', 1, 5),
('2021-04-11', 1, 5),
('2021-03-19', 1, 5),
('2021-05-19', 2, 5),
('2021-04-21', 2, 6),
('2021-06-19', 1, 6),
('2021-07-19', 1, 6),
('2021-07-19', 3, 5),
('2021-08-19', 3, 6),
('2021-08-19', 3, 5);

INSERT INTO examenes (nombre_examen, fecha_examen, id_paciente, id_personasalud) VALUES
('Resonancia Magnética', '2021-03-11', 1, 5),
('TAC', '2021-05-19', 1, 5),
('Radiografía', '2021-03-11', 1, 6),
('Resonancia Magnética', '2021-03-11', 2, 5),
('Radiografía', '2021-03-11', 2, 5),
('TAC', '2021-03-11', 3, 5);