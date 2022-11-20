--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12
-- Dumped by pg_dump version 12.12

-- Started on 2022-11-19 23:41:39

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
11	Alex	Pacheco	2000-12-12	1	2000-12-22	23.537.297-5
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

SELECT pg_catalog.setval('public.staff_id_staff_seq', 11, true);


-- Completed on 2022-11-19 23:41:39

--
-- PostgreSQL database dump complete
--

