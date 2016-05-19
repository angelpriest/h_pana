--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.3
-- Dumped by pg_dump version 9.2.2
-- Started on 2016-05-19 14:47:33

SET statement_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1838 (class 1262 OID 52477925)
-- Name: h_pana; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE h_pana WITH TEMPLATE = template0 ENCODING = 'LATIN1' LC_COLLATE = 'es_ES.ISO-8859-1' LC_CTYPE = 'es_ES.ISO-8859-1';


ALTER DATABASE h_pana OWNER TO postgres;

\connect h_pana

SET statement_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 476 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 149 (class 1259 OID 52478035)
-- Name: agenda; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE agenda (
    no_identificacion integer NOT NULL,
    hr_inicial time without time zone NOT NULL,
    hr_final time without time zone NOT NULL,
    fecha date NOT NULL,
    estado character(1)
);


ALTER TABLE public.agenda OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 52477928)
-- Name: cita; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cita (
    no_cita integer NOT NULL,
    fecha date[] NOT NULL,
    hora time with time zone,
    consultorio character varying(3),
    estado character varying(1),
    paciente integer NOT NULL,
    medico integer NOT NULL
);


ALTER TABLE public.cita OWNER TO postgres;

--
-- TOC entry 146 (class 1259 OID 52477986)
-- Name: h_medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE h_medico (
    no_identificacion integer NOT NULL,
    enf_hereditarias character varying,
    enf_sufridas character varying,
    enf_padece character varying,
    alcohol boolean,
    cigarrillo boolean,
    frec_medica integer,
    frec_ejercicio integer,
    fc_actualiza timestamp without time zone NOT NULL
);


ALTER TABLE public.h_medico OWNER TO postgres;

--
-- TOC entry 147 (class 1259 OID 52478006)
-- Name: m_metricas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE m_metricas (
    peso integer,
    altura numeric(2,2),
    presion numeric(3,2),
    trigliceridos numeric(3,2),
    colesterol numeric(3,2),
    glicemia numeric(3,2),
    tiroides numeric(3,2),
    creistina numeric(3,2),
    fc_actualiza timestamp without time zone NOT NULL,
    colesterol_hdi numeric(3,2),
    no_identificacion integer NOT NULL
);


ALTER TABLE public.m_metricas OWNER TO postgres;

--
-- TOC entry 143 (class 1259 OID 52477938)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medico (
    area character varying,
    especialidad character varying,
    no_identificacion integer NOT NULL
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 144 (class 1259 OID 52477944)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE paciente (
    paciente character varying(2),
    ref_familiar integer,
    no_identificacion integer NOT NULL
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 148 (class 1259 OID 52478020)
-- Name: permisos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permisos (
    ds_login integer NOT NULL,
    modulo integer,
    fl_permiso character(1),
    fl_add character varying(1),
    fl_mod character varying(1),
    fl_del character varying(1)
);


ALTER TABLE public.permisos OWNER TO postgres;

--
-- TOC entry 145 (class 1259 OID 52477953)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    no_identificacion integer NOT NULL,
    nombres character varying NOT NULL,
    apellidos character varying NOT NULL,
    telefono_fijo integer,
    telefono_celular integer,
    edad integer NOT NULL,
    fc_nacimiento date NOT NULL,
    e_mail character varying,
    direccion character varying
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 1811 (class 2606 OID 52477935)
-- Name: no_cita; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cita
    ADD CONSTRAINT no_cita PRIMARY KEY (no_cita);


--
-- TOC entry 1817 (class 2606 OID 52477960)
-- Name: no_identificacion; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT no_identificacion PRIMARY KEY (no_identificacion);


--
-- TOC entry 1813 (class 2606 OID 52477980)
-- Name: no_identificacion_eq; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT no_identificacion_eq UNIQUE (no_identificacion);


--
-- TOC entry 1815 (class 2606 OID 52477973)
-- Name: no_identificacion_uq; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY paciente
    ADD CONSTRAINT no_identificacion_uq UNIQUE (no_identificacion);


--
-- TOC entry 1825 (class 2606 OID 52478039)
-- Name: pk_agenda; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY agenda
    ADD CONSTRAINT pk_agenda PRIMARY KEY (no_identificacion);


--
-- TOC entry 1819 (class 2606 OID 52477993)
-- Name: pk_h_medico; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY h_medico
    ADD CONSTRAINT pk_h_medico PRIMARY KEY (no_identificacion, fc_actualiza);


--
-- TOC entry 1821 (class 2606 OID 52478012)
-- Name: pk_metricas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY m_metricas
    ADD CONSTRAINT pk_metricas PRIMARY KEY (no_identificacion, fc_actualiza);


--
-- TOC entry 1823 (class 2606 OID 52478024)
-- Name: pk_permisos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permisos
    ADD CONSTRAINT pk_permisos PRIMARY KEY (ds_login);


--
-- TOC entry 1833 (class 2606 OID 52478040)
-- Name: agenda_no_identificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agenda
    ADD CONSTRAINT agenda_no_identificacion_fkey FOREIGN KEY (no_identificacion) REFERENCES medico(no_identificacion);


--
-- TOC entry 1832 (class 2606 OID 52478030)
-- Name: fk_permisos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permisos
    ADD CONSTRAINT fk_permisos FOREIGN KEY (ds_login) REFERENCES persona(no_identificacion);


--
-- TOC entry 1830 (class 2606 OID 52477994)
-- Name: h_medico_no_identificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY h_medico
    ADD CONSTRAINT h_medico_no_identificacion_fkey FOREIGN KEY (no_identificacion) REFERENCES paciente(no_identificacion);


--
-- TOC entry 1831 (class 2606 OID 52478013)
-- Name: m_metricas_no_identificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY m_metricas
    ADD CONSTRAINT m_metricas_no_identificacion_fkey FOREIGN KEY (no_identificacion) REFERENCES paciente(no_identificacion);


--
-- TOC entry 1827 (class 2606 OID 52477981)
-- Name: medico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cita
    ADD CONSTRAINT medico FOREIGN KEY (medico) REFERENCES medico(no_identificacion);


--
-- TOC entry 1828 (class 2606 OID 52477962)
-- Name: no_identificacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT no_identificacion FOREIGN KEY (no_identificacion) REFERENCES persona(no_identificacion);


--
-- TOC entry 1829 (class 2606 OID 52477967)
-- Name: no_identificacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY paciente
    ADD CONSTRAINT no_identificacion FOREIGN KEY (no_identificacion) REFERENCES persona(no_identificacion);


--
-- TOC entry 1826 (class 2606 OID 52477974)
-- Name: paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cita
    ADD CONSTRAINT paciente FOREIGN KEY (paciente) REFERENCES paciente(no_identificacion);


--
-- TOC entry 1840 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-05-19 14:47:33

--
-- PostgreSQL database dump complete
--

