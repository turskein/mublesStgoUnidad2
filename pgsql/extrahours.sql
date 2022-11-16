--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12
-- Dumped by pg_dump version 12.12

-- Started on 2022-11-16 11:12:09

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
-- TOC entry 203 (class 1259 OID 26092)
-- Name: extra_hours; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.extra_hours (
    id_extra_hours integer NOT NULL,
    id_staff integer NOT NULL,
    date date NOT NULL,
    amount integer NOT NULL
);


ALTER TABLE public.extra_hours OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26090)
-- Name: extra_hours_id_extra_hours_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.extra_hours_id_extra_hours_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.extra_hours_id_extra_hours_seq OWNER TO postgres;

--
-- TOC entry 2823 (class 0 OID 0)
-- Dependencies: 202
-- Name: extra_hours_id_extra_hours_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.extra_hours_id_extra_hours_seq OWNED BY public.extra_hours.id_extra_hours;


--
-- TOC entry 2687 (class 2604 OID 26095)
-- Name: extra_hours id_extra_hours; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.extra_hours ALTER COLUMN id_extra_hours SET DEFAULT nextval('public.extra_hours_id_extra_hours_seq'::regclass);


--
-- TOC entry 2817 (class 0 OID 26092)
-- Dependencies: 203
-- Data for Name: extra_hours; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.extra_hours (id_extra_hours, id_staff, date, amount) FROM stdin;
\.


--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 202
-- Name: extra_hours_id_extra_hours_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.extra_hours_id_extra_hours_seq', 1, false);


--
-- TOC entry 2689 (class 2606 OID 26097)
-- Name: extra_hours extra_hours_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.extra_hours
    ADD CONSTRAINT extra_hours_pkey PRIMARY KEY (id_extra_hours);


-- Completed on 2022-11-16 11:12:10

--
-- PostgreSQL database dump complete
--

