-- Database: psicoquimerica

DROP DATABASE psicoquimerica;

CREATE DATABASE psicoquimerica
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.producto

DROP TABLE public.producto;

CREATE TABLE public.producto
(
    pr_id integer NOT NULL DEFAULT nextval('"Producto_pr_id_seq"'::regclass),
    pr_nombre character varying COLLATE pg_catalog."default" NOT NULL,
    pr_precio double precision NOT NULL,
    CONSTRAINT "Producto_pkey" PRIMARY KEY (pr_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.producto
    OWNER to postgres;

