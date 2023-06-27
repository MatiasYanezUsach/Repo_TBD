INSERT INTO institucion(id,nombre,direccion) VALUES(1,'Institucion 1','Surinam 4353');
INSERT INTO institucion(id,nombre,direccion) VALUES(2,'Institucion 2','Agustinas 2929');

INSERT INTO emergencia(id,nombre,ubicacion,descripcion,id_institucion) VALUES(1,'incendio1','Bulnes 1020','Desc','1');
INSERT INTO emergencia(id,nombre,ubicacion,descripcion,id_institucion) VALUES(2,'explosion1','Boyaca 5848','Explosion atentado',1);
INSERT INTO emergencia(id,nombre,ubicacion,descripcion,id_institucion) VALUES(3,'terremoto-derrumbe','Amunategui 20','Desc2',2);
INSERT INTO emergencia(id,nombre,ubicacion,descripcion,id_institucion) VALUES(4,'terremoto-derrumbe','Andres Bello 2425','derrumbe edificio',2);

INSERT INTO voluntario(id,nombre,correo,contrasenia) VALUES(1,'Alvaro Alvarez','alvaro.alvarez@gmail.cl','1234567');
INSERT INTO voluntario(id,nombre,correo,contrasenia) VALUES(2,'Bartolo Rodriguez','mbrodriguezz@gmail.cl','password321');
INSERT INTO voluntario(id,nombre,correo,contrasenia) VALUES(3,'Catalina Hernandez','cata.h.j@gmail.cl','password');

INSERT INTO habilidad(id,nombre,descripcion) VALUES(1,'Tener vehiculo','El voluntario debe contar con un vehiculo');
INSERT INTO habilidad(id,nombre,descripcion) VALUES(2,'Tener vehiculo grande','El voluntario debe contar con camioneta o camion');
INSERT INTO habilidad(id,nombre,descripcion) VALUES(3,'Primeros auxilios','El voluntario debe tener conocimientos en primeros auxilios');
INSERT INTO habilidad(id,nombre,descripcion) VALUES(4,'Fuerza fisica','El voluntario debe tener gran fuerza fisica');
INSERT INTO habilidad(id,nombre,descripcion) VALUES(5,'Herramientas','El voluntario debe contar con herramientas de excavacion');
INSERT INTO habilidad(id,nombre,descripcion) VALUES(6,'Donaciones','El voluntario puede hacer donaciones de alimentos o vestuarios');

INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(1,1,1);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(2,1,2);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(3,2,1);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(4,2,2);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(5,2,3);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(6,2,4);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(7,2,5);
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES(8,2,6);

INSERT INTO estado_tarea(id,estado) VALUES(1,'Pendiente');
INSERT INTO estado_tarea(id,estado) VALUES(2,'Pendiente');
INSERT INTO estado_tarea(id,estado) VALUES(3,'Pendiente');
INSERT INTO estado_tarea(id,estado) VALUES(4,'Pendiente');
INSERT INTO estado_tarea(id,estado) VALUES(5,'Pendiente');
INSERT INTO estado_tarea(id,estado) VALUES(6,'Pendiente');

INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(1,'tarea1','desc1',1,1);
INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(2,'tarea2','desc2',1,2);
INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(3,'tarea3','desc3',2,3);
INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(4,'tarea4','desc4',2,4);
INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(5,'tarea5','desc5',2,5);
INSERT INTO tarea(id,nombre,descripcion,id_emergencia,id_estado_tarea) VALUES(6,'tarea6','desc6',2,6);

INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(1,1,1);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(2,2,1);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(3,2,2);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(4,3,3);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(5,3,4);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(6,3,5);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(7,3,6);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(8,3,7);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(9,3,8);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(10,4,3);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(11,4,4);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(12,4,5);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(13,4,6);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(14,5,7);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(15,5,8);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(16,6,3);
INSERT INTO tarea_habilidad(id,id_tarea,id_eme_habilidad) VALUES(17,6,8);