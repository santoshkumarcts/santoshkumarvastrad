# santoshkumarvastrad
Crawler-Service

STEPS TO RUN THE JAR																																																			
1.Download the zip/clone the repository from drop-down.
2. Unzip it
3. Run the command "cd Crawler-Service/"
4. Run the command "java -jar target/*.jar"
5. once the application is ready, is running on 8080 port.
6. Open the Rest Plugin, Create Post Request with localhost (if not running docker container) add 8080 port.
Example : POST Request 
URL : http://192.168.99.100:8050/sitemap/url 
Request Body:
{
"url":"https://www.redhat.com/en"
}
Content-Type - application/json
8. Click on Send button to see the result.
