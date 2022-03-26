


What you need to start the project:



For running mysql Database.


1) docker-compose up
2) docker exec -it football_manager_db_1 bash ( if "football_manager_db_1" doesnt right name write "docker ps" and find "NAME" column and write correct name )
3) mysql -uroot -proot
4) use footballDB
5) Here you have 3 options which you can do if one of that dont work: 
   1. mysql -uroot -p test_db < school.sql  
   2. source *path to sql script*  
   3. Use sql script in project directory, you can open DataBase_Creation_Script_MySQL.txt file or football_manager.sql
6) Done, you have DB with data

For running Spring Rest Api

docker image build -t football_manager_spring .

docker run -p 8080:8080 football_manager_spring


