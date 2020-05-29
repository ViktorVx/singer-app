#!/bin/sh
sudo sudo docker run \
  -d \
  --name postgres-dev \
  -p 5432:5432 \
  -v /home/pg_data:/var/lib/postgresql/data/pgdata \
  -e POSTGRES_PASSWORD=123 \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  postgres:11.4-alpine
