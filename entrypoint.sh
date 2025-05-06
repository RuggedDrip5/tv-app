#!/bin/sh
echo "Waiting for database to start..."
until nc -z postgres 5432; do sleep 1; done
echo "Database started"
exec java -jar /app/app.jar