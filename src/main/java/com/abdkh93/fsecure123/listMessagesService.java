package com.abdkh93.fsecure123;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

// The list message service helps to list messages according to the nature of the HTTP request
// Versioning enabled through the same endpoint
// Further instructions given in AppConfig.java

@Path("message")
public class listMessagesService {

    // Provide messages in XML format (version 1)
    @GET
    @Produces("application/v1+json")
    @Consumes("application/v1+json")
    public List<Message> getMessage() {
        return getDetailedMessages();
    }

    // Provide messages in XML and JSON formats (version 2)
    @GET
    @Produces({"application/v2+json", "application/v2+xml"})
    @Consumes({"application/v2+json", "application/v2+xml"})
    @MessageDetailedView
    public List<Message> getDetailedMessages() {
        return MessageStore.getMessages();
    }
}