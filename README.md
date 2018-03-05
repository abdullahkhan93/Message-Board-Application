# Java Web Services: Message Board Application

This project consists of a Java Message Board Application. It comprises of two services, i.e., the createMessage service for creation of messages (JAX-WS - SOAP protocol) and the listMessages for listing all messages persisted in the application (JAX-RS - REST protocol). The listMessages has versioning implemented to show different views based on HTTP Request type.

## 1. Getting Started

The following instructions and commands will be helpful in development and testing purposes on the local machine after the repository has been downloaded.

1. Extract the zip file.
2. Navigate to the project home directory. 
3. Run the build-script.sh file. => Command: <b>bash build-script.sh</b>
4. Copy the newly created WAR file from the target folder generated in the current directory.
5. Paste the WAR file to the webapps/ folder in the Tomcat base directory on the system.
6. Restart the Tomcat server
7. Open browser and enter <i>http://localhost:8080/MessageBoardApp</i>. Check that server is
   up and running.
 
## 2. Instructions

1. To create custom HTTP requests use browser tools, for e.g., Postman
2. To view messages, enter the URL as:  <i>http://localhost:8080/MessageBoardApp/message</i>
   
   - Setting the HTTP Request Headers:
   
     - Request Type: <b>GET</b>  
     - Accept: <b>application/v1+json</b>
     - Content-Type: <b>application/v1+json</b>
     
     <i>Shows the messages without URL field (version 1 of listMessages) in JSON format</i>

     - Accept: <b>application/v2+json</b>
     - Content-Type: <b>application/v2+json</b>
     
     <i>Shows the messages with URL field (version 2 of listMessages) in JSON format</i>

     - Accept: <b>application/v2+xml</b>
     - Content-Type: <b>application/v2+xml</b>
     
     <i>Shows the messages without URL field (version 2 of listMessages) in XML format</i>

3. For the createMessage service, a new message can be added as follows:

   - Set the URL as <i>http://localhost:8090/MessageBoardApp/create</i>

   - Set HTTP Request headers as follows:

     - Request Type: <b>POST</b>
     - Content-Type: <b>text/xml</b>

   - Enter the following content in the Body of the request:
        ```xml
        <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    		<Body>
        		<setMessage xmlns="http://fsecure123.abdkh93.com/">
            			<arg0 xmlns="">(title without quotes)</arg0>
            			<arg1 xmlns="">(content without quotes)</arg1>
            			<arg2 xmlns="">(sender without quotes)</arg2>
            			<arg3 xmlns="">(URL without quotes)</arg3>
        		</setMessage>
    		</Body>
	</Envelope>
	
	<i>Response is shown in XML with a message Signalling whether message has been added or not.</i>

## 4. Assumptions

1. The tomcat plugin for maven has not been configured as it is assumed that the WAR file will be run by copying it. Otherwise the plugin can be specified in the <b><i>pom.xml</i></b> file and the server can be initiated via the following command:

   <b>mvn tomcat:deploy</b>
