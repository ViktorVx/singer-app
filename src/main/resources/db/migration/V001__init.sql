CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE persons
  (
     PERSON_ID        UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1(),
     FIRST_NAME       VARCHAR(255),
     LAST_NAME        VARCHAR(255),
     BIRTH_DATE       DATE,
     GENDER           VARCHAR(1)
  );