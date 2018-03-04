package com.abdkh93.fsecure123;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

// http://localhost:8080/MessageBoardApp/message --> for listing messages
// Version decided based on the HTTP headers sent in the Request

// Version 1 HTTP Headers:
// Accept: application/v1+json
// Content-Type: application/v1+json

// Version 2 HTTP Headers:

// For JSON:
// Accept: application/v2+json
// Content-Type: application/v2+json

// For XML:
// Accept: application/v2+xml
// Content-Type: application/v2+xml

@ApplicationPath("/MessageBoardApp")
public class AppConfig extends ResourceConfig {

    public AppConfig() throws MalformedURLException {

        System.out.println("Created Application Configuration !!");

        // Include all the neccessary files for run-time
        packages("com.abdkh93.fsecure123");

        // Enable the data filtration feature for messages in case of REST API version 1 and 2
        // Version 1 does not show URL whereas version 2 does.
        register(EntityFilteringFeature.class);
        register(JacksonFeature.class);

        // Publish endpoint for the createMessage (SOAP) service)
        Endpoint.publish("http://localhost:8090/MessageBoardApp/create", new createMessageImp());


        // The code snippet below acts as the client for the createMessage service and adds a sample
        // message.
        URL url = new URL("http://localhost:8090/MessageBoardApp/create?wsdl");

        // 1st argument service URI as mentioned in the wsdl document above
        // 2nd argument is service name as mentioned in the wsdl document above
        QName qname = new QName("http://fsecure123.abdkh93.com/", "createMessageImpService");
        Service service = Service.create(url, qname);
        createMessage createmessage = service.getPort(createMessage.class);

        // Sample message to be added with a notification message on the console for testing purposes
        String result = createmessage.setMessage("Da Best!", "I knew I could code!", "Abdullah", "http://www.google.com");
        System.out.println(result);

    }
}
