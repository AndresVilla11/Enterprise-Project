# Build
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
## Docker
These are the steps to run postgres in docker for joiner project.

Command to pull postgres image:
```sh
docker pull postgres
```
Command to run the container with postgres image, creating the user and password to use postgres db:
```sh
docker run \
--name postgres-db\
-e POSTGRES_USER=enterprise\
-e POSTGRES_PASSWORD=mypassword\
-p 5432:5432\
-v /data:/var/lib/postgresql/data\
-d postgres
```

Command to enter interact mode for the container created in the previous step:
```sh
docker exec -it postgres-db bash
```

Command to enter to postgres db:
```sh
psql -h localhost -U enterprise
```

Command to create joiner table: 
```sh
CREATE TABLE joiner (
id SERIAL UNIQUE,
identification_number int UNIQUE,
name varchar(255),
last_name varchar(255),
stack varchar(255) NOT NULL,
role varchar(255) NOT NULL,
english_level varchar(255) NOT NULL,
domain_experience varchar(255),
PRIMARY KEY(id));
```