-- Table: public.modelo

-- DROP TABLE IF EXISTS public.modelo;

CREATE TABLE IF NOT EXISTS public.modelo
(
    id serial not null,
    nombre character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT modelo_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.modelo
    OWNER to postgres;


-- Table: public.vehiculo

-- DROP TABLE IF EXISTS public.vehiculo;

CREATE TABLE IF NOT EXISTS public.vehiculo
(
    id serial not null,
    patente character varying(10) COLLATE pg_catalog."default",
    id_modelo integer NOT NULL,
    CONSTRAINT vehiculo_pkey PRIMARY KEY (id),
    CONSTRAINT fk_vehiculo_modelo FOREIGN KEY (id_modelo)
        REFERENCES public.modelo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vehiculo
    OWNER to postgres;


-- Table: public.comuna

-- DROP TABLE IF EXISTS public.comuna;

CREATE TABLE IF NOT EXISTS public.comuna
(
    id serial not null,
    nombre character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT comuna_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.comuna
    OWNER to postgres;


-- Table: public.sueldo

-- DROP TABLE IF EXISTS public.sueldo;

CREATE TABLE IF NOT EXISTS public.sueldo
(
    id serial not null,
    monto integer,
    CONSTRAINT sueldo_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sueldo
    OWNER to postgres;


-- Table: public.edificio_estacionamiento

-- DROP TABLE IF EXISTS public.edificio_estacionamiento;

CREATE TABLE IF NOT EXISTS public.edificio_estacionamiento
(
    id serial not null,
    nombre character varying(60) COLLATE pg_catalog."default",
    id_comuna integer,
    CONSTRAINT edificio_estacionamiento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_edificio_estacionamiento_comuna FOREIGN KEY (id_comuna)
        REFERENCES public.comuna (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.edificio_estacionamiento
    OWNER to postgres;


-- Table: public.empleado

-- DROP TABLE IF EXISTS public.empleado;

CREATE TABLE IF NOT EXISTS public.empleado
(
    id serial not null,
    nombre character varying(60) COLLATE pg_catalog."default",
    cargo character varying(60) COLLATE pg_catalog."default",
    id_edificio_estacionamiento integer,
    id_sueldo integer,
    id_comuna integer,
    CONSTRAINT empleado_pkey PRIMARY KEY (id),
    CONSTRAINT fk_empleado_comuna FOREIGN KEY (id_comuna)
        REFERENCES public.comuna (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_empleado_edificio_estacionamiento FOREIGN KEY (id_edificio_estacionamiento)
        REFERENCES public.edificio_estacionamiento (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_empleado_sueldo FOREIGN KEY (id_sueldo)
        REFERENCES public.sueldo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.empleado
    OWNER to postgres;


-- Table: public.cliente

-- DROP TABLE IF EXISTS public.cliente;

CREATE TABLE IF NOT EXISTS public.cliente
(
    id serial not null,
    rut_cliente character varying(10) COLLATE pg_catalog."default",
    nombre character varying(60) COLLATE pg_catalog."default",
    id_comuna integer,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cliente_comuna FOREIGN KEY (id_comuna)
        REFERENCES public.comuna (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente
    OWNER to postgres;


-- Table: public.cliente_vehiculo

-- DROP TABLE IF EXISTS public.cliente_vehiculo;

CREATE TABLE IF NOT EXISTS public.cliente_vehiculo
(
    id serial not null,
    id_cliente integer,
    id_vehiculo integer,
    CONSTRAINT cliente_vehiculo_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cliente_vehiculo_cliente FOREIGN KEY (id_cliente)
        REFERENCES public.cliente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_cliente_vehiculo_vehiculo FOREIGN KEY (id_vehiculo)
        REFERENCES public.vehiculo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente_vehiculo
    OWNER to postgres;


-- Table: public.pago

-- DROP TABLE IF EXISTS public.pago;

CREATE TABLE IF NOT EXISTS public.pago
(
    id serial not null,
    monto integer,
    CONSTRAINT pago_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pago
    OWNER to postgres;


-- Table: public.contrato

-- Table: public.contrato

-- DROP TABLE IF EXISTS public.contrato;

CREATE TABLE IF NOT EXISTS public.contrato
(
    id serial not null,
    duracion integer,
    id_edificio_estacionamiento integer,
    id_cliente_vehiculo integer,
    id_pago integer,
    CONSTRAINT contrato_pkey PRIMARY KEY (id),
    CONSTRAINT fk_contrato_cliente_vehiculo FOREIGN KEY (id_cliente_vehiculo)
        REFERENCES public.cliente_vehiculo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_contrato_edificio_estacionamiento FOREIGN KEY (id_edificio_estacionamiento)
        REFERENCES public.edificio_estacionamiento (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_contrato_pago FOREIGN KEY (id_pago)
        REFERENCES public.pago (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contrato
    OWNER to postgres;

-- Table: public.lugar

-- DROP TABLE IF EXISTS public.lugar;

CREATE TABLE IF NOT EXISTS public.lugar
(
    id serial not null,
    piso integer,
    id_edificio_estacionamiento integer,
    CONSTRAINT lugar_pkey PRIMARY KEY (id),
    CONSTRAINT fk_lugar_edificio_estacionamiento FOREIGN KEY (id_edificio_estacionamiento)
        REFERENCES public.edificio_estacionamiento (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.lugar
    OWNER to postgres;


-- Table: public.lugar_cliveh

-- DROP TABLE IF EXISTS public.lugar_cliveh;

CREATE TABLE IF NOT EXISTS public.lugar_cliveh
(
    id serial not null,
    id_cliente_vehiculo integer,
    id_lugar integer,
    CONSTRAINT lugar_cliveh_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cliente_vehiculo FOREIGN KEY (id_cliente_vehiculo)
        REFERENCES public.cliente_vehiculo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_lugar FOREIGN KEY (id_lugar)
        REFERENCES public.lugar (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.lugar_cliveh
    OWNER to postgres;