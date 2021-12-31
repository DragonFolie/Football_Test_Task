# SynergyTestTask


What you need to start the project:

>>>>>>>              Password in mysql bash  is 1234

For running mysql Database.

1) docker run --name synergy_container -p 3307:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql/mysql-server:5.7

2) docker exec -it synergy_container bash
3) mysql -h localhost -u root -p
4) Enter password 1234
5)CREATE USER 'demo_java' IDENTIFIED BY 'java';
   grant all on *.* to 'demo_java'@'%' identified by '1234';
   FLUSH PRIVILEGES;

6) CREATE DATABASE synergy CHARACTER SET utf8 COLLATE utf8_general_ci;
7) use synergy;
8) create and insert data which are in /Data folder  ( *.sql files for insert data)

For running Spring Rest Api

docker image build -t employee-jdbc .

docker-compose up


Additional Information

If project doesnt start run it from IDEA

For task 4 change "started_at" time to less than 24 from your current time and check that this is your air_company_id which you looking for. IF you want to see result
