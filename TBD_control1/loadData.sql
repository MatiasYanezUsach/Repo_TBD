---tablas independientes

insert into comuna(nombre) values ('Santiago');
insert into comuna(nombre) values ('San Miguel');
insert into comuna(nombre) values ('Estacion Central');
insert into comuna(nombre) values ('Providencia');
insert into comuna(nombre) values ('La Reina');
insert into comuna(nombre) values ('Las Condes');


insert into pago(monto) values (100000);
insert into pago(monto) values (200000);
insert into pago(monto) values (400000);
insert into pago(monto) values (500000);
insert into pago(monto) values (600000);
insert into pago(monto) values (700000);
insert into pago(monto) values (800000);
insert into pago(monto) values (1000000);


insert into modelo(nombre) values ('Tiggo');
insert into modelo(nombre) values ('Hilux');
insert into modelo(nombre) values ('Groove');
insert into modelo(nombre) values ('Gol');
insert into modelo(nombre) values ('Yaris');
insert into modelo(nombre) values ('Rio');
insert into modelo(nombre) values ('V16');
insert into modelo(nombre) values ('Spark');
insert into modelo(nombre) values ('Grand');
insert into modelo(nombre) values ('Accent');
insert into modelo(nombre) values ('Swift');
insert into modelo(nombre) values ('Morning');


insert into sueldo(monto) values (400000);
insert into sueldo(monto) values (500000);
insert into sueldo(monto) values (500000);
insert into sueldo(monto) values (650000);
insert into sueldo(monto) values (800000);



---tablas dependientes, se crean en orden ya que algunas referencian a otras.

insert into cliente(rut_cliente, nombre, id_comuna) values ('19265406-8', 'Mario Carrera',1);
insert into cliente(rut_cliente, nombre, id_comuna) values ('11267746-1', 'Juan Montes',1);
insert into cliente(rut_cliente, nombre, id_comuna) values ('6703152-0', 'Jose Castillo',1);
insert into cliente(rut_cliente, nombre, id_comuna) values ('17962142-8', 'Julio Godoy',2);
insert into cliente(rut_cliente, nombre, id_comuna) values ('15220931-2', 'Samara Lago',2);
insert into cliente(rut_cliente, nombre, id_comuna) values ('14933444-0', 'Elisabeth Toledo',3);
insert into cliente(rut_cliente, nombre, id_comuna) values ('19617713-2', 'Pedro Pozo',4);
insert into cliente(rut_cliente, nombre, id_comuna) values ('18022632-k', 'Luis Alba',4);
insert into cliente(rut_cliente, nombre, id_comuna) values ('10065684-1', 'Maribel Pina',5);
insert into cliente(rut_cliente, nombre, id_comuna) values ('13977101-k', 'Marcos Ibarra',6);
insert into cliente(rut_cliente, nombre, id_comuna) values ('17933127-6', 'Javier Cortes',6);
insert into cliente(rut_cliente, nombre, id_comuna) values ('12379257-2', 'Carlos Campillo',6);
insert into cliente(rut_cliente, nombre, id_comuna) values ('20580142-1', 'Esteban Quito',6);
insert into cliente(rut_cliente, nombre, id_comuna) values ('16291543-1', 'Paulo Castillo',6);


insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio A',1);
insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio B',2);
insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio C',3);
insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio D',4);
insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio E',5);
insert into edificio_estacionamiento(nombre, id_comuna) values ('Edificio F',6);


insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Juan','Supervisor',1,5,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Lucas','Conserje',1,4,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Tomas','Guardia',1,3,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Raul','Tecnico',1,2,6);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Lionel','Auxiliar',1,1,3);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Alvaro','Supervisor',2,5,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Carlos','Conserje',2,4,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Carlos','Guardia',2,3,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Goku','Guardia',2,3,6);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Ricardo','Guardia',2,3,5);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Josue','Tecnico',2,2,4);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Jose','Auxiliar',2,1,5);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Catalina','Supervisor',3,5,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Lucas','Conserje',3,4,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Marisol','Tecnico',3,2,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Camila','Auxiliar',3,1,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Rodolfo','Supervisor',4,5,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Lucas','Conserje',4,4,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Andres','Guardia',4,3,3);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Roberto','Tecnico',4,2,3);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Rodrigo','Auxiliar',4,1,3);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Miguel','Conserje',5,4,4);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Daniel','Guardia',5,3,4);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Juan','Supervisor',6,5,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Isabel','Conserje',6,4,2);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Tomas','Guardia',6,3,1);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Martin','Tecnico',6,2,5);
insert into empleado(nombre,cargo,id_edificio_estacionamiento, id_sueldo, id_comuna) values ('Cristian','Auxiliar',6,1,4);


insert into vehiculo(patente,id_modelo) values ('ABCD10',1);
insert into vehiculo(patente,id_modelo) values ('EFGH23',2);
insert into vehiculo(patente,id_modelo) values ('POAB78',3);
insert into vehiculo(patente,id_modelo) values ('BATU99',4);
insert into vehiculo(patente,id_modelo) values ('CCPR20',5);
insert into vehiculo(patente,id_modelo) values ('AAKJ65',6);
insert into vehiculo(patente,id_modelo) values ('LKJH55',7);
insert into vehiculo(patente,id_modelo) values ('GGWP54',8);
insert into vehiculo(patente,id_modelo) values ('CAWE09',9);
insert into vehiculo(patente,id_modelo) values ('NJUR86',10);
insert into vehiculo(patente,id_modelo) values ('BNVF37',11);
insert into vehiculo(patente,id_modelo) values ('ZXVC01',12);
insert into vehiculo(patente,id_modelo) values ('COVB68',1);
insert into vehiculo(patente,id_modelo) values ('ZAMU12',6);
insert into vehiculo(patente,id_modelo) values ('CKPQ02',9);
insert into vehiculo(patente,id_modelo) values ('MMDJ56',12);
insert into vehiculo(patente,id_modelo) values ('QKJJ15',4);
insert into vehiculo(patente,id_modelo) values ('FFRP00',3);
insert into vehiculo(patente,id_modelo) values ('WERO19',2);
insert into vehiculo(patente,id_modelo) values ('BEER34',1);
insert into vehiculo(patente,id_modelo) values ('ANZU23',9);
insert into vehiculo(patente,id_modelo) values ('AMND01',1);


insert into cliente_vehiculo(id_cliente,id_vehiculo) values (1,1);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (2,2);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (2,3);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (3,4);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (3,5);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (3,6);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (4,7);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (5,8);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (6,9);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (7,10);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (8,11);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (9,12);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (9,13);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (10,14);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (11,15);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (11,16);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (12,17);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (12,18);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (13,19);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (14,20);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (14,21);
insert into cliente_vehiculo(id_cliente,id_vehiculo) values (14,22);

--- Un cliente_vehiculo tiene solo un contrato, si no se dificulta mucho.
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,1,1,8);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,1,2,1);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,1,3,8); 
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (120,1,4,3);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,1,5,8);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (150,1,6,4);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (150,1,7,4);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (150,2,8,4);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,3,9,1);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (30,3,10,1);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (180,3,11,5);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (180,3,12,5);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (180,3,13,5);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (210,4,14,6);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (300,4,15,8);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (300,4,16,8);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (300,4,17,8);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (240,4,18,7);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (240,5,19,7);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (120,5,20,3);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (60,6,21,2);
insert into contrato(duracion, id_edificio_estacionamiento, id_cliente_vehiculo, id_pago) values (60,6,22,2);


insert into lugar(piso, id_edificio_estacionamiento) values (1,1);
insert into lugar(piso, id_edificio_estacionamiento) values (2,1);
insert into lugar(piso, id_edificio_estacionamiento) values (3,1);
insert into lugar(piso, id_edificio_estacionamiento) values (4,1);
insert into lugar(piso, id_edificio_estacionamiento) values (5,1);
insert into lugar(piso, id_edificio_estacionamiento) values (6,1);
insert into lugar(piso, id_edificio_estacionamiento) values (7,1);
insert into lugar(piso, id_edificio_estacionamiento) values (1,2);
insert into lugar(piso, id_edificio_estacionamiento) values (1,2);
insert into lugar(piso, id_edificio_estacionamiento) values (1,2);
insert into lugar(piso, id_edificio_estacionamiento) values (1,2);
insert into lugar(piso, id_edificio_estacionamiento) values (2,2);
insert into lugar(piso, id_edificio_estacionamiento) values (2,2);
insert into lugar(piso, id_edificio_estacionamiento) values (2,2);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,3);
insert into lugar(piso, id_edificio_estacionamiento) values (1,4);
insert into lugar(piso, id_edificio_estacionamiento) values (1,4);
insert into lugar(piso, id_edificio_estacionamiento) values (1,4);
insert into lugar(piso, id_edificio_estacionamiento) values (2,4);
insert into lugar(piso, id_edificio_estacionamiento) values (2,4);
insert into lugar(piso, id_edificio_estacionamiento) values (3,4);
insert into lugar(piso, id_edificio_estacionamiento) values (3,4);
insert into lugar(piso, id_edificio_estacionamiento) values (1,5);
insert into lugar(piso, id_edificio_estacionamiento) values (1,5);
insert into lugar(piso, id_edificio_estacionamiento) values (1,5);
insert into lugar(piso, id_edificio_estacionamiento) values (1,5);
insert into lugar(piso, id_edificio_estacionamiento) values (2,5);
insert into lugar(piso, id_edificio_estacionamiento) values (2,5);
insert into lugar(piso, id_edificio_estacionamiento) values (2,5);
insert into lugar(piso, id_edificio_estacionamiento) values (1,6);
insert into lugar(piso, id_edificio_estacionamiento) values (1,6);
insert into lugar(piso, id_edificio_estacionamiento) values (1,6);
insert into lugar(piso, id_edificio_estacionamiento) values (1,6);
insert into lugar(piso, id_edificio_estacionamiento) values (2,6);
insert into lugar(piso, id_edificio_estacionamiento) values (2,6);
insert into lugar(piso, id_edificio_estacionamiento) values (2,6);

--edificio 1-> lugares 1-7
--edificio 2-> lugares 8-14
--edificio 3-> lugares 15-21
--edificio 4-> lugares 22-28
--edificio 5-> lugares 29-35
--edificio 6-> lugares 36-42

--cliente-vehiculo (1) 
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (1,1);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (1,2);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (1,3);
--cliente-vehiculo (2)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (2,1);
--cliente-vehiculo (3)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (3,4);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (3,5);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (3,6);
--cliente-vehiculo (4)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (4,7);
--cliente-vehiculo (5)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (5,3);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (5,4);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (5,5);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (5,6);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (5,7);
--cliente-vehiculo (6)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (6,1);
--cliente-vehiculo (7)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (7,1);
--cliente-vehiculo (8)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (8,8);
--cliente-vehiculo (9)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (9,15);
--cliente-vehiculo (10)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (10,15);
--cliente-vehiculo (11)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (11,16);
--cliente-vehiculo (12)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (12,17);
--cliente-vehiculo (13)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (13,18);
--cliente-vehiculo (14)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (14,22);
--cliente-vehiculo (15)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (15,22);
--cliente-vehiculo (16)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (16,23);
--cliente-vehiculo (17)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (17,23);
--cliente-vehiculo (18)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (18,22);
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (18,23);
--cliente-vehiculo (19)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (19,29);
--cliente-vehiculo (20)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (20,30);
--cliente-vehiculo (21)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (21,36);
--cliente-vehiculo (22)
insert into lugar_cliveh(id_cliente_vehiculo,id_lugar) values (22,37);