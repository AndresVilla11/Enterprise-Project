# Build
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
## Docker
```sh
docker pull postgres
```
```sh
docker run \
--name postgres-db\
-e POSTGRES_USER=enterprise\
-e POSTGRES_PASSWORD=mypassword\
-p 5432:5432\
-v /data:/var/lib/postgresql/data\
-d postgres
```
```sh
docker exec -it postgres-db bash
```
```sh
psql -h localhost -U enterprise
```
```sh
CREATE TABLE joiner (
id int UNIQUE,
identification_number int UNIQUE,
name varchar(255),
last_name varchar(255),
stack varchar(255) NOT NULL,
role varchar(255) NOT NULL,
english_level varchar(255) NOT NULL,
domain_experience varchar(255),
PRIMARY KEY(id));
```