FROM mysql:5.7

COPY ./course-management-db.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD root
