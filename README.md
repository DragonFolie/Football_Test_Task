# SynergyTestTask

What you need to start the project:

1) docker run --name synergy_container -p 3307:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql/mysql-server:5.7

2) docker exec -it synergy_container bash
   Password is 1234

3) CREATE USER 'demo_java' IDENTIFIED BY 'java';
   grant all on *.* to 'demo_java'@'%' identified by '1234';
   FLUSH PRIVILEGES;

4) CREATE DATABASE synergy CHARACTER SET utf8 COLLATE utf8_general_ci;  

5)  insert data which are in /Data folder  ( *.sql files )

Additional Information

For task 4 change "started_at" time to less than 24 from your current time and check that this is your air_company_id which you looking for. IF you want to see result
