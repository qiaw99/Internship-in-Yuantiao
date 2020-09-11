# # demo

## Requirement

Testing environment: **Apache Tomcat - 8.5.57**. Download see [here](https://tomcat.apache.org/download-80.cgi#8.5.57).



## Demo

1. Clone the project

2. Put the folders three.js-master and video under the path "../apache-tomcat-8.5.57\webapps"

3. Run the tomcat server, check whether port 8080 is free, if not use the following instructions: 

   ```powershell
   > netstat -aon | findstr "8080"
   > taskkill /pid xxxxx /f (xxxx is the threadid)
   ```

   

4. Run demo in browser: http://localhost:8080/three.js-master/examples/city.html

