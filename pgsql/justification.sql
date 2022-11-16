--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12
-- Dumped by pg_dump version 12.12

-- Started on 2022-11-16 11:12:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 26083)
-- Name: justification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.justification (
    id_justification bigint NOT NULL,
    id_staff integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.justification OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26081)
-- Name: justification_id_justification_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.justification_id_justification_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.justification_id_justification_seq OWNER TO postgres;

--
-- TOC entry 2823 (class 0 OID 0)
-- Dependencies: 202
-- Name: justification_id_justification_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.justification_id_justification_seq OWNED BY public.justification.id_justification;


--
-- TOC entry 2687 (class 2604 OID 26086)
-- Name: justification id_justification; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.justification ALTER COLUMN id_justification SET DEFAULT nextval('public.justification_id_justification_seq'::regclass);


--
-- TOC entry 2817 (class 0 OID 26083)
-- Dependencies: 203
-- Data for Name: justification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.justification (id_justification, id_staff, date) FROM stdin;
\.


--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 202
-- Name: justification_id_justification_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.justification_id_justification_seq', 1, false);


--
-- TOC entry 2689 (class 2606 OID 26088)
-- Name: justification justification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.justification
    ADD CONSTRAINT justification_pkey PRIMARY KEY (id_justification);


-- Completed on 2022-11-16 11:12:27

--
-- PostgreSQL database dump complete
--

