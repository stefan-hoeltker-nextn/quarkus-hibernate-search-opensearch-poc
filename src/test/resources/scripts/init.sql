CREATE USER NNEWSMA IDENTIFIED BY oracle;
grant connect, resource to NNEWSMA;
grant create table to NNEWSMA;
grant create sequence to NNEWSMA;
grant create view to NNEWSMA;
grant create session to NNEWSMA;
ALTER USER NNEWSMA quota unlimited on USERS;
