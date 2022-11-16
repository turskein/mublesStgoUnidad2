--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12
-- Dumped by pg_dump version 12.12

-- Started on 2022-11-16 11:11:43

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
-- TOC entry 203 (class 1259 OID 26128)
-- Name: timestamp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."timestamp" (
    id_timestamp integer NOT NULL,
    id_staff integer NOT NULL,
    "time" time without time zone NOT NULL,
    date date NOT NULL
);


ALTER TABLE public."timestamp" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26126)
-- Name: timestamp_id_timestamp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.timestamp_id_timestamp_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.timestamp_id_timestamp_seq OWNER TO postgres;

--
-- TOC entry 2823 (class 0 OID 0)
-- Dependencies: 202
-- Name: timestamp_id_timestamp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.timestamp_id_timestamp_seq OWNED BY public."timestamp".id_timestamp;


--
-- TOC entry 2687 (class 2604 OID 26131)
-- Name: timestamp id_timestamp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."timestamp" ALTER COLUMN id_timestamp SET DEFAULT nextval('public.timestamp_id_timestamp_seq'::regclass);


--
-- TOC entry 2817 (class 0 OID 26128)
-- Dependencies: 203
-- Data for Name: timestamp; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."timestamp" (id_timestamp, id_staff, "time", date) FROM stdin;
62	10	08:00:00	2022-09-01
63	10	19:00:00	2022-09-01
64	10	08:00:00	2022-09-02
65	10	19:00:00	2022-09-02
66	10	08:00:00	2022-09-03
67	10	19:00:00	2022-09-03
68	10	08:00:00	2022-09-04
69	10	19:00:00	2022-09-04
70	10	08:00:00	2022-09-05
71	10	19:00:00	2022-09-05
72	10	08:00:00	2022-09-06
73	10	19:00:00	2022-09-06
74	10	08:00:00	2022-09-07
75	10	19:00:00	2022-09-07
76	10	08:00:00	2022-09-08
77	10	19:00:00	2022-09-08
78	10	08:00:00	2022-09-09
79	10	19:00:00	2022-09-09
80	10	08:00:00	2022-09-10
81	10	19:00:00	2022-09-10
82	10	08:00:00	2022-09-11
83	10	19:00:00	2022-09-11
84	10	08:00:00	2022-09-12
85	10	19:00:00	2022-09-12
86	10	08:00:00	2022-09-13
87	10	19:00:00	2022-09-13
88	10	08:00:00	2022-09-14
89	10	19:00:00	2022-09-14
90	10	08:00:00	2022-09-15
91	10	19:00:00	2022-09-15
92	10	08:00:00	2022-09-16
93	10	19:00:00	2022-09-16
94	10	08:00:00	2022-09-17
95	10	19:00:00	2022-09-17
96	10	08:00:00	2022-09-18
97	10	19:00:00	2022-09-18
98	10	08:00:00	2022-09-19
99	10	19:00:00	2022-09-19
100	10	08:00:00	2022-09-20
101	10	19:00:00	2022-09-20
102	10	08:00:00	2022-09-21
103	10	19:00:00	2022-09-21
104	10	08:00:00	2022-09-22
105	10	19:00:00	2022-09-22
106	10	08:00:00	2022-09-23
107	10	19:00:00	2022-09-23
108	10	08:00:00	2022-09-24
109	10	19:00:00	2022-09-24
110	10	08:00:00	2022-09-25
111	10	19:00:00	2022-09-25
112	10	08:00:00	2022-09-26
113	10	19:00:00	2022-09-26
114	10	08:00:00	2022-09-27
115	10	19:00:00	2022-09-27
116	10	08:00:00	2022-09-28
117	10	19:00:00	2022-09-28
118	10	08:00:00	2022-09-29
119	10	19:00:00	2022-09-29
120	10	08:00:00	2022-09-30
121	10	19:00:00	2022-09-30
122	10	08:00:00	2021-12-01
123	10	08:00:00	2021-12-01
124	10	19:00:00	2202-09-01
125	10	08:00:00	2022-09-02
126	10	19:00:00	2022-09-02
127	10	08:00:00	2022-09-03
128	10	19:00:00	2022-09-03
129	10	08:00:00	2022-09-04
130	10	19:00:00	2022-09-04
131	10	08:00:00	2022-09-05
132	10	19:00:00	2022-09-05
133	10	08:00:00	2022-09-06
134	10	19:00:00	2022-09-06
135	10	08:00:00	2022-09-07
136	10	19:00:00	2022-09-07
137	10	08:00:00	2022-09-08
138	10	19:00:00	2022-09-08
139	10	08:00:00	2022-09-09
140	10	19:00:00	2022-09-09
141	10	08:00:00	2022-09-10
142	10	19:00:00	2022-09-10
143	10	08:00:00	2022-09-11
144	10	19:00:00	2022-09-11
145	10	08:00:00	2022-09-12
146	10	19:00:00	2022-09-12
147	10	08:00:00	2022-09-13
148	10	19:00:00	2022-09-13
149	10	08:00:00	2022-09-14
150	10	19:00:00	2022-09-14
151	10	08:00:00	2022-09-15
152	10	19:00:00	2022-09-15
153	10	08:00:00	2022-09-16
154	10	19:00:00	2022-09-16
155	10	08:00:00	2022-09-17
156	10	19:00:00	2022-09-17
157	10	08:00:00	2022-09-18
158	10	19:00:00	2022-09-18
159	10	08:00:00	2022-09-19
160	10	19:00:00	2022-09-19
161	10	08:00:00	2022-09-20
162	10	19:00:00	2022-09-20
163	10	08:00:00	2022-09-21
164	10	19:00:00	2022-09-21
165	10	08:00:00	2022-09-22
166	10	19:00:00	2022-09-22
167	10	08:00:00	2022-09-23
168	10	19:00:00	2022-09-23
169	10	08:00:00	2022-09-24
170	10	19:00:00	2022-09-24
171	10	08:00:00	2022-09-25
172	10	19:00:00	2022-09-25
173	10	08:00:00	2022-09-26
174	10	19:00:00	2022-09-26
175	10	08:00:00	2022-09-27
176	10	19:00:00	2022-09-27
177	10	08:00:00	2022-09-28
178	10	19:00:00	2022-09-28
179	10	08:00:00	2022-09-29
180	10	19:00:00	2022-09-29
181	10	08:00:00	2022-09-30
183	10	08:00:00	2022-09-01
184	10	19:00:00	2022-09-01
187	10	08:00:00	2022-09-02
188	10	19:00:00	2022-09-02
190	10	08:00:00	2022-09-03
192	10	19:00:00	2022-09-03
182	10	08:00:00	2022-09-01
185	10	19:00:00	2022-09-01
186	10	08:00:00	2022-09-02
189	10	19:00:00	2022-09-02
191	10	08:00:00	2022-09-03
193	10	19:00:00	2022-09-03
194	10	08:00:00	2022-10-14
195	10	19:00:00	2022-09-04
196	10	08:00:00	2022-09-05
197	10	19:00:00	2022-09-05
198	10	08:00:00	2022-09-06
199	10	19:00:00	2022-09-06
200	10	08:00:00	2022-09-07
201	10	19:00:00	2022-09-07
202	10	08:00:00	2022-09-08
203	10	19:00:00	2022-09-08
204	10	08:00:00	2022-09-09
205	10	19:00:00	2022-09-09
206	10	08:00:00	2022-09-10
207	10	19:00:00	2022-09-10
208	10	08:00:00	2022-09-11
209	10	19:00:00	2022-09-11
210	10	08:00:00	2022-09-12
211	10	19:00:00	2022-09-12
212	10	08:00:00	2022-09-13
213	10	19:00:00	2022-09-13
214	10	08:00:00	2022-09-14
215	10	19:00:00	2022-09-14
216	10	08:00:00	2022-09-15
217	10	19:00:00	2022-09-15
218	10	08:00:00	2022-09-16
219	10	19:00:00	2022-09-16
220	10	08:00:00	2022-09-17
221	10	19:00:00	2022-09-17
222	10	08:00:00	2022-09-18
223	10	19:00:00	2022-09-18
224	10	08:00:00	2022-09-19
225	10	19:00:00	2022-09-19
226	10	08:00:00	2022-09-20
227	10	19:00:00	2022-09-20
228	10	08:00:00	2022-09-21
229	10	19:00:00	2022-09-21
230	10	08:00:00	2022-09-22
231	10	19:00:00	2022-09-22
232	10	08:00:00	2022-09-23
233	10	19:00:00	2022-09-23
234	10	08:00:00	2022-09-24
235	10	19:00:00	2022-09-24
236	10	08:00:00	2022-09-25
237	10	19:00:00	2022-09-25
238	10	08:00:00	2022-09-26
239	10	19:00:00	2022-09-26
240	10	08:00:00	2022-09-27
241	10	19:00:00	2022-09-27
242	10	08:00:00	2022-09-28
243	10	19:00:00	2022-09-28
244	10	08:00:00	2022-09-29
245	10	19:00:00	2022-09-29
246	10	08:00:00	2022-09-30
\.


--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 202
-- Name: timestamp_id_timestamp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.timestamp_id_timestamp_seq', 246, true);


--
-- TOC entry 2689 (class 2606 OID 26133)
-- Name: timestamp timestamp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."timestamp"
    ADD CONSTRAINT timestamp_pkey PRIMARY KEY (id_timestamp);


-- Completed on 2022-11-16 11:11:43

--
-- PostgreSQL database dump complete
--
