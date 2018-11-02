SongTrend README

Tested using jdk 1.8.0_171

Note: If you want to include a database with some test data in it, copy the provided file "song-trend.mv.db" to your 
user directory. If not, an empty database ready to be filled with data will automatically be created at application startup.


To run the application go to directory of pom.xml then run command:

mvn spring-boot:run

or build with maven and run spring boot jar file e.g.

mvn clean install
cd /target
java -jar song-trend-1.0-SNAPSHOT.jar


To access the H2 database:
1. Go to http://localhost:8080/h2
2. 
	Driver Class:	org.h2.Driver
	JDBC URL:		jdbc:h2:file:~/song-trend
	User:			sa
	Password:		bigsecret
	
3. Connect


To consume the REST API:
Basic authentication has been implemented. Use credentials
user: user1
pass: superdupersecret

Example request: GET http://localhost:8080/word/?word=type&from=2018-10-09&to=2018-10-11
Example response: 
				{
				   "word": "type",
				   "timeSeries":    [
							{
						 "date": "2018-10-10",
						 "count": 3
					  },
							{
						 "date": "2018-10-11",
						 "count": 3
					  }
				   ]
				}
				
				
Scheduled task
A scheduled task is executed at 12:00 (00:00 PM) each day. The task reads song data from soundcloud api 
and store word count in database. The schedule may be changed in the application.properties file in the project.