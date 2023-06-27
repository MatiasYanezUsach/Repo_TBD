--- 1) lista de clientes que gasta más por edificio
--Vista que hace un group by por cada combinacion de cliente y edificio.
--Se selecciona el id de cliente, el monto pagado por edificio, y el edificio correspondientee.
--Recordar que un cliente puede tener contrato con varios edificios.
CREATE OR REPLACE VIEW montos_totales AS
    SELECT cv.id_cliente as numcliente, c.id_edificio_estacionamiento as edificio, sum(p.monto) as pago_total
    FROM cliente_vehiculo as cv, contrato as c, pago as p
    WHERE cv.id=c.id_cliente_vehiculo and c.id_pago=p.id  
    GROUP BY c.id_edificio_estacionamiento, cv.id_cliente;

--Vista que genera una tabla con pares del tipo (edificio, maximo monto gastado)
CREATE OR REPLACE VIEW maximo_por_edificio AS
    SELECT mt.edificio as ided, max(mt.pago_total) as maximo
    FROM montos_totales as mt
    GROUP BY mt.edificio;

--Se seleccionan todos los clientes cuyo monto total sea igual al monto
--maximo de cada edificio.
select ee.nombre as nombre_edificio, cl.nombre as nombre_cliente, mpe.maximo as monto
from maximo_por_edificio as mpe, montos_totales as mt1, edificio_estacionamiento as ee, cliente as cl
where mpe.maximo=mt1.pago_total and mpe.ided=mt1.edificio and mpe.ided=ee.id and mt1.numcliente=cl.id;


--- 2) modelos de auto menos recurrente por edificio
SELECT agrupacion.id_modelo, agrupacion.id, COUNT(*) as suma
FROM (
	SELECT mo.nombre, ve.id_modelo, ee.id
    FROM public.vehiculo as ve, public.cliente_vehiculo as cv,
	        public.contrato as co, public.edificio_estacionamiento as ee,
	        public.modelo as mo
    WHERE ve.id = cv.id_vehiculo
	      AND cv.id = co.id_cliente_vehiculo
	      AND co.id_edificio_estacionamiento = ee.id
	      AND mo.id = ve.id_modelo
     ) AS agrupacion
GROUP BY agrupacion.id_modelo, agrupacion.id
ORDER BY suma ASC, agrupacion.id;

--- 3) empleados con mayor y menor sueldo por edificio
CREATE OR REPLACE VIEW mayor_sueldo AS
    SELECT max(s.monto) as maximo
    FROM public.sueldo as s;
    
CREATE OR REPLACE VIEW menor_sueldo AS 
    SELECT min(s.monto) as minimo
    FROM public.sueldo as s;

CREATE OR REPLACE VIEW id_max_sueldo AS
    SELECT s.id as id_max
    FROM mayor_sueldo as ms, public.sueldo as s
    where ms.maximo = s.monto;
    
CREATE OR REPLACE VIEW id_min_sueldo AS
    SELECT s.id as id_min
    FROM menor_sueldo as ms, public.sueldo as s
    where ms.minimo = s.monto;    

CREATE OR REPLACE VIEW empleados_con_mayor_sueldo AS
    SELECT e.nombre, e.id_edificio_estacionamiento, e.id_sueldo
    FROM public.empleado as e, id_max_sueldo as ims
    WHERE e.id_sueldo = ims.id_max;

CREATE OR REPLACE VIEW empleados_con_menor_sueldo AS
    SELECT e.nombre, e.id_edificio_estacionamiento, e.id_sueldo
    FROM public.empleado as e, id_min_sueldo as ims
    WHERE e.id_sueldo = ims.id_min;

--- 4) lista de comunas con la cantidad de clientes que residen en ellas
SELECT co.nombre, COUNT(cl.id)
FROM public.comuna as co, public.cliente as cl
WHERE cl.id_comuna = co.id
GROUP BY co.nombre
ORDER BY COUNT(cl.id) DESC;


--- 5) lista de edificio con más lugares disponibles (sin contrato)
CREATE or REPLACE view lugares_desocupados as
    select l.id as lug
    from lugar as l
    EXCEPT
    select distinct lc.id_lugar
    from lugar_cliveh as lc;

CREATE or REPLACE view edificio_lugares_desocupados as
    select l.id_edificio_estacionamiento, count(*) as cantidad
    from lugares_desocupados as ld, lugar as l
    where ld.lug=l.id
    group by l.id_edificio_estacionamiento;

CREATE or REPLACE view maximo_desoc as
    select max(cantidad) as max_desoc
    from edificio_lugares_desocupados;

select ee.nombre as nombre_edificio, eld.cantidad as lugares_disponibles
from maximo_desoc as md, edificio_lugares_desocupados as eld, edificio_estacionamiento as ee
where md.max_desoc=eld.cantidad and eld.id_edificio_estacionamiento=ee.id;


--- 6) lista de edificio con menos lugares disponibles
CREATE OR REPLACE VIEW lugares AS
SELECT lc.id_lugar, COUNT(*) AS cantidad
FROM public.lugar_cliveh AS lc
GROUP BY lc.id_lugar
ORDER BY cantidad
DESC;

SELECT lg.id_edificio_estacionamiento, COUNT(*) AS cantidad
FROM public.lugar AS lg, public.lugares
WHERE lg.id = lugares.id_lugar
GROUP BY lg.id_edificio_estacionamiento
ORDER BY cantidad
ASC;

--- 7) lista de clientes con más autos por edificio
CREATE OR REPLACE VIEW gasto_cliente AS
	select c.id_edificio_estacionamiento, cv.id_cliente, sum(p.monto) as mont
	from cliente_vehiculo as cv, contrato as c, pago as p
	where c.id_cliente_vehiculo=cv.id and c.id_pago=p.id
	group by c.id_edificio_estacionamiento,cv.id_cliente;

CREATE OR REPLACE VIEW gasto_maximo AS
	select gc.id_edificio_estacionamiento, max(mont) as max_monto
	from gasto_cliente as gc
	group by gc.id_edificio_estacionamiento;
	
select gm.id_edificio_estacionamiento, c.nombre, gm.max_monto
from gasto_cliente as gc, gasto_maximo as gm, cliente as c
where gm.max_monto=gc.mont and gm.id_edificio_estacionamiento=gc.id_edificio_estacionamiento and gc.id_cliente=c.id;


--- 8) lugar más usado por edificio
CREATE OR REPLACE VIEW lugar_mas_usado AS
    SELECT lcv.id_lugar AS numero_lugar, COUNT(*) AS cantidad
    FROM public.lugar_cliveh AS lcv
    GROUP BY lcv.id_lugar;

CREATE OR REPLACE VIEW uso_maximo_edificio AS
    SELECT l.id_edificio_estacionamiento AS ide, MAX(cantidad) AS maximo
    FROM lugar AS l, lugar_mas_usado AS lmu
    WHERE l.id = lmu.numero_lugar
    GROUP BY l.id_edificio_estacionamiento
    ORDER BY l.id_edificio_estacionamiento ASC;

SELECT ee.nombre,l.id,lmu.cantidad
FROM uso_maximo_edificio AS ume,lugar_mas_usado AS lmu,lugar AS l, edificio_estacionamiento AS ee
WHERE ume.maximo=lmu.cantidad AND ume.ide=l.id_edificio_estacionamiento 
	AND lmu.numero_lugar=l.id AND ume.ide=ee.id;


--- 9) edificio con más empleados, indicando el número de empleados de ese edificio
CREATE OR REPLACE VIEW mas_empleados AS
	SELECT e.id_edificio_estacionamiento as id_edificio, count(*) as cantidad
	FROM public.empleado as e
	GROUP BY e.id_edificio_estacionamiento;

CREATE OR REPLACE VIEW edificio_mas_empleados AS
	SELECT max(cantidad) as maximo
	FROM mas_empleados as mem;

SELECT ed.nombre, cantidad
FROM mas_empleados as mem, public.edificio_estacionamiento as ed, edificio_mas_empleados as eme
WHERE eme.maximo = mem.cantidad and ed.id = mem.id_edificio;


--- 10) lista de sueldos por tipo de empleado por edificio, destacar la comuna del edificio
SELECT em.cargo, s.monto, ee.nombre, co.nombre
FROM public.sueldo as s, public.empleado as em, 
    public.edificio_estacionamiento as ee, public.comuna as co
WHERE s.id = em.id_sueldo
    AND ee.id = em.id_edificio_estacionamiento
    AND ee.id_comuna = co.id;
