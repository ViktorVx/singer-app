CREATE TABLE poetry
  (
     POETRY_ID        UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1(),
     CREATION_DATE    DATE,
     POEM_NAME        VARCHAR(255),
     AUTHOR           VARCHAR(255),
     POEM_TEXT        VARCHAR(6000),
     USER_OWNER_ID    VARCHAR(128),
     IS_PUBLIC        BOOLEAN
  );

INSERT INTO poetry (POEM_NAME, AUTHOR, CREATION_DATE, USER_OWNER_ID, IS_PUBLIC, POEM_TEXT)
VALUES ('Молчание', 'Омар Хайам', '1125-11-25', '1', TRUE, 'Кешельме-бешельме, шайтанама!');
INSERT INTO poetry (POEM_NAME, AUTHOR, CREATION_DATE, USER_OWNER_ID, IS_PUBLIC, POEM_TEXT)
VALUES ('Ты и вы', 'Пушкин', '1828-11-25', '1', TRUE, 'Пустое вы сердечным ты...');