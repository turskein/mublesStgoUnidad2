--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12
-- Dumped by pg_dump version 12.12

-- Started on 2022-11-16 11:51:30

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
-- TOC entry 203 (class 1259 OID 26101)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    category text NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26099)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_id_seq OWNER TO postgres;

--
-- TOC entry 2837 (class 0 OID 0)
-- Dependencies: 202
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;


--
-- TOC entry 205 (class 1259 OID 26112)
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.staff (
    id_staff integer NOT NULL,
    name text NOT NULL,
    lastname text NOT NULL,
    birthday date NOT NULL,
    id_category integer NOT NULL,
    ingress date NOT NULL,
    rut text NOT NULL
);


ALTER TABLE public.staff OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 26110)
-- Name: staff_id_staff_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.staff_id_staff_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_id_staff_seq OWNER TO postgres;

--
-- TOC entry 2838 (class 0 OID 0)
-- Dependencies: 204
-- Name: staff_id_staff_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.staff_id_staff_seq OWNED BY public.staff.id_staff;


--
-- TOC entry 2695 (class 2604 OID 26104)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);


--
-- TOC entry 2696 (class 2604 OID 26115)
-- Name: staff id_staff; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff ALTER COLUMN id_staff SET DEFAULT nextval('public.staff_id_staff_seq'::regclass);


--
-- TOC entry 2829 (class 0 OID 26101)
-- Dependencies: 203
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, category) FROM stdin;
1	A
\.


--
-- TOC entry 2831 (class 0 OID 26112)
-- Dependencies: 205
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.staff (id_staff, name, lastname, birthday, id_category, ingress, rut) FROM stdin;
10	Francisco	Salfate	2000-12-12	1	2022-12-12	23.537.297-5
\.


--
-- TOC entry 2839 (class 0 OID 0)
-- Dependencies: 202
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_id_seq', 1, true);


--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 204
-- Name: staff_id_staff_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.staff_id_staff_seq', 10, true);


--
-- TOC entry 2698 (class 2606 OID 26109)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2700 (class 2606 OID 26120)
-- Name: staff staff_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (id_staff);


--
-- TOC entry 2701 (class 2606 OID 26121)
-- Name: staff fk_id_cat_category; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT fk_id_cat_category FOREIGN KEY (id_category) REFERENCES public.category(id);


-- Completed on 2022-11-16 11:51:30

--
-- PostgreSQL database dump complete
--

